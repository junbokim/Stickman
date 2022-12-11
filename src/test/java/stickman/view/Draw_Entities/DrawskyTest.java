package stickman.view.Draw_Entities;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import stickman.model.GameEngineImpl;

import static org.junit.Assert.*;

public class DrawskyTest {
    Background_resolutions background_resolutions;
    Drawsky drawsky;
    @Before
    public void setUp() throws Exception {
        GameEngineImpl model = new GameEngineImpl("/Test_Default.json");
        this.background_resolutions = new Background_resolutions(model,640,400);
        this.drawsky = new Drawsky(background_resolutions);
    }
    @Test
    public void draw() {
        Rectangle sky = this.drawsky.draw();
        assertEquals(Paint.valueOf("LIGHTBLUE"), sky.getFill());
        assertEquals(0, sky.getX(),0.001);
        assertEquals(0, sky.getY(),0.001);
        assertEquals(this.background_resolutions.getWidth(), sky.getWidth(),0.001);
        assertEquals(this.background_resolutions.getHeight(), sky.getHeight(),0.001);
    }
}