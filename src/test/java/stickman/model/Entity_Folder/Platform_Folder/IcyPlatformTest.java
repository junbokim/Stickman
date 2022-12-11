package stickman.model.Entity_Folder.Platform_Folder;

import org.junit.Before;
import org.junit.Test;
import stickman.model.Entity_Folder.Entity;
import stickman.model.Entity_Folder.Size;
import stickman.model.Level_Folder.Current_Level;
import stickman.model.Level_Folder.Level;
import stickman.model.Level_Folder.Level_Type;

import java.util.List;

import static org.junit.Assert.*;

public class IcyPlatformTest {
    private Level level;
    private List<Platform> platforms;
    @Before
    public void setUp() throws Exception {
        this.level = new Current_Level(Size.Normal,50,3.2, Level_Type.Ice);
        this.platforms = this.level.getPlatforms();
    }

    @Test
    public void PlatformMaker(){
        PlatformFactory platformFactory = new PlatformFactory(this.level);
        assertEquals(World_State.Ice, platformFactory.getWorld_state());
    }
    @Test
    public void getImagePath() {
        for(Platform platform: this.platforms){
            assertEquals("Ice_Platform.png",platform.getImagePath());
        }
    }

    @Test
    public void getXPos() {
        assertEquals(-150, this.platforms.get(0).getXPos(),0.001);
        assertEquals(2000, this.platforms.get(this.platforms.size()-1).getXPos(),0.001);
    }

    @Test
    public void getYPos() {
        assertEquals(134, this.platforms.get(0).getYPos(),0.001);
        assertEquals(284, this.platforms.get(1).getYPos(),0.001);
        assertEquals(234, this.platforms.get(2).getYPos(),0.001);
    }

    @Test
    public void getHeight() {
        assertEquals(200, this.platforms.get(0).getHeight(),0.001);
        assertEquals(50, this.platforms.get(1).getHeight(),0.001);
        assertEquals(100, this.platforms.get(2).getHeight(),0.001);
    }

    @Test
    public void getWidth() {
        assertEquals(200, this.platforms.get(0).getWidth(),0.001);
        assertEquals(50, this.platforms.get(1).getWidth(),0.001);
        assertEquals(100, this.platforms.get(2).getWidth(),0.001);
    }

    @Test
    public void getLayer() {
        for(Platform platform: this.platforms){
            assertEquals(Entity.Layer.BACKGROUND, platform.getLayer());
        }
    }

    @Test
    public void getstay() {
        for(Platform platform: this.platforms){
            assertFalse(platform.getstay());
        }
    }
}