package stickman.model.Entity_Folder.Hero_Folder;

import org.junit.Before;
import org.junit.Test;
import stickman.model.Entity_Folder.Entity;
import stickman.model.Entity_Folder.Size;
import stickman.model.Entity_Folder.Whichside;
import stickman.model.Level_Folder.Current_Level;
import stickman.model.Level_Folder.Level;
import stickman.model.Level_Folder.Level_Type;

import static org.junit.Assert.*;

public class HeroTest {
    private Level level;
    private Hero hero;

    @Before
    public void setUp() throws Exception {
        this.level = new Current_Level(Size.Normal, 50,55, Level_Type.Normal);
        this.hero = this.level.getProtagonist();
    }

    @Test
    public void default_getImagePath() {
        assertEquals("ch_stand1.png", this.hero.getImagePath());
    }

    @Test
    public void facing_left_Image_Update() {
        this.hero.setFacingDirection(FacingDirection.LEFTSTILL);
        this.hero.getHero_movement().update(this.hero);
        assertEquals("ch_stand4.png", this.hero.getImagePath());
    }

    @Test
    public void facing_Right_Image_Update() {
        facing_left_Image_Update();
        assertEquals("ch_stand4.png", this.hero.getImagePath());
        this.hero.setFacingDirection(FacingDirection.RIGHTSTILL);
        this.hero.getHero_movement().update(this.hero);
        assertEquals("ch_stand1.png", this.hero.getImagePath());
    }

    @Test
    public void moving_Right_Image_Update() {
        this.hero.setFacingDirection(FacingDirection.RIGHT);
        for(int i =0;i<11;i++){
            this.hero.getHero_movement().update(this.hero);
        }
        assertEquals("ch_walk1.png", this.hero.getImagePath());
        for(int i =0;i<11;i++){
            this.hero.getHero_movement().update(this.hero);
        }
        assertEquals("ch_walk2.png", this.hero.getImagePath());
        for(int i =0;i<11;i++){
            this.hero.getHero_movement().update(this.hero);
        }
        assertEquals("ch_walk3.png", this.hero.getImagePath());
        for(int i =0;i<11;i++){
            this.hero.getHero_movement().update(this.hero);
        }
        assertEquals("ch_walk4.png", this.hero.getImagePath());
        for(int i =0;i<11;i++){
            this.hero.getHero_movement().update(this.hero);
        }
        assertEquals("ch_walk1.png", this.hero.getImagePath());
    }

    @Test
    public void Walking_Left_Image_Update() {
        this.hero.setXPos(300);
        this.hero.setFacingDirection(FacingDirection.LEFT);
        for(int i =0;i<11;i++){
            this.hero.getHero_movement().update(this.hero);
        }
        assertEquals("ch_walk5.png", this.hero.getImagePath());
        for(int i =0;i<11;i++){
            this.hero.getHero_movement().update(this.hero);
        }
        assertEquals("ch_walk6.png", this.hero.getImagePath());
        for(int i =0;i<11;i++){
            this.hero.getHero_movement().update(this.hero);
        }
        assertEquals("ch_walk7.png", this.hero.getImagePath());
        for(int i =0;i<11;i++){
            this.hero.getHero_movement().update(this.hero);
        }
        assertEquals("ch_walk8.png", this.hero.getImagePath());
        for(int i =0;i<11;i++){
            this.hero.getHero_movement().update(this.hero);
        }
        assertEquals("ch_walk5.png", this.hero.getImagePath());
    }

    @Test
    public void Jump_Right_Image_Update(){
        this.hero.SetJump();
        this.hero.tick();
        assertEquals("ch_walk4.png", this.hero.getImagePath());
    }

    @Test
    public void Jump_Left_Image_Update(){
        facing_left_Image_Update();
        this.hero.SetJump();
        this.hero.tick();
        assertEquals("ch_walk8.png", this.hero.getImagePath());
    }

    @Test
    public void getXPos() {
        assertEquals(50,this.hero.getXPos(),0.001);
    }

    @Test
    public void setXPos() {
        assertEquals(50,this.hero.getXPos(),0.001);
        this.hero.setXPos(100);
        assertEquals(100,this.hero.getXPos(),0.001);
    }

    @Test
    public void getYPos() {
        assertEquals(274, this.hero.getYPos(),0.001);
    }

    @Test
    public void getHeight() {
        assertEquals(60,this.hero.getHeight(),0.001);
    }

    @Test
    public void getWidth() {
        assertEquals(30,this.hero.getWidth(),0.001);
    }

    @Test
    public void getSize() {
        assertEquals(Size.Normal, this.hero.getSize());
    }

    @Test
    public void getLayer() {
        assertEquals(Entity.Layer.FOREGROUND, this.hero.getLayer());
    }

    @Test
    public void setImage() {
        default_getImagePath();
    }

    @Test
    public void reset() {
        assertEquals(50,this.hero.getXPos(),0.001);
        assertEquals(274, this.hero.getYPos(),0.001);
        this.hero.setXPos(100);
        this.hero.setYPos(200);
        assertEquals(200, this.hero.getYPos(),0.001);
        assertEquals(100,this.hero.getXPos(),0.001);
        this.hero.reset();
        assertEquals(50,this.hero.getXPos(),0.001);
        assertEquals(274, this.hero.getYPos(),0.001);
    }

    @Test
    public void getstay() {
        assertFalse(this.hero.getstay());
    }

    @Test
    public void setMovementDirection_LEFTSTILL() {
        assertEquals(FacingDirection.RIGHTSTILL, this.hero.getFacingDirection());
        this.hero.setMovementDirection(FacingDirection.LEFTSTILL);
        assertEquals(FacingDirection.RIGHTSTILL, this.hero.getFacingDirection());
    }

    @Test
    public void setMovementDirection_RIGHTSTILL() {
        assertEquals(FacingDirection.RIGHTSTILL, this.hero.getFacingDirection());
        this.hero.setMovementDirection(FacingDirection.RIGHTSTILL);
        assertEquals(FacingDirection.RIGHTSTILL, this.hero.getFacingDirection());
    }

    @Test
    public void setMovementDirection_RIGHT() {
        assertEquals(FacingDirection.RIGHTSTILL, this.hero.getFacingDirection());
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        assertEquals(FacingDirection.RIGHT, this.hero.getFacingDirection());
    }

    @Test
    public void setMovementDirection_LEFT() {
        assertEquals(FacingDirection.RIGHTSTILL, this.hero.getFacingDirection());
        this.hero.setMovementDirection(FacingDirection.LEFT);
        assertEquals(FacingDirection.LEFT, this.hero.getFacingDirection());
    }

    @Test
    public void setMovementDirection_LEFT_Jump() {
        assertEquals(FacingDirection.RIGHTSTILL, this.hero.getFacingDirection());
        this.hero.setFacingDirection(FacingDirection.JUMPLEFT);
        this.hero.setMovementDirection(FacingDirection.LEFT);
        assertEquals(FacingDirection.JUMPLEFT, this.hero.getFacingDirection());
        this.hero.setFacingDirection(FacingDirection.JUMP);
        this.hero.setMovementDirection(FacingDirection.LEFT);
        assertEquals(FacingDirection.JUMPLEFT, this.hero.getFacingDirection());
        this.hero.setFacingDirection(FacingDirection.JUMPRIGHT);
        this.hero.setMovementDirection(FacingDirection.LEFT);
        assertEquals(FacingDirection.JUMPLEFT, this.hero.getFacingDirection());
    }

    @Test
    public void setMovementDirection_RIGHT_Jump() {
        assertEquals(FacingDirection.RIGHTSTILL, this.hero.getFacingDirection());
        this.hero.setFacingDirection(FacingDirection.JUMPRIGHT);
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        assertEquals(FacingDirection.JUMPRIGHT, this.hero.getFacingDirection());
        this.hero.setFacingDirection(FacingDirection.JUMP);
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        assertEquals(FacingDirection.JUMPRIGHT, this.hero.getFacingDirection());
        this.hero.setFacingDirection(FacingDirection.JUMPLEFT);
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        assertEquals(FacingDirection.JUMPRIGHT, this.hero.getFacingDirection());
    }

    @Test
    public void getFacingDirection() {
        this.hero.setFacingDirection(FacingDirection.LEFT);
        assertEquals(FacingDirection.LEFT,this.hero.getFacingDirection());
    }

    @Test
    public void platforminteract_Top() {
        this.hero.setXPos(560);
        this.hero.setYPos(this.hero.getYPos() -50);
        this.hero.setFalling(true);
        assertEquals(124, this.hero.getMaxHeight(),0.001);
        assertEquals(Whichside.Top,this.hero.getTerrain_interaction().interact(this.hero,this.level));
        this.hero.platforminteract();
        assertEquals(74, this.hero.getMaxHeight(),0.001);
    }
    @Test
    public void platforminteract_StayTop() {
        this.hero.setXPos(560);
        this.hero.setYPos(this.hero.getYPos() -50);
        this.hero.setFalling(false);
        this.hero.setFacingDirection(FacingDirection.JUMPRIGHT);
        this.hero.platforminteract();
        assertEquals(FacingDirection.RIGHT, this.hero.getFacingDirection());
        this.hero.setFacingDirection(FacingDirection.JUMPLEFT);
        this.hero.platforminteract();
        assertEquals(FacingDirection.LEFT, this.hero.getFacingDirection());
    }
    @Test
    public void platforminteract_RightSide(){
        this.hero.setXPos(521);
        this.hero.setFacingDirection(FacingDirection.RIGHT);
        assertEquals(Whichside.SideLeft, this.hero.getTerrain_interaction().interact(this.hero, this.level));
        this.hero.setXPos(521);
        this.hero.setFacingDirection(FacingDirection.LEFT);
        assertEquals(Whichside.SideLeft, this.hero.getTerrain_interaction().interact(this.hero, this.level));
    }
    @Test
    public void platforminteract_LeftSide(){
        this.hero.setXPos(549);
        this.hero.setFacingDirection(FacingDirection.LEFT);
        assertEquals(Whichside.SideLeft, this.hero.getTerrain_interaction().interact(this.hero, this.level));
        this.hero.setXPos(549);
        this.hero.setFacingDirection(FacingDirection.RIGHT);
        assertEquals(Whichside.SideLeft, this.hero.getTerrain_interaction().interact(this.hero, this.level));
    }
    @Test
    public void Jumping_Onto_Platform(){
        this.hero.setXPos(720);
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        this.hero.SetJump();
        for(int i = 1;i<=33;i++){
            this.hero.tick();
            assertEquals(720, this.hero.getXPos(),0.001);
            assertEquals(274-3*i, this.hero.getYPos(),0.001);
        }
        for(int i = 1;i<=17;i++){
            this.hero.tick();
            assertEquals(720 + i, this.hero.getXPos(),0.001);
            assertEquals(175-3*i, this.hero.getYPos(),0.001);
        }
        this.hero.tick();
        assertTrue(this.hero.getFalling());
        for(int i = 1;i<=25;i++){
            this.hero.tick();
            assertEquals(738 + i, this.hero.getXPos(),0.001);
            assertEquals(124 + 2*i, this.hero.getYPos(),0.001);
        }
        assertEquals(24, this.hero.getMaxHeight(),0.001);
    }
    @Test
    public void enemyInteract_Sides() {
        this.hero.setXPos(1335);
        assertEquals(Whichside.None,this.hero.getHero_enemy_interaction().interact(this.hero, this.level));
        this.hero.MoveLeft();
        assertEquals(Whichside.Side,this.hero.getHero_enemy_interaction().interact(this.hero, this.level));
        this.hero.setMovementDirection(FacingDirection.LEFT);
        this.hero.tick();
        assertEquals(50, this.hero.getXPos(),0.001);
        this.level.getEnemies().get(0).setXPos(1360);
        this.hero.setXPos(1330);
        assertEquals(Whichside.None,this.hero.getHero_enemy_interaction().interact(this.hero, this.level));
        this.hero.MoveRight();
        assertEquals(Whichside.Side,this.hero.getHero_enemy_interaction().interact(this.hero, this.level));
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        this.hero.tick();
        assertEquals(50, this.hero.getXPos(),0.001);
    }

    @Test
    public void enemyInteract_Top() {
        this.hero.setFalling(true);
        this.hero.setXPos(1300);
        this.hero.setYPos(253);
        assertEquals(Whichside.None,this.hero.getHero_enemy_interaction().interact(this.hero, this.level));
        this.hero.setYPos(254);
        assertEquals(Whichside.Top,this.hero.getHero_enemy_interaction().interact(this.hero, this.level));
        this.hero.setYPos(252);
        this.hero.tick();
        assertEquals(1300,this.hero.getXPos(),0.001);
        //enemy deleted
        assertEquals(1,this.level.getEnemies().size());
    }

    @Test
    public void tick_GoingRight_Image_Update() {
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        for(int i = 1; i < 12;i++){
            this.hero.tick();
            assertEquals(50+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk1.png", this.hero.getImagePath());
        }
        for(int i = 1; i < 12;i++){
            this.hero.tick();
            assertEquals(61+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk2.png", this.hero.getImagePath());
        }
        for(int i = 1; i < 12;i++){
            this.hero.tick();
            assertEquals(72+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk3.png", this.hero.getImagePath());
        }
        for(int i = 1; i < 12;i++){
            this.hero.tick();
            assertEquals(83+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        for(int i = 1; i < 12;i++){
            this.hero.tick();
            assertEquals(94+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk1.png", this.hero.getImagePath());
        }
    }

    @Test
    public void tick_Going_Left_Image_Update() {
        this.hero.setMovementDirection(FacingDirection.LEFT);
        this.hero.setXPos(150);
        for(int i = 1;i<12; i++){
            this.hero.tick();
            assertEquals(150-i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk5.png", this.hero.getImagePath());
        }
        for(int i = 1;i<12; i++){
            this.hero.tick();
            assertEquals(139-i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk6.png", this.hero.getImagePath());
        }
        for(int i = 1;i<12; i++){
            this.hero.tick();
            assertEquals(128-i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk7.png", this.hero.getImagePath());
        }
        for(int i = 1;i<12; i++){
            this.hero.tick();
            assertEquals(117-i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk8.png", this.hero.getImagePath());
        }
        for(int i = 1;i<12; i++){
            this.hero.tick();
            assertEquals(106-i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk5.png", this.hero.getImagePath());
        }
    }

    @Test
    public void resting_Right_Image_Update(){
        for(int i = 0; i<=9;i++){
            this.hero.tick();
            assertEquals("ch_stand1.png", this.hero.getImagePath());
        }
        for(int i = 0; i<=10;i++){
            this.hero.tick();
            assertEquals("ch_stand2.png", this.hero.getImagePath());
        }
        for(int i = 0; i<=10;i++){
            this.hero.tick();
            assertEquals("ch_stand3.png", this.hero.getImagePath());
        }
        for(int i = 0; i<=10;i++){
            this.hero.tick();
            assertEquals("ch_stand1.png", this.hero.getImagePath());
        }
    }

    @Test
    public void resting_Left_Image_Update(){
        this.hero.setFacingDirection(FacingDirection.LEFTSTILL);
        for(int i = 0; i<=10;i++){
            this.hero.tick();
            assertEquals("ch_stand4.png", this.hero.getImagePath());
        }
        for(int i = 0; i<=10;i++){
            this.hero.tick();
            assertEquals("ch_stand5.png", this.hero.getImagePath());
        }
        for(int i = 0; i<=10;i++){
            this.hero.tick();
            assertEquals("ch_stand6.png", this.hero.getImagePath());
        }
        for(int i = 0; i<=10;i++){
            this.hero.tick();
            assertEquals("ch_stand4.png", this.hero.getImagePath());
        }
    }

    @Test
    public void tick_Going_Right_Then_Jumping_Then_Going_Right_Image_Update(){
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        for(int i = 1;i < 12;i++){
            this.hero.tick();
            assertEquals(274, this.hero.getYPos(), 0.001);
            assertEquals(50+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk1.png", this.hero.getImagePath());
        }
        this.hero.SetJump();
        for(int i = 1;i < 51;i++){
            this.hero.tick();
            assertFalse(this.hero.getFalling());
            assertEquals(61+i, this.hero.getXPos(),0.001);
            assertEquals(274 - 3*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        for(int i = 1;i < 77;i++){
            this.hero.tick();
            assertTrue(this.hero.getFalling());
            assertEquals(111+i, this.hero.getXPos(),0.001);
            assertEquals( 122+ 2*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        for(int i = 1; i < 12;i++){
            this.hero.tick();
            assertEquals(187+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk1.png", this.hero.getImagePath());
        }
        for(int i = 1; i < 12;i++){
            this.hero.tick();
            assertEquals(198+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk2.png", this.hero.getImagePath());
        }
        for(int i = 1; i < 12;i++){
            this.hero.tick();
            assertEquals(209+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk3.png", this.hero.getImagePath());
        }
        for(int i = 1; i < 12;i++){
            this.hero.tick();
            assertEquals(220+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        for(int i = 1; i < 12;i++){
            this.hero.tick();
            assertEquals(231+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk1.png", this.hero.getImagePath());
        }
    }

    @Test
    public void tick_Going_Left_Then_Jumping_Then_Going_Left_Image_Update() {
        this.hero.setMovementDirection(FacingDirection.LEFT);
        this.hero.setXPos(400);
        for(int i = 1; i <=11;i++){
            this.hero.tick();
            assertFalse(this.hero.getFalling());
            assertEquals(274, this.hero.getYPos(), 0.001);
            assertEquals(400-i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk5.png", this.hero.getImagePath());
        }
        this.hero.SetJump();
        for(int i = 1; i <=50;i++){
            this.hero.tick();
            assertFalse(this.hero.getFalling());
            assertEquals(274 - i*3, this.hero.getYPos(), 0.001);
            assertEquals(389-i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk8.png", this.hero.getImagePath());
        }
        for(int i = 1; i <=76;i++){
            this.hero.tick();
            assertTrue(this.hero.getFalling());
            assertEquals(122 + i*2, this.hero.getYPos(), 0.001);
            assertEquals(339-i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk8.png", this.hero.getImagePath());
        }
        for(int i = 1; i <=11;i++){
            this.hero.tick();
            assertEquals(274, this.hero.getYPos(), 0.001);
            assertEquals(263- i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk5.png", this.hero.getImagePath());
        }
        for(int i = 1; i <=11;i++){
            this.hero.tick();
            assertEquals(252- i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk6.png", this.hero.getImagePath());
        }
        for(int i = 1; i <=11;i++){
            this.hero.tick();
            assertEquals(241- i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk7.png", this.hero.getImagePath());
        }
        for(int i = 1; i <=11;i++){
            this.hero.tick();
            assertEquals(230- i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk8.png", this.hero.getImagePath());
        }
        for(int i = 1; i <=11;i++){
            this.hero.tick();
            assertEquals(219- i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk5.png", this.hero.getImagePath());
        }

    }

    @Test
    public void Jumping_GoingRight_Still_GoingRight_Image_Update(){
        this.hero.SetJump();
        for(int i = 1; i<=25;i++){
            this.hero.tick();
            assertFalse(this.hero.getFalling());
            assertEquals(50, this.hero.getXPos(),0.001);
            assertEquals(274 - 3*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        for(int i = 1; i<=25;i++){
            this.hero.tick();
            assertFalse(this.hero.getFalling());
            assertEquals(50+i, this.hero.getXPos(),0.001);
            assertEquals(199 - 3*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        this.hero.StopMoving();
        for(int i = 1; i<=25;i++){
            this.hero.tick();
            assertTrue(this.hero.getFalling());
            assertEquals(75, this.hero.getXPos(),0.001);
            assertEquals(122 + 2*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        for(int i = 1; i<=51;i++){
            this.hero.tick();
            assertTrue(this.hero.getFalling());
            assertEquals(75 + i, this.hero.getXPos(),0.001);
            assertEquals(172 + 2*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        this.hero.tick();
        assertFalse(this.hero.getFalling());
    }

    @Test
    public void Jumping_Alternating_Directions_Image_Update(){
        this.hero.setXPos(300);
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        this.hero.SetJump();
        for(int i = 1; i <= 25;i++){
            this.hero.tick();
            assertFalse(this.hero.getFalling());
            assertEquals(300 + i, this.hero.getXPos(),0.001);
            assertEquals(274 - 3*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        this.hero.setMovementDirection(FacingDirection.LEFT);
        for(int i = 1; i <= 25;i++){
            this.hero.tick();
            assertFalse(this.hero.getFalling());
            assertEquals(325 - i, this.hero.getXPos(),0.001);
            assertEquals(199 - 3*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk8.png", this.hero.getImagePath());
        }
        this.hero.tick();
        assertTrue(this.hero.getFalling());
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        for(int i = 1; i <= 15;i++){
            this.hero.tick();
            assertEquals(299 + i, this.hero.getXPos(),0.001);
            assertEquals(124 + 2*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        this.hero.setMovementDirection(FacingDirection.LEFT);
        for(int i = 1; i <= 15;i++){
            this.hero.tick();
            assertEquals(314 - i, this.hero.getXPos(),0.001);
            assertEquals(154 + 2*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk8.png", this.hero.getImagePath());
        }
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        for(int i = 1; i <= 15;i++){
            this.hero.tick();
            assertEquals(299 + i, this.hero.getXPos(),0.001);
            assertEquals(184 + 2*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        this.hero.setMovementDirection(FacingDirection.LEFT);
        for(int i = 1; i <= 15;i++){
            this.hero.tick();
            assertEquals(314 - i, this.hero.getXPos(),0.001);
            assertEquals(214 + 2*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk8.png", this.hero.getImagePath());
        }
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        for(int i = 1; i <= 15;i++){
            this.hero.tick();
            assertEquals(299 + i, this.hero.getXPos(),0.001);
            assertEquals(244 + 2*i, this.hero.getYPos(), 0.001);
            assertEquals("ch_walk4.png", this.hero.getImagePath());
        }
        this.hero.tick();
        assertFalse(this.hero.getFalling());
    }

    @Test
    public void GoingRight_Still_Left_Still(){
        this.hero.setXPos(300);
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        for(int i = 1; i <=11;i++){
            this.hero.tick();
            assertEquals(FacingDirection.RIGHT,this.hero.getFacingDirection());
            assertEquals(300+i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk1.png", this.hero.getImagePath());
        }
        this.hero.tick();
        assertEquals(312, this.hero.getXPos(),0.001);
        assertEquals("ch_walk2.png", this.hero.getImagePath());
        this.hero.StopMoving();
        this.hero.tick();
        assertEquals(312, this.hero.getXPos(),0.001);
        assertEquals("ch_stand1.png", this.hero.getImagePath());
        this.hero.setMovementDirection(FacingDirection.LEFT);
        for(int i = 1; i <=11;i++){
            this.hero.tick();
            assertEquals(FacingDirection.LEFT,this.hero.getFacingDirection());
            assertEquals(312-i, this.hero.getXPos(),0.001);
            assertEquals("ch_walk5.png", this.hero.getImagePath());
        }
        this.hero.tick();
        assertEquals(300, this.hero.getXPos(),0.001);
        assertEquals("ch_walk6.png", this.hero.getImagePath());
        this.hero.StopMoving();
        this.hero.tick();
        assertEquals(300, this.hero.getXPos(),0.001);
        assertEquals("ch_stand4.png", this.hero.getImagePath());
    }

    @Test
    public void moveLeft() {
        assertEquals(50,this.hero.getXPos(),0.001);
        this.hero.MoveLeft();
        assertEquals(50,this.hero.getXPos(),0.001);
        this.hero.setXPos(100);
        this.hero.MoveLeft();
        assertEquals(99,this.hero.getXPos(),0.001);
    }

    @Test
    public void moveRight() {
        assertEquals(50,this.hero.getXPos(),0.001);
        this.hero.MoveRight();
        assertEquals(51,this.hero.getXPos(),0.001);
    }

    @Test
    public void jump_Normal() {
        this.hero.SetJump();
        double initialYValue = this.hero.getYPos();
        for(int i = 0; i < 50;i++){
            assertFalse(this.hero.getFalling());
            assertEquals(initialYValue - 3*i, this.hero.getYPos(),0.001);
            this.hero.jump();
        }
        //when character hit the Max Height
        this.hero.jump();
        assertTrue(this.hero.getFalling());

        for(int i = 0; i < 75;i++){
            assertTrue(this.hero.getFalling());
            assertEquals(this.hero.getMaxHeight() + 2*i, this.hero.getYPos(),0.001);
            this.hero.jump();
        }
        //when character hit the floor;
        this.hero.jump();
        assertFalse(this.hero.getFalling());
    }

    @Test
    public void jump_On_Terrain() {
        this.hero.SetJump();
        this.hero.setXPos(800);
        this.hero.setYPos(184);
        this.hero.setMaxHeight(this.hero.getYPos() - 150);
        double initialYValue = this.hero.getYPos();
        this.hero.platforminteract();
        for(int i = 0; i < 50;i++){
            assertFalse(this.hero.getFalling());
            assertEquals(initialYValue - 3*i, this.hero.getYPos(),0.001);
            this.hero.jump();
            this.hero.platforminteract();
        }
        //when character hit the Max Height
        this.hero.jump();
        assertTrue(this.hero.getFalling());

        for(int i = 0; i < 70;i++){
            assertTrue(this.hero.getFalling());
            assertEquals(this.hero.getMaxHeight() + 2*i, this.hero.getYPos(),0.001);
            this.hero.jump();
            this.hero.platforminteract();
        }
        //when the character arrives ontop of the platform
        assertFalse(this.hero.getFalling());
    }

    @Test
    public void stopMoving_Right_Still() {
        this.hero.StopMoving();
        assertFalse(this.hero.isGoingRight());
        assertFalse(this.hero.isGoingLeft());
        assertEquals(FacingDirection.RIGHTSTILL, this.hero.getFacingDirection());
    }
    @Test
    public void stopMoving_Left_Still() {
        this.hero.setFacingDirection(FacingDirection.LEFT);
        this.hero.StopMoving();
        assertFalse(this.hero.isGoingRight());
        assertFalse(this.hero.isGoingLeft());
        assertEquals(FacingDirection.LEFTSTILL, this.hero.getFacingDirection());
    }

    @Test
    public void setJump_Stopping_Double_Jump() {
        assertTrue(this.hero.SetJump());
        assertFalse(this.hero.SetJump());
    }

    @Test
    public void getFalling() {
        assertFalse(this.hero.getFalling());
        this.hero.setYPos(this.hero.getYPos()-150);
        this.hero.SetJump();
        this.hero.jump();
        assertTrue(this.hero.getFalling());
    }

    @Test
    public void getJump() {
        assertFalse(this.hero.getJump());
        assertTrue(this.hero.SetJump());
        assertTrue(this.hero.getJump());
    }

    @Test
    public void isGoingLeft() {
        this.hero.setMovementDirection(FacingDirection.LEFT);
        assertFalse(this.hero.isGoingRight());
        assertTrue(this.hero.isGoingLeft());
    }

    @Test
    public void isGoingRight() {
        this.hero.setMovementDirection(FacingDirection.RIGHT);
        assertTrue(this.hero.isGoingRight());
        assertFalse(this.hero.isGoingLeft());
    }

    @Test
    public void getLevel() {
        assertEquals(this.level, this.hero.getLevel());
    }

    @Test
    public void getLevelBehaviour() {
        assertEquals("Normal", this.hero.getLevelBehaviour().getBehaviour());
    }
}