package stickman.model.Entity_Folder.Hero_Folder;
import stickman.model.Entity_Folder.*;
import stickman.model.Level_Folder.*;
import stickman.view.End_Screen_Status;

public class Hero implements Entity, Tick, Terrain_interactable, MovingEntity {

    private double XPos;
    private double YPos;
    private double Height;
    private double Width;
    private Size size;
    private Hero_Terrain_interaction terrain_interaction;
    private Hero_Enemy_interaction hero_enemy_interaction;
    private String image = "ch_stand1.png";
    private Hero_movement hero_movement;
    private double starting_x_position;
    private double starting_y_position;
    private FacingDirection facingDirection;
    private Level level;
    private double MaxHeight;
    private boolean Falling;
    private boolean Jumping;
    private boolean goingLeft;
    private boolean goingRight;
    private LevelBehaviour levelBehaviour;
    public Hero(Size size, double start_position, Level level, Level_Type level_type){
        switch (level_type){
            case Ice:
                this.levelBehaviour = new Ice(this);
                break;
            case Windy:
                this.levelBehaviour = new Windy(this);
                break;
            default:
                this.levelBehaviour = new Normal(this);
        }
        this.terrain_interaction = new Hero_Terrain_interaction();
        this.size = size;
        this.XPos = start_position;
        this.starting_x_position = start_position;
        this.hero_movement = new Hero_movement();
        this.hero_enemy_interaction = new Hero_Enemy_interaction();
        this.facingDirection = FacingDirection.RIGHTSTILL;
        this.level = level;
        this.Falling = false;
        this.Jumping = false;
        this.goingLeft = false;
        this.goingRight = false;
        //sorting the size and the starting Y position in respect of the size stated in Json file
        switch (size){
            case Tiny:
                this.Height = 40;
                this.Width = 20;
                break;
            case Normal:
                this.Height = 60;
                this.Width = 30;
                break;
            case Large:
                this.Height = 80;
                this.Width = 40;
                break;
            case Giant:
                this.Height = 100;
                this.Width = 50;
                break;
            default:
                System.out.println("The settings have not been done properly please check the Json File then try again.");
                this.level.finished(End_Screen_Status.Error);


        }
        this.YPos = 334- this.Height;
        this.starting_y_position = this.YPos;
        this.MaxHeight = this.starting_y_position - 150;
    }
    @Override
    public String getImagePath() {
        return image;
    }
    @Override
    public double getXPos() {
        return this.XPos;
    }
    public void setXPos(double XPos){this.XPos = XPos;}
    public void setYPos(double YPos){this.YPos = YPos;}
    @Override
    public double getYPos() {
        return this.YPos;
    }
    @Override
    public double getHeight() {
        return this.Height;
    }
    @Override
    public double getWidth() {
        return this.Width;
    }
    public Size getSize(){return this.size;}
    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void reset(){
        this.XPos = this.starting_x_position;
        this.YPos = this.starting_y_position;
    }
    @Override
    public boolean getstay() {
        return false;
    }
    public void setFacingDirection(FacingDirection facingDirection){
        this.facingDirection = facingDirection;
    }
    public void setMovementDirection(FacingDirection facingDirection) {
        switch(facingDirection){
            case LEFT:
                switch (this.facingDirection){
                    case JUMP: case JUMPLEFT: case JUMPRIGHT:
                        this.facingDirection = FacingDirection.JUMPLEFT;
                        break;
                    default:
                        this.facingDirection = facingDirection;
                        break;
                }
                this.goingLeft = true;
                this.goingRight = false;
                break;
            case RIGHT:
                switch (this.facingDirection){
                    case JUMP: case JUMPRIGHT: case JUMPLEFT:
                        this.facingDirection = FacingDirection.JUMPRIGHT;
                        break;
                    default:
                        this.facingDirection = facingDirection;
                        break;
                }
                this.goingRight = true;
                this.goingLeft = false;
        }
    }
    public FacingDirection getFacingDirection() {
        return facingDirection;
    }
    public void platforminteract(){
        switch (this.terrain_interaction.interact(this, this.level)){
            case Top:
                this.Jumping = false;
                this.Falling = false;
                this.MaxHeight = this.getYPos() - 150;
                break;
            case TopStay:
                if(!this.Jumping){
                    switch (this.facingDirection){
                        case JUMPLEFT:
                            this.facingDirection = FacingDirection.LEFT;
                            break;
                        case JUMPRIGHT:
                            this.facingDirection = FacingDirection.RIGHT;
                            break;
                    }
                }
                break;
            case None:
                if(!this.Jumping && this.YPos < this.level.getFloorHeight() - this.Height){
                    this.Falling = true;
                    this.Jumping = true;
                }
                break;
            case SideLeft:
                this.XPos -= 2;
            case SideRight:
                this.XPos += 1;
        }
    }
    public void enemyInteract(){
        switch (this.hero_enemy_interaction.interact(this, this.level)){
            case Side:
                this.reset();
                this.level.reset();
                break;
            case Top:
                this.MaxHeight = this.YPos - 150;
                this.Jumping = true;
                this.Falling = false;
                break;
        }
    }
    @Override
    public void tick() {
        this.levelBehaviour.do_behaviour();
        if(this.goingLeft){
            this.MoveLeft();
        }
        else if(this.goingRight){
            this.MoveRight();
        }
        else if(!this.Jumping){
            this.StopMoving();
        }
        if(this.Jumping){
            this.jump();
        }
        this.hero_movement.update(this);
        this.platforminteract();
        this.enemyInteract();
    }
    public void MoveLeft(){
        if(this.XPos > 50){
            this.XPos -= 1;
        }
    }
    public void MoveRight(){
        if(this.XPos < 2000 - this.Width){
            this.XPos += 1;
        }
        else if(this.XPos == 2000 - this.Width){
            this.level.setLevelFinished();
            this.level.finished(End_Screen_Status.Won);
        }
    }
    public void jump(){
        if(!this.Falling){
            if(this.YPos > this.MaxHeight){
                this.YPos -= 3;
            }
            else{
                this.Falling = true;
            }
        }
        else{
            if(this.YPos < this.starting_y_position){
                this.YPos += 2;
            }
            else{
                this.YPos = this.starting_y_position;
                this.Falling = false;
                this.MaxHeight = this.YPos - 150;
                this.Jumping = false;
                switch (this.facingDirection){
                    case JUMPLEFT:
                        this.facingDirection = FacingDirection.LEFT;
                        break;
                    case JUMPRIGHT:
                        this.facingDirection = FacingDirection.RIGHT;
                        break;
                }
            }
        }
    }
    public void StopMoving(){
        this.goingLeft = false;
        this.goingRight = false;
        switch (this.facingDirection){
            case LEFT:
                this.facingDirection = FacingDirection.LEFTSTILL;
                break;
            case RIGHT:
                this.facingDirection = FacingDirection.RIGHTSTILL;
                break;
        }
    }
    public boolean SetJump(){
        if(!this.Jumping){
            this.Jumping = true;
            switch(this.facingDirection){
                case LEFT:case LEFTSTILL:
                    this.facingDirection =  FacingDirection.JUMPLEFT;
                    break;
                case RIGHT:case RIGHTSTILL:
                    this.facingDirection = FacingDirection.JUMPRIGHT;
                    break;
            }
            return true;
        }
        return false;
    }
    public boolean getFalling(){
        return this.Falling;
    }
    public boolean getJump(){
        return this.Jumping;
    }
    public boolean isGoingLeft() {
        return goingLeft;
    }
    public boolean isGoingRight() {
        return goingRight;
    }
    public Level getLevel(){return this.level;}
    public LevelBehaviour getLevelBehaviour() {
        return levelBehaviour;
    }
    public Hero_movement getHero_movement() {
        return hero_movement;
    }
    public Hero_Enemy_interaction getHero_enemy_interaction() {
        return hero_enemy_interaction;
    }
    public double getMaxHeight(){return this.MaxHeight;}
    public void setMaxHeight(double MaxHeight){this.MaxHeight = MaxHeight;}
    public Hero_Terrain_interaction getTerrain_interaction() {
        return terrain_interaction;
    }
    public void setFalling(boolean falling) {
        Falling = falling;
    }
}
