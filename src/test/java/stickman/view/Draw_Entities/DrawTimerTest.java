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
public class DrawTimerTest {
    Background_resolutions background_resolutions;
    DrawTimer drawTimer;
    @Before
    public void setUp() throws Exception {
        this.drawTimer = new DrawTimer();
    }

    @Test
    @TestInJfxThread
    public void draw() {
        Text timer = this.drawTimer.draw();
        assertEquals(0,timer.getX(),0.001);
        assertEquals(45,timer.getY(),0.001);
    }
}