package stickman.view.Draw_Entities;

import stickman.model.GameEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class Background_resolutions {
    private GameEngine model;
    private double Width;
    private double Height;
    private String Text;
    private double Button_Height;
    private double Button_Width;
    private double FloorHeight;
    private boolean Error;
    private double TextXLocation;
    public Background_resolutions(double Width, double Height){
        this.FloorHeight = 334;
        this.Width = Width;
        this.Height = Height;
        this.Button_Height = 65;
        this.Button_Width = 115;
        this.Error = true;
        this.TextXLocation = 110;
    }
    public Background_resolutions(GameEngine model, double Width, double Height){
        this.Error = false;
        this.model = model;
        this.FloorHeight = model.getCurrentLevel().getFloorHeight();
        this.Width = Width;
        this.Height = Height;
        this.Button_Height = 65;
        this.Button_Width = 115;
        this.TextXLocation = 90;
        this.Text = "this is a default value and would change when it is appropriate!";
    }

    public double getHeight() {
        return Height;
    }

    public double getWidth() {
        return Width;
    }

    public GameEngine getModel() {
        return model;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getText() {
        return Text;
    }

    public double getButton_Height() {
        return Button_Height;
    }
    public double getButton_Width() {
        return Button_Width;
    }
    public double getFloorHeight(){return this.FloorHeight;}

    public boolean isError() {
        return Error;
    }

    public double getTextXLocation() {
        return TextXLocation;
    }
}
