package stickman.view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import stickman.view.Draw_Entities.*;

import java.util.ArrayList;
import java.util.List;

public class End_Screen implements BackgroundDrawer{
    private Background_resolutions background_resolutions;
    public End_Screen(Background_resolutions background_resolutions){
        this.background_resolutions = background_resolutions;
    }
    public void draw(Pane pane){
        List<Node> entities = new ArrayList<>();
        Rectangle sky = new Drawsky(this.background_resolutions).draw();
        entities.add(sky);
        Rectangle floor = new DrawGrass(this.background_resolutions).draw();
        entities.add(floor);
        Text txt;
        Button exit_button;
        Button restart_button;
        if(this.background_resolutions.isError()){
            txt = new DrawText(this.background_resolutions).draw();
            entities.add(txt);
            exit_button = new DrawButton(this.background_resolutions).draw(270,250,"End Game");
            entities.add(exit_button);
        }
        else{
            txt = new DrawText(this.background_resolutions).draw();
            entities.add(txt);
            exit_button = new DrawButton(this.background_resolutions).draw(150,250,"End Game");
            entities.add(exit_button);
            restart_button = new DrawButton(this.background_resolutions).draw(400,250,"Try again");
            entities.add(restart_button);
        }
        pane.getChildren().addAll(entities);
    }
}
