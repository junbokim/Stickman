package stickman.model.Entity_Folder.Hero_Folder;

import org.junit.Before;
import org.junit.Test;
import stickman.model.Entity_Folder.Hero_Folder.FacingDirection;
import stickman.model.Entity_Folder.Hero_Folder.Hero;
import stickman.model.Entity_Folder.Hero_Folder.Ice;
import stickman.model.Entity_Folder.Size;
import stickman.model.GameEngineImpl;
import stickman.model.Level_Folder.Current_Level;
import stickman.model.Level_Folder.Level;
import stickman.model.Level_Folder.Level_Type;

import static org.junit.Assert.*;

public class IceTest {
    private Level level;
    private Hero hero;
    private stickman.model.Entity_Folder.Hero_Folder.Ice Ice;
    private GameEngineImpl model;
    @Before
    public void setUp() throws Exception {
        this.model = new GameEngineImpl("/Ice.json");
        this.level = this.model.getCurrentLevel();
        this.hero = this.level.getProtagonist();
        this.Ice =  (Ice) this.hero.getLevelBehaviour();
    }
    @Test
    public void test_if_Ice(){
        assertEquals("Ice",this.model.getCurrentLevel().getProtagonist().getLevelBehaviour().getBehaviour());
    }
    @Test
    public void Started(){
        assertTrue(this.Ice.getStart());
        this.hero.setFacingDirection(FacingDirection.RIGHT);
        this.Ice.do_behaviour();
        assertFalse(this.Ice.getStart());
    }
    @Test
    public void Right_Drift_normal(){
        this.Ice.setStart(false);
        this.Ice.setLastdirection(FacingDirection.RIGHTSTILL);
        this.hero.setFacingDirection(FacingDirection.RIGHTSTILL);
        for(int i = 0; i < 61;i++){
            this.Ice.do_behaviour();
        }
        assertEquals(110, this.level.getHeroX(),0.001);
    }
    @Test
    public void Left_Drift_normal(){
        this.hero.setXPos(150);
        this.Ice.setStart(false);
        this.Ice.setLastdirection(FacingDirection.LEFTSTILL);
        this.hero.setFacingDirection(FacingDirection.LEFTSTILL);
        for(int i = 0; i < 61;i++){
            this.Ice.do_behaviour();
        }
        assertEquals(90, this.level.getHeroX(),0.001);
    }
    @Test
    public void Right_Drift_Terrain_Interaction(){
        this.hero.setXPos(500);
        this.Ice.setStart(false);
        this.Ice.setLastdirection(FacingDirection.RIGHTSTILL);
        this.hero.setFacingDirection(FacingDirection.RIGHTSTILL);
        for(int i = 0; i < 61;i++){
            this.Ice.do_behaviour();
        }
        assertEquals(520, this.level.getHeroX(),0.001);
    }
    @Test
    public void Left_Drift_Terrain_Interaction(){
        this.hero.setXPos(650);
        this.Ice.setStart(false);
        this.Ice.setLastdirection(FacingDirection.LEFTSTILL);
        this.hero.setFacingDirection(FacingDirection.LEFTSTILL);
        for(int i = 0; i < 61;i++){
            this.Ice.do_behaviour();
        }
        assertEquals(600, this.level.getHeroX(),0.001);
    }
    @Test
    public void Jumping_While_Drifting_Left(){
        this.hero.setXPos(300);
        this.Ice.setStart(false);
        this.Ice.setLastdirection(FacingDirection.LEFTSTILL);
        this.hero.setFacingDirection(FacingDirection.LEFTSTILL);
        for(int i = 0; i < 30;i++){
            this.Ice.do_behaviour();
        }
        this.hero.setFacingDirection(FacingDirection.JUMPRIGHT);
        for(int i = 0; i < 30;i++){
            this.Ice.do_behaviour();
        }
        assertEquals(270, this.level.getHeroX(),0.001);
    }
    @Test
    public void Jumping_While_Drifting_Right(){
        this.Ice.setStart(false);
        this.Ice.setLastdirection(FacingDirection.RIGHTSTILL);
        this.hero.setFacingDirection(FacingDirection.RIGHTSTILL);
        for(int i = 0; i < 30;i++){
            this.Ice.do_behaviour();
        }
        this.hero.setFacingDirection(FacingDirection.JUMPLEFT);
        assertEquals(80, this.level.getHeroX(),0.001);
    }
    @Test
    public void getBehaviour(){
        assertEquals("Ice", this.hero.getLevelBehaviour().getBehaviour());
    }

    @Test
    public void sliding_Right_Then_Turning_Left(){
        this.Ice.setStart(false);
        this.Ice.setLastdirection(FacingDirection.RIGHTSTILL);
        this.hero.setFacingDirection(FacingDirection.RIGHTSTILL);
        for(int i = 0; i < 30;i++){
            this.Ice.do_behaviour();
        }
        this.hero.setFacingDirection(FacingDirection.LEFT);
        this.Ice.do_behaviour();
        assertEquals(0,this.Ice.getIndex());
        assertEquals(80, this.level.getHeroX(),0.001);
    }
    @Test
    public void sliding_Left_Then_Turning_Right(){
        this.Ice.setStart(false);
        this.hero.setXPos(300);
        this.Ice.setLastdirection(FacingDirection.LEFTSTILL);
        this.hero.setFacingDirection(FacingDirection.LEFTSTILL);
        for(int i = 0; i < 30;i++){
            this.Ice.do_behaviour();
        }
        this.hero.setFacingDirection(FacingDirection.RIGHT);
        this.Ice.do_behaviour();
        assertEquals(0,this.Ice.getIndex());
        assertEquals(270, this.level.getHeroX(),0.001);
    }

}