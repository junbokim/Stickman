package stickman.view.Draw_Entities;

import de.saxsys.javafx.test.JfxRunner;
import de.saxsys.javafx.test.TestInJfxThread;
import javafx.scene.text.Text;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import stickman.model.GameEngineImpl;

import static org.junit.Assert.*;
@RunWith(JfxRunner.class)
public class DrawTextTest {
    Background_resolutions background_resolutions;
    DrawText drawText;
    @Before
    public void setUp() throws Exception {
        GameEngineImpl model = new GameEngineImpl("/Test_Default.json");
        this.background_resolutions = new Background_resolutions(model,640,400);
        this.drawText = new DrawText(background_resolutions);
    }

    @Test
    @TestInJfxThread
    public void draw() {
        Text text = this.drawText.draw();
        assertEquals("this is a default value and would change when it is appropriate!", text.getText());
        background_resolutions.setText("TestTest");
        Text text_2 = this.drawText.draw();
        assertEquals("TestTest", text_2.getText());
    }
}