package stickman.model.Entity_Folder.Clouds;

import stickman.model.Entity_Folder.Entity;
import stickman.model.Entity_Folder.Tick;

public class Cloud implements Entity, Tick {
    private double XPos;
    private double YPos;
    private double Height;
    private double Width;
    private double Velocity;
    private String ImagePath;
    public Cloud(double Velocity, double start_position_x, double start_position_y, String image){
        this.Width = 95;
        this.Height = 23;
        this.XPos = start_position_x;
        this.YPos = start_position_y;
        this.Velocity = Velocity;
        this.ImagePath = image;
    }

    // to get the image to print
    @Override
    public String getImagePath() {
        return ImagePath;
    }

    //X, Y coordinate of the object Cloud
    @Override
    public double getXPos() {
        return this.XPos;
    }
    @Override
    public double getYPos() {
        return (short) this.YPos;
    }

    //getting Height and Width of the object Cloud
    @Override
    public double getHeight() {
        return this.Height;
    }

    @Override
    public double getWidth() {
        return this.Width;
    }

    //Which Layer to associate the object Cloud with
    @Override
    public Layer getLayer() {
        return Layer.BACKGROUND;
    }

    //Setting X positions
    public void setXPos(double value){
        this.XPos = value;
    }

    public double getVelocity(){return this.Velocity;}

    public void tick(){
        this.XPos+=this.Velocity ;
        // if cloud moves to the end reset the location to go back.
        if(this.Velocity < 0){
            if(this.XPos <-100){
                this.XPos = 2300;
            }
        }
        if(this.XPos >= 2400){
            this.XPos=-50;
        }
    }

    @Override
    public boolean getstay() {
        return false;
    }
}
