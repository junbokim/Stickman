package stickman.view;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import stickman.view.Draw_Entities.BackgroundDrawer;
import stickman.view.Draw_Entities.Background_resolutions;
import stickman.view.Draw_Entities.DrawGrass;
import stickman.view.Draw_Entities.Drawsky;

public class initialBackground implements BackgroundDrawer {
    private Background_resolutions background_resolutions;
    public initialBackground(Background_resolutions background_resolutions){
        this.background_resolutions = background_resolutions;
    }
    @Override
    public void draw(Pane pane) {
        Rectangle sky = new Drawsky(this.background_resolutions).draw();
        Rectangle floor = new DrawGrass(this.background_resolutions).draw();
        pane.getChildren().addAll(sky, floor);
    }
}
