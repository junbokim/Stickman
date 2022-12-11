package stickman.view.Draw_Entities;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import stickman.model.Level_Folder.Level_Type;
import stickman.view.DrawBackgroundObjects;

public class DrawGrass implements DrawBackgroundObjects {
    private double Height;
    private double Width;
    private double FloorHeight;
    private boolean Ice;
    public DrawGrass(Background_resolutions background_resolutions){
        this.Height = background_resolutions.getHeight();
        this.Width = background_resolutions.getWidth();
        this.FloorHeight = background_resolutions.getFloorHeight();
        this.Height = background_resolutions.getHeight() - this.FloorHeight;
        if(!background_resolutions.isError()){
            this.Ice = (background_resolutions.getModel().getCurrentLevel().getLevel_type().equals(Level_Type.Ice));
        }
        else{
            this.Ice = false;
        }
    }
    public Rectangle draw(){
        Rectangle grass = new Rectangle(0, this.FloorHeight, this.Width,  this.Height);
        if(Ice){
            grass.setFill(Paint.valueOf("LIGHTBLUE"));
        }
        else{
            grass.setFill(Paint.valueOf("GREEN"));
        }
        grass.setViewOrder(1000.0);
        return grass;
    }
}
