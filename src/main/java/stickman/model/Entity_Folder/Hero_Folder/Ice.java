package stickman.model.Entity_Folder.Hero_Folder;

import stickman.model.Entity_Folder.MovingEntity;

public class Ice implements LevelBehaviour {
    private int index;
    private FacingDirection lastdirection;
    private boolean start;
    private Normal normal;
    private Hero hero;
    private String behaviour;
    public Ice(Hero hero){
        this.start = true;
        this.hero = hero;
        this.index = 0;
        this.lastdirection = FacingDirection.JUMP;
        this.behaviour = "Ice";
        this.normal = new Normal(this.hero);
    }
    public String getBehaviour(){
        return this.behaviour;
    }
    @Override
    public void do_behaviour() {
        if(!this.start && !this.hero.getJump()){
            switch(this.hero.getFacingDirection()){
                case RIGHTSTILL:
                    switch(this.lastdirection){
                        case RIGHTSTILL:
                            if(this.index < 60){
                                for(MovingEntity entity: this.hero.getLevel().getMovingEntities()){
                                    entity.MoveRight();
                                    entity.platforminteract();
                                }
                                this.index += 1;
                                break;
                            }
                            break;
                    }
                    break;
                case LEFTSTILL:
                    switch(this.lastdirection){
                        case LEFTSTILL:
                            if(this.index < 60){
                                for(MovingEntity entity: this.hero.getLevel().getMovingEntities()){
                                    entity.MoveLeft();
                                    entity.platforminteract();
                                }
                                this.index += 1;
                                break;
                            }
                            break;
                    }
                    break;
                default:
                    this.index = 0;
                    break;

            }
        }
        else{
            if(!this.hero.getFacingDirection().equals(FacingDirection.RIGHTSTILL)){
                this.start = false;
                this.index = 0;
            }
        }
        this.normal.do_behaviour();
        this.lastdirection = this.hero.getFacingDirection();
    }
    public boolean getStart(){return this.start;}
    public void setLastdirection(FacingDirection lastdirection) {
        this.lastdirection = lastdirection;
    }
    public void setStart(boolean start) {
        this.start = start;
    }
    public int getIndex(){return this.index;}
}
