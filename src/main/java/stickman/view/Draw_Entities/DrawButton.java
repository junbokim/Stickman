package stickman.view.Draw_Entities;

import javafx.scene.control.Button;
import stickman.App;

public class DrawButton {
    private Background_resolutions background_resolutions;
    public DrawButton(Background_resolutions background_resolutions){
        this.background_resolutions = background_resolutions;
    }
    public Button draw(int x, int y, String text){
        Button button = new Button(text);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setMinSize(this.background_resolutions.getButton_Width(),this.background_resolutions.getButton_Height());
        if(text.equals("End Game")){
            button.setOnAction(actionEvent -> {
                App.end();});
        }
        if(text.equals("Try again")){
            button.setOnAction(actionEvent -> {App.restart();});
        }
        return button;
    }
}
