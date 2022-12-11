package stickman.view.Draw_Entities;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import stickman.view.DrawBackgroundObjects;

public class DrawTimer implements DrawBackgroundObjects {
    public Text draw(){
        Text timer = new Text();
        timer.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        timer.setX(0);
        timer.setY(45);
        return timer;
    }
}
