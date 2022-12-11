package stickman.model.Entity_Folder.Slime;

import stickman.model.Entity_Folder.Jump;

public class Slime_Jumpy implements Slime_behaviours{
    private int tickCounter;
    private double groundY;
    private double maxHeight;
    private boolean setJump;
    private boolean Falling;
    private Enemy enemy;
    public Slime_Jumpy(double initial_y_position, Enemy enemy){
        this.setJump = false;
        this.tickCounter = 0;
        this.groundY = initial_y_position;
        this.maxHeight = this.groundY - 102;
        this.Falling = false;
        this.enemy = enemy;
    }
    @Override
    public void do_behaviour() {
        if(this.enemy.Left){
            this.enemy.MoveLeft();
        }
        else{
            this.enemy.MoveRight();
        }
        if(this.tickCounter >= 200 && enemy.getYPos() == groundY){
            this.setJump = true;
            this.tickCounter = 0;
        }
        else{this.tickCounter += 1;}
        if(this.setJump && this.tickCounter%2 == 0){
            jump();
        }
    }
    public void jump(){
        if(!this.Falling){
            if(this.enemy.YPos > this.maxHeight){
                this.enemy.YPos -=3;
            }
            else{
                this.Falling = true;
            }
        }
        else{
            if(this.enemy.YPos < this.groundY){
                this.enemy.YPos += 2;
            }
            else{
                this.enemy.YPos = this.groundY;
                this.Falling = false;
                this.setJump = false;
                this.tickCounter = 0;
            }
        }
    }
    public boolean isSetJump() {
        return setJump;
    }

    public boolean isFalling() {
        return Falling;
    }

    public int getTickCounter() {
        return tickCounter;
    }
}
