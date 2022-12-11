package stickman.model.Entity_Folder.etc_Folders;

import stickman.model.Entity_Folder.Entity;
import stickman.model.Entity_Folder.Tick;

public class Heart implements Entity, Tick {
    private double XPos;
    private double YPos;
    private double Height;
    private double Width;
    private String ImagePath;
    private int counter;
    private int direction;

    public Heart(int type){
        this.counter = 0;
        this.direction = 5;
        switch(type){
            case 1:
                this.XPos = 0;
                break;
            case 2:
                this.XPos = 30;
                break;
            case 3:
                this.XPos = 60;
                break;
        }
        this.YPos = 5;
        this.Height = 30;
        this.Width = 30;
        this.ImagePath = "heart.png";
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

    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }
    @Override
    public boolean getstay() {
        return true;
    }

    public int getDirection() {
        return direction;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void tick() {
        if(counter == 10){
            this.YPos = this.YPos - this.direction;
            this.direction = -this.direction;
        }
        else{counter += 1;}
    }
}
