package stickman.model.Entity_Folder.Slime;

import org.junit.Before;
import org.junit.Test;
import stickman.model.Entity_Folder.Entity;
import stickman.model.Entity_Folder.Size;
import stickman.model.Level_Folder.Current_Level;
import stickman.model.Level_Folder.Level;
import stickman.model.Level_Folder.Level_Type;

import static org.junit.Assert.*;

public class Blue_slimeTest {
    private Blue_slime enemy;
    private Level level;
    private Slime_Jumpy behaviour;
    @Before
    public void setUp() throws Exception {
        this.level = new Current_Level(Size.Normal,50,3.2, Level_Type.Normal);
        this.enemy = (Blue_slime) this.level.getEnemies().get(1);
        this.behaviour = (Slime_Jumpy) this.enemy.getBehaviours();
    }
    @Test
    public void getImagePath() {
        assertEquals("slimeBa.png", this.enemy.getImagePath());
    }

    @Test
    public void getXPos() {
        assertEquals(1600, this.enemy.getXPos(),0.001);
    }

    @Test
    public void getYPos() {
        assertEquals(294, this.enemy.getYPos(),0.001);
    }

    @Test
    public void getHeight() {
        assertEquals(40, this.enemy.getHeight(),0.001);
    }

    @Test
    public void getWidth() {
        assertEquals(50, this.enemy.getWidth(), 0.001);
    }

    @Test
    public void getLayer() {
        assertEquals(Entity.Layer.FOREGROUND, this.enemy.getLayer());
    }

    @Test
    public void getstay() {
        assertFalse(this.enemy.getstay());
    }

    @Test
    public void setXPos() {
        assertEquals(1600, this.enemy.getXPos(),0.001);
        this.enemy.setXPos(1500);
        assertEquals(1500, this.enemy.getXPos(),0.001);
    }

    @Test
    public void setYPos() {
        assertEquals(294, this.enemy.getYPos(),0.001);
        this.enemy.setYPos(400);
        assertEquals(400, this.enemy.getYPos(),0.001);
    }

    @Test
    public void moveRight() {
        assertEquals(1600, this.enemy.getXPos(),0.001);
        this.enemy.MoveRight();
        assertEquals(1600.25, this.enemy.getXPos(),0.001);
    }

    @Test
    public void moveLeft() {
        assertEquals(1600, this.enemy.getXPos(),0.001);
        this.enemy.MoveLeft();
        assertEquals(1599.75, this.enemy.getXPos(),0.001);
    }

    @Test
    public void getFalling() {
        assertFalse(this.enemy.getFalling());
        this.enemy.setFalling(true);
        assertTrue(this.enemy.getFalling());
    }

    @Test
    public void platforminteract() {
        assertFalse(this.enemy.getLeft());
        this.enemy.setXPos(1700);
        this.enemy.platforminteract();
        assertFalse(this.enemy.getLeft());
        this.enemy.MoveRight();
        this.enemy.platforminteract();
        assertTrue(this.enemy.getLeft());
    }

    @Test
    public void getSpeed() {
        assertEquals(0.25, this.enemy.getSpeed(),0.001);
    }

    @Test
    public void switchImage() {
        assertEquals("slimeBa.png", this.enemy.getImagePath());
        this.enemy.switchImage();
        assertEquals("slimeBb.png", this.enemy.getImagePath());
        this.enemy.switchImage();
        assertEquals("slimeBa.png", this.enemy.getImagePath());
    }

    @Test
    public void tick() {
        this.enemy.tick();
        assertEquals(1600.25, this.enemy.getXPos(),0.001);
    }

    @Test
    public void Tick_changing_image_and_Jumping(){
        assertFalse(this.behaviour.isSetJump());
        for(int i = 0;i<101;i++){
            this.enemy.tick();
        }
        assertEquals(1625.25,this.enemy.getXPos(),0.001);
        assertEquals("slimeBb.png",this.enemy.getImagePath());
        for(int i = 0;i<100;i++){
            this.enemy.tick();
        }
        assertEquals(1650.25,this.enemy.getXPos(),0.001);
        assertTrue(this.behaviour.isSetJump());
    }

    @Test
    public void setFalling() {
        assertFalse(this.enemy.getFalling());
        this.enemy.setFalling(true);
        assertTrue(this.enemy.getFalling());
    }

    @Test
    public void getBehaviours() {
        assertEquals(this.behaviour, this.enemy.getBehaviours());
    }

    @Test
    public void Platform_interaction(){
        this.enemy.setXPos(500);
        this.enemy.getBehaviours().do_behaviour();
        assertEquals(500.25, this.enemy.getXPos(),0.001);
        assertFalse(this.enemy.getLeft());
        this.enemy.platforminteract();
        assertTrue(this.enemy.getLeft());
        this.enemy.getBehaviours().do_behaviour();
        assertEquals(500, this.enemy.getXPos(),0.001);
    }

    @Test
    public void Jumping(){
        this.enemy.setXPos(300);
        for(int i = 1; i <= 200; i++){
            this.behaviour.do_behaviour();
            assertFalse(this.behaviour.isFalling());
            assertFalse(this.behaviour.isSetJump());
            assertEquals(i, this.behaviour.getTickCounter(),0.001);
            assertEquals(300+i*this.enemy.getSpeed(), this.enemy.getXPos(),0.001);
        }
        for(int i = 1; i <= 68; i++){
            this.behaviour.do_behaviour();
            assertFalse(this.behaviour.isFalling());
            assertTrue(this.behaviour.isSetJump());
            assertEquals(i-1, this.behaviour.getTickCounter(),0.001);
            assertEquals(350+i*this.enemy.getSpeed(), this.enemy.getXPos(),0.001);
            if(i == 1){
                assertEquals(294 - 3*i, this.enemy.getYPos(),0.001);
            }
            else if((i-1) % 2 == 0){
                assertEquals(291 - 3*((i-1)/2), this.enemy.getYPos(),0.001);
            }
        }
        this.behaviour.do_behaviour();
        assertTrue(this.behaviour.isFalling());
        for(int i = 1; i <= 103; i++){
            this.behaviour.do_behaviour();
            assertTrue(this.behaviour.isFalling());
            assertTrue(this.behaviour.isSetJump());
            assertEquals(68+i, this.behaviour.getTickCounter(),0.001);
            assertEquals(367.25+i*this.enemy.getSpeed(), this.enemy.getXPos(),0.001);
            if(i == 1){
                assertEquals(190 + 2*i, this.enemy.getYPos(),0.001);
            }
            else if((i-1) % 2 == 0){
                assertEquals(192 + 2*((i-1)/2), this.enemy.getYPos(),0.001);
            }
        }
        this.behaviour.do_behaviour();
        assertFalse(this.behaviour.isFalling());
        assertFalse(this.behaviour.isSetJump());
    }

    @Test
    public void getLeft(){
        assertFalse(this.enemy.getLeft());
    }

}