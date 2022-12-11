package stickman.view.Draw_Entities;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import stickman.view.DrawBackgroundObjects;

public class Drawsky implements DrawBackgroundObjects {
    private double Height;
    private double Width;
    private double FloorHeight;
    public Drawsky(Background_resolutions background_resolutions){
        this.Height = background_resolutions.getHeight();
        this.Width = background_resolutions.getWidth();
    }
    public Rectangle draw(){
        Rectangle sky = new Rectangle(0, 0, this.Width, this.Height);
        sky.setFill(Paint.valueOf("LIGHTBLUE"));
        sky.setViewOrder(1000.0);
        return sky;
    }
}
