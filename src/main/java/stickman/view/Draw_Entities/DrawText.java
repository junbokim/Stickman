package stickman.view.Draw_Entities;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import stickman.view.DrawBackgroundObjects;


public class DrawText implements DrawBackgroundObjects {
    private Background_resolutions background_resolutions;
    public DrawText(Background_resolutions background_resolutions){
        this.background_resolutions = background_resolutions;
    }
    public Text draw(){
        Text txt = new Text(this.background_resolutions.getTextXLocation(),100, this.background_resolutions.getText());
        txt.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        txt.setTextAlignment(TextAlignment.CENTER);
        txt.setFill(Color.valueOf("LAVENDERBLUSH"));
        return txt;
    }
}
