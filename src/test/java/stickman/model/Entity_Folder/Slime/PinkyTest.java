package stickman.model.Entity_Folder.Slime;

import org.junit.Before;
import org.junit.Test;
import stickman.model.Entity_Folder.Size;
import stickman.model.Level_Folder.Current_Level;
import stickman.model.Level_Folder.Level;
import stickman.model.Level_Folder.Level_Type;

import static org.junit.Assert.*;

public class PinkyTest {
    private Pinky enemy;
    private Level level;
    private Slime_normal behaviour;
    @Before
    public void setUp() throws Exception {
        this.level = new Current_Level(Size.Normal,50,3.2, Level_Type.Normal);
        this.enemy = (Pinky) this.level.getEnemies().get(0);
        this.behaviour = (Slime_normal) this.enemy.getBehaviours();
    }

    @Test
    public void Test_Instantiation(){
        assertEquals(this.behaviour,this.enemy.getBehaviours());
        assertEquals(1300, this.enemy.getXPos(),0.001);
        assertEquals(314, this.enemy.getYPos(),0.001);
        assertFalse(this.enemy.getLeft());
        assertFalse(this.enemy.getFalling());
        assertEquals(20, this.enemy.getHeight(),0.001);
        assertEquals(35,this.enemy.getWidth(),0.001);
        assertEquals("slimeRa.png",this.enemy.getImagePath());
        assertEquals(1,this.enemy.getSpeed(),0.001);
        assertEquals(this.behaviour, this.enemy.getBehaviours());
    }
    @Test
    public void switchImage() {
        assertEquals("slimeRa.png", this.enemy.getImagePath());
        this.enemy.switchImage();
        assertEquals("slimeRb.png", this.enemy.getImagePath());
    }

    @Test
    public void tick() {
        assertEquals(1300,this.enemy.getXPos(),0.001);
        this.enemy.tick();
        assertEquals(1301,this.enemy.getXPos(),0.001);
        for(int i =0;i<165;i++){
            this.enemy.tick();
        }
        assertEquals(1466,this.enemy.getXPos(),0.001);
        assertTrue(this.enemy.getLeft());
        for(int i =0;i<168;i++){
            this.enemy.tick();
        }
        assertEquals(1300,this.enemy.getXPos(),0.001);
        assertFalse(this.enemy.getLeft());
    }
}