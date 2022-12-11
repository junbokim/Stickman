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

public class WindyTest {
    private Level level;
    private LevelBehaviour windy;
    private Hero hero;
    private GameEngineImpl model;
    @Before
    public void setUp() throws Exception {
        this.model = new GameEngineImpl("/Windy.json");
        this.level = this.model.getCurrentLevel();
        this.hero = this.level.getProtagonist();
        this.hero.setXPos(601);
        this.windy = this.hero.getLevelBehaviour();
    }
    @Test
    public void test_if_Windy(){
        assertEquals("Windy",this.hero.getLevelBehaviour().getBehaviour());
    }
    @Test
    public void do_behaviour() {
        //initial Xposition
        assertEquals(601,this.level.getProtagonist().getXPos(),0.001);
        // after running the behaviour three times for the activation of behaviour;
        for(int i = 0; i<4;i++){
            this.windy.do_behaviour();
        }
        //after activation, the Xvalue of the hero should have moved back
        assertEquals(600, this.level.getProtagonist().getXPos(),0.001);

        for(int i = 0; i<4;i++){
            this.windy.do_behaviour();
        }
        //after another activation, it should have stayed because there is a block stopping it from moving further
        assertEquals(600, this.level.getProtagonist().getXPos(),0.001);
    }
    @Test
    public void getBehaviour(){
        assertEquals("Windy", this.hero.getLevelBehaviour().getBehaviour());
    }
}