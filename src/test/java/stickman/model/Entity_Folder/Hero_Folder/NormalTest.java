package stickman.model.Entity_Folder.Hero_Folder;

import org.junit.Before;
import org.junit.Test;
import stickman.model.Entity_Folder.Hero_Folder.Hero;
import stickman.model.Entity_Folder.Hero_Folder.LevelBehaviour;
import stickman.model.Entity_Folder.Size;
import stickman.model.GameEngineImpl;
import stickman.model.Level_Folder.Current_Level;
import stickman.model.Level_Folder.Level;
import stickman.model.Level_Folder.Level_Type;

import static org.junit.Assert.*;

public class NormalTest {
    private Level level;
    private Hero hero;
    private LevelBehaviour Normal;
    private GameEngineImpl model;
    @Before
    public void setUp() throws Exception {
        this.model = new GameEngineImpl("/Test_Default.json");
        this.level = this.model.getCurrentLevel();
        this.hero = this.level.getProtagonist();
        this.hero.setXPos(601);
        this.Normal = this.hero.getLevelBehaviour();
    }
    @Test
    public void test_if_Normal(){
        assertEquals("Normal",this.hero.getLevelBehaviour().getBehaviour());
    }
    @Test
    public void Text_HeroX_Update(){
        assertEquals(50, this.level.getHeroX(),0.001);
        this.Normal.do_behaviour();
        assertEquals(601, this.level.getHeroX(),0.001);

    }
}