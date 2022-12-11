package stickman.model.Entity_Folder.Slime;

import stickman.model.Entity_Folder.*;
import stickman.model.Level_Folder.Level;

public abstract class Enemy implements Entity, Tick, Terrain_interactable, MovingEntity {
    protected double XPos;
    protected double YPos;
    protected double Height;
    protected double Width;
    protected boolean Left;
    protected String ImagePath;
    protected boolean Falling;
    protected double Speed;
    protected Enemy_Terrain_interaction terrain_interaction;
    protected int tickcount;
    protected Slime_behaviours behaviours;
    protected Level level;
    Enemy(Size size, double startingxPosition, Level level){
        this.Left = false;
        this.Falling = false;
        this.tickcount = 0;
        this.level = level;
        switch(size){
            case Tiny:
                this.Width = 35;
                this.Height = 20;
                break;
            case Normal:
                this.Width = 50;
                this.Height = 40;
                break;
        }
        this.XPos = startingxPosition;
        this.YPos = 334 - this.Height;
        this.terrain_interaction = new Enemy_Terrain_interaction();
    }
    @Override
    public String getImagePath() {
        return this.ImagePath;
    }
    @Override
    public double getXPos() {
        return this.XPos;
    }
    @Override
    public double getYPos() {
        return (short) this.YPos;
    }
    @Override
    public double getHeight() {
        return (short) this.Height;
    }
    @Override
    public double getWidth() {
        return (short) this.Width;
    }
    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }
    @Override
    public boolean getstay() {
        return false;
    }
    public void setXPos(double XPos) {
        this.XPos = XPos;
    }
    public void setYPos(double YPos) {
        this.YPos = YPos;
    }
    public void setFalling(boolean Falling){this.Falling = Falling;}
    public abstract void switchImage();
    public void MoveRight(){
        this.XPos += this.Speed;
    }
    public void MoveLeft(){
        this.XPos -= this.Speed;
    }
    public abstract void tick();
    public boolean getFalling(){
        return this.Falling;
    }
    public void platforminteract() {
        switch(this.terrain_interaction.interact(this,this.level)){
            case Side:
                this.Left = !this.Left;
        }
    }
    public double getSpeed() {
        return Speed;
    }
    public Slime_behaviours getBehaviours(){
        return this.behaviours;
    }
    public boolean getLeft(){return this.Left;}
}
