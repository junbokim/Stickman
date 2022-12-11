package stickman.model.Entity_Folder.Platform_Folder;

import stickman.model.Entity_Folder.Entity;
import stickman.model.Entity_Folder.Size;

public class IcyPlatform implements Platform {
    private double XPos;
    private double YPos;
    private double Height;
    private double Width;
    public IcyPlatform(Size size, double start_position){
        this.XPos = start_position;
        switch (size){
            case Normal:
                this.Width = 50;
                this.Height = 50;
                break;
            case Large:
                this.Width = 100;
                this.Height = 100;
                break;
            case Giant:
                this.Width = 200;
                this.Height = 200;
                break;

        }
        this.YPos = 334-this.Height;


    }
    //Getting Image for the object Floor
    @Override
    public String getImagePath() {
        return "Ice_Platform.png";
    }

    //Getting X and Y position of the object Floor
    @Override
    public double getXPos() {
        return this.XPos;
    }

    @Override
    public double getYPos() {
        return this.YPos;
    }

    //Getting Size of the Floor cube
    @Override
    public double getHeight() {
        return this.Height;
    }

    @Override
    public double getWidth() {
        return this.Width;
    }

    //Setting what Layer to associate Floor with
    @Override
    public Layer getLayer() {
        return Layer.BACKGROUND;
    }

    @Override
    public boolean getstay() {
        return false;
    }
}
