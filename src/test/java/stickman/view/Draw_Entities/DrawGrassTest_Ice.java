package stickman.view.Draw_Entities;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import stickman.model.GameEngineImpl;

import static org.junit.Assert.*;

public class DrawGrassTest_Ice {
    Background_resolutions background_resolutions;
    DrawGrass drawGrass;
    @Before
    public void setUp() throws Exception {
        GameEngineImpl model = new GameEngineImpl("/Ice.json");
        this.background_resolutions = new Background_resolutions(model,640,400);
        this.drawGrass = new DrawGrass(background_resolutions);
    }
    @Test
    public void draw() {
        Rectangle grass = this.drawGrass.draw();
        assertEquals(Paint.valueOf("LIGHTBLUE"), grass.getFill());
        assertEquals(0, grass.getX(),0.001);
        assertEquals(this.background_resolutions.getFloorHeight(), grass.getY(),0.001);
        assertEquals(this.background_resolutions.getWidth(), grass.getWidth(),0.001);
        assertEquals(this.background_resolutions.getHeight() - this.background_resolutions.getFloorHeight(), grass.getHeight(),0.001);
    }
}