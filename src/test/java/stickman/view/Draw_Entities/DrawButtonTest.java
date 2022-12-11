package stickman.view.Draw_Entities;

import de.saxsys.javafx.test.JfxRunner;
import de.saxsys.javafx.test.TestInJfxThread;
import javafx.scene.text.Text;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import stickman.model.GameEngineImpl;
import javafx.scene.control.Button;

import java.awt.*;

import static org.junit.Assert.*;
@RunWith(JfxRunner.class)
public class DrawButtonTest {
    Background_resolutions background_resolutions;
    DrawButton drawButton;
    @Before
    public void setUp() throws Exception {
        GameEngineImpl model = new GameEngineImpl("/Test_Default.json");
        this.background_resolutions = new Background_resolutions(model,640,400);
        this.drawButton = new DrawButton(background_resolutions);
    }

    @Test
    @TestInJfxThread
    public void draw() {
        Button button = this.drawButton.draw(50,50,"Hello");
        assertEquals("Hello", button.getText());
        assertEquals(50,button.getLayoutX(),0.001);
        assertEquals(50,button.getLayoutY(),0.001);
        Button button_2 = this.drawButton.draw(50,50,"End Game");
        assertEquals("End Game", button_2.getText());
        assertEquals(50,button_2.getLayoutX(),0.001);
        assertEquals(50,button_2.getLayoutY(),0.001);
        Button button_3 = this.drawButton.draw(50,50,"Try again");
        assertEquals("Try again", button_3.getText());
        assertEquals(50,button_3.getLayoutX(),0.001);
        assertEquals(50,button_3.getLayoutY(),0.001);
    }
}