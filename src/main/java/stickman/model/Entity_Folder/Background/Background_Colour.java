package stickman.model.Entity_Folder.Background;

import stickman.model.Entity_Folder.Entity;

public class Background_Colour implements Entity {
    private double XPos;
    private double YPos;
    private double Height;
    private double Width;
    private String ImagePath;
    public Background_Colour(String image){
        this.Width = 2200;
        this.Height = 334;
        this.XPos = 0;
        this.YPos = 0;
        this.ImagePath = image;
    }
    @Override
    public String getImagePath() {
        return this.ImagePath;
    }

    @Override
    public boolean getstay() {
        return false;
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
        return Layer.BACKGROUND;
    }
}
