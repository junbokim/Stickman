package stickman.view.Draw_Entities;

import org.junit.Before;
import org.junit.Test;
import stickman.model.GameEngineImpl;

import static org.junit.Assert.*;

public class Background_resolutionsTest_Normal {
    Background_resolutions background_resolutions;
    GameEngineImpl model;
    @Before
    public void setUp() throws Exception {
        this.model = new GameEngineImpl("/Test_Default.json");
        this.background_resolutions = new Background_resolutions(model,640,400);
    }

    @Test
    public void getHeight() {
        assertEquals(400,this.background_resolutions.getHeight(),0.001);
    }

    @Test
    public void getWidth() {
        assertEquals(640, this.background_resolutions.getWidth(),0.001);
    }

    @Test
    public void getModel() {
        assertEquals(this.model, this.background_resolutions.getModel());
    }

    @Test
    public void setText_And_getText() {
        this.background_resolutions.setText("hello");
        assertEquals("hello", this.background_resolutions.getText());
    }

    @Test
    public void getButton_Height_and_Width() {
        assertEquals(65, this.background_resolutions.getButton_Height(), 0.001);
        assertEquals(115, this.background_resolutions.getButton_Width(), 0.001);
    }

    @Test
    public void getFloorHeight() {
        assertEquals(334, this.background_resolutions.getFloorHeight(),0.001);
    }

    @Test
    public void isError() {
        assertFalse(this.background_resolutions.isError());
    }

    @Test
    public void getTextXLocation() {
        assertEquals(90, this.background_resolutions.getTextXLocation(),0.001);
    }
}