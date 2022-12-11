package stickman.model.Entity_Folder.Platform_Folder;

import org.junit.Before;
import org.junit.Test;
import stickman.model.Entity_Folder.Size;
import stickman.model.Level_Folder.Current_Level;
import stickman.model.Level_Folder.Level;
import stickman.model.Level_Folder.Level_Type;

import java.util.List;

import static org.junit.Assert.*;

public class GrassyPlatformTest {
    private Level level;
    private List<Platform> platforms;
    @Before
    public void setUp() throws Exception {
        this.level = new Current_Level(Size.Normal,50,3.2, Level_Type.Normal);
        this.platforms = this.level.getPlatforms();
    }

    @Test
    public void PlatformMaker(){
        PlatformFactory platformFactory = new PlatformFactory(this.level);
        assertEquals(World_State.Normal, platformFactory.getWorld_state());
    }
    @Test
    public void getImagePath() {
        for(Platform platform: this.platforms){
            assertEquals("foot_tile.png", platform.getImagePath());
        }
    }
}