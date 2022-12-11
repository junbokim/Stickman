package stickman.model.Level_Folder;

import org.junit.Before;
import org.junit.Test;
import stickman.model.Entity_Folder.Background.Background_Colour;
import stickman.model.Entity_Folder.Background.Background_Trees;
import stickman.model.Entity_Folder.Clouds.Cloud;
import stickman.model.Entity_Folder.Clouds.CloudFactory;
import stickman.model.Entity_Folder.Entity;
import stickman.model.Entity_Folder.EntityType;
import stickman.model.Entity_Folder.Hero_Folder.Hero;
import stickman.model.Entity_Folder.Platform_Folder.Platform;
import stickman.model.Entity_Folder.Platform_Folder.PlatformFactory;
import stickman.model.Entity_Folder.Size;
import stickman.model.Entity_Folder.Slime.Blue_slime;
import stickman.model.Entity_Folder.Slime.Enemy;
import stickman.model.Entity_Folder.Slime.Pinky;
import stickman.model.Entity_Folder.Tick;
import stickman.model.Entity_Folder.etc_Folders.Heart;
import stickman.model.Entity_Folder.etc_Folders.Timer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Normal_Level_Instantiation_test {
    private Level level;
    private List<Cloud> Clouds;
    private List<Platform> Platforms;
    private List<Enemy> Enemies;
    private List<Heart> Hearts;
    private List<Entity> Entities;
    private CloudFactory cloudFactory;
    private PlatformFactory platformFactory;
    private Hero hero;
    private Timer timer;
    private List<Tick> Tickable;
    private double cloud_velocity;

    @Before
    public void setUp() throws Exception {
        this.level = new Current_Level(Size.Normal, 50,3.2,Level_Type.Normal);
        this.cloud_velocity = 3.2;
        this.timer = new Timer();
        this.Clouds = new ArrayList<>();
        this.Platforms = new ArrayList<>();
        this.Enemies = new ArrayList<>();
        this.Hearts = new ArrayList<>();
        this.Entities = new ArrayList<>();
        this.cloudFactory = new CloudFactory();
        this.Tickable = new ArrayList<>();

        this.platformFactory = new PlatformFactory(this.level);
        this.Clouds.add(cloudFactory.makeCloud(this.level.getCloudVelocity()/2, EntityType.type1, 100, 25));
        this.Clouds.add(cloudFactory.makeCloud(this.level.getCloudVelocity()/3, EntityType.type1, 650, 50));
        this.Clouds.add(cloudFactory.makeCloud(this.level.getCloudVelocity()/2, EntityType.type1, 1000, 35));
        this.Clouds.add(cloudFactory.makeCloud(this.level.getCloudVelocity()/3, EntityType.type1, 1700, 80));
        this.Clouds.add(cloudFactory.makeCloud(this.level.getCloudVelocity()/3, EntityType.type2, 700, 30));
        this.Clouds.add(cloudFactory.makeCloud(this.level.getCloudVelocity()/3, EntityType.type2, 1200, 100));
        this.Clouds.add(cloudFactory.makeCloud(this.level.getCloudVelocity()/2, EntityType.type2, 1900, 50));
        this.Platforms.add(platformFactory.platform_maker(Size.Giant, -150));
        this.Platforms.add(platformFactory.platform_maker(Size.Normal, 550));
        this.Platforms.add(platformFactory.platform_maker(Size.Large, 750));
        this.Platforms.add(platformFactory.platform_maker(Size.Normal, 1250));
        this.Platforms.add(platformFactory.platform_maker(Size.Large, 1500));
        this.Platforms.add(platformFactory.platform_maker(Size.Large, 1750));
        this.Platforms.add(platformFactory.platform_maker(Size.Giant, 2000));
        this.Enemies.add(new Pinky(Size.Tiny, 1300, this.level));
        this.Enemies.add(new Blue_slime(Size.Normal, 1600, this.level));
        this.Hearts.add(new Heart(1));
        this.Hearts.add(new Heart(2));
        this.Hearts.add(new Heart(3));
        this.hero = new Hero(Size.Normal, 50, this.level, Level_Type.Normal);
        this.Entities.add(this.hero);
        this.Entities.add(new Background_Colour("Blue_Background.png"));
        this.Entities.add(new Background_Trees("landscape_0000_1_trees.png"));
        this.Entities.addAll(Clouds);
        this.Entities.addAll(Platforms);
        this.Entities.addAll(Enemies);
        this.Entities.addAll(Hearts);
        this.Tickable.add(this.hero);
        this.Tickable.addAll(Clouds);
        this.Tickable.addAll(Enemies);
        this.Tickable.addAll(Hearts);
    }

    @Test
    public void getPlatforms() {
        for(int i = 0; i < this.Platforms.size();i++){
            assertEquals(this.Platforms.get(i).getXPos(), this.level.getPlatforms().get(i).getXPos(), 0.001);
            assertEquals(this.Platforms.get(i).getYPos(), this.level.getPlatforms().get(i).getYPos(), 0.001);
            assertEquals(this.Platforms.get(i).getHeight(), this.level.getPlatforms().get(i).getHeight(), 0.001);
            assertEquals(this.Platforms.get(i).getWidth(), this.level.getPlatforms().get(i).getWidth(), 0.001);
            assertEquals(this.Platforms.get(i).getImagePath(), this.level.getPlatforms().get(i).getImagePath());
            assertEquals(this.Platforms.get(i).getLayer(), this.level.getPlatforms().get(i).getLayer());
            assertEquals(this.Platforms.get(i).getstay(), this.level.getPlatforms().get(i).getstay());
        }
    }
    @Test
    public void getEnemies() {
        for(int i = 0; i < this.Enemies.size(); i++){
            assertEquals(this.Enemies.get(i).getXPos(), this.level.getEnemies().get(i).getXPos(), 0.001);
            assertEquals(this.Enemies.get(i).getYPos(), this.level.getEnemies().get(i).getYPos(), 0.001);
            assertEquals(this.Enemies.get(i).getHeight(), this.level.getEnemies().get(i).getHeight(), 0.001);
            assertEquals(this.Enemies.get(i).getWidth(), this.level.getEnemies().get(i).getWidth(), 0.001);
            assertEquals(this.Enemies.get(i).getSpeed(), this.level.getEnemies().get(i).getSpeed(),0.001);
            assertEquals(this.Enemies.get(i).getImagePath(), this.level.getEnemies().get(i).getImagePath());
            assertEquals(this.Enemies.get(i).getLayer(), this.level.getEnemies().get(i).getLayer());
            assertEquals(this.Enemies.get(i).getstay(), this.level.getEnemies().get(i).getstay());
        }
    }
    @Test
    public void getClouds() {
        for(int i = 0; i < this.Clouds.size(); i++){
            assertEquals(this.Clouds.get(i).getXPos(), this.level.getClouds().get(i).getXPos(), 0.001);
            assertEquals(this.Clouds.get(i).getYPos(), this.level.getClouds().get(i).getYPos(), 0.001);
            assertEquals(this.Clouds.get(i).getHeight(), this.level.getClouds().get(i).getHeight(), 0.001);
            assertEquals(this.Clouds.get(i).getWidth(), this.level.getClouds().get(i).getWidth(), 0.001);
            assertEquals(this.Clouds.get(i).getVelocity(), this.level.getClouds().get(i).getVelocity(),0.001);
            assertEquals(this.Clouds.get(i).getImagePath(), this.level.getClouds().get(i).getImagePath());
            assertEquals(this.Clouds.get(i).getLayer(), this.level.getClouds().get(i).getLayer());
            assertEquals(this.Clouds.get(i).getstay(), this.level.getClouds().get(i).getstay());
        }
    }

    @Test
    public void getHearts() {
        for(int i = 0; i < this.Hearts.size(); i++){
            assertEquals(this.Hearts.get(i).getXPos(), this.level.getHearts().get(i).getXPos(), 0.001);
            assertEquals(this.Hearts.get(i).getYPos(), this.level.getHearts().get(i).getYPos(), 0.001);
            assertEquals(this.Hearts.get(i).getHeight(), this.level.getHearts().get(i).getHeight(), 0.001);
            assertEquals(this.Hearts.get(i).getWidth(), this.level.getHearts().get(i).getWidth(), 0.001);
            assertEquals(this.Hearts.get(i).getImagePath(), this.level.getHearts().get(i).getImagePath());
            assertEquals(this.Hearts.get(i).getLayer(), this.level.getHearts().get(i).getLayer());
            assertEquals(this.Hearts.get(i).getstay(), this.level.getHearts().get(i).getstay());
            assertEquals(this.Hearts.get(i).getCounter(), this.level.getHearts().get(i).getCounter());
            assertEquals(this.Hearts.get(i).getDirection(), this.level.getHearts().get(i).getDirection());
        }
    }

    @Test
    public void getTickable() {
        for(int i = 0; i < this.level.getTickable().size(); i++){
            assertTrue(this.level.getTickable().get(i).tickable());
        }
    }

    @Test
    public void getEntities() {
        for(int i = 0; i < this.Entities.size();i++){
            assertEquals(this.Entities.get(i).getXPos(), this.level.getEntities().get(i).getXPos(), 0.001);
            assertEquals(this.Entities.get(i).getYPos(), this.level.getEntities().get(i).getYPos(), 0.001);
            assertEquals(this.Entities.get(i).getHeight(), this.level.getEntities().get(i).getHeight(), 0.001);
            assertEquals(this.Entities.get(i).getWidth(), this.level.getEntities().get(i).getWidth(), 0.001);
            assertEquals(this.Entities.get(i).getImagePath(), this.level.getEntities().get(i).getImagePath());
            assertEquals(this.Entities.get(i).getLayer(), this.level.getEntities().get(i).getLayer());
            assertEquals(this.Entities.get(i).getstay(), this.level.getEntities().get(i).getstay());
        }
    }


    @Test
    public void deleteEnemy() {
        this.level.deleteEnemy(this.level.getEnemies().get(0));
        assertEquals(1, this.level.getEnemies().size());
        assertEquals(this.Enemies.get(1).getXPos(), this.level.getEnemies().get(0).getXPos(), 0.001);
        assertEquals(this.Enemies.get(1).getYPos(), this.level.getEnemies().get(0).getYPos(), 0.001);
        assertEquals(this.Enemies.get(1).getHeight(), this.level.getEnemies().get(0).getHeight(), 0.001);
        assertEquals(this.Enemies.get(1).getWidth(), this.level.getEnemies().get(0).getWidth(), 0.001);
        assertEquals(this.Enemies.get(1).getSpeed(), this.level.getEnemies().get(0).getSpeed(),0.001);
        assertEquals(this.Enemies.get(1).getImagePath(), this.level.getEnemies().get(0).getImagePath());
        assertEquals(this.Enemies.get(1).getLayer(), this.level.getEnemies().get(0).getLayer());
        assertEquals(this.Enemies.get(1).getstay(), this.level.getEnemies().get(0).getstay());
    }

    @Test
    public void getTimer() {
        assertEquals(this.timer.getTime(), this.level.getTimer().getTime());
        this.timer.tick();
        this.level.getTimer().tick();
        assertEquals(this.timer.getTime(), this.level.getTimer().getTime());
    }

    @Test
    public void tick() {
        this.level.tick();
        for(Tick tickable: this.Tickable){
            tickable.tick();
        }
        getEntities();
    }

    @Test
    public void reset() {
        this.level.reset();
        Heart to_remove = this.Hearts.get(this.Hearts.size()-1);
        this.Hearts.remove(to_remove);
        this.Entities.remove(to_remove);
        assertEquals(2, this.Hearts.size());
        assertEquals(21, this.Entities.size());
    }

    @Test
    public void getFloorHeight() {
        assertEquals(334, this.level.getFloorHeight(), 0.001);
    }

    @Test
    public void getHeroX() {
        assertEquals(50, this.level.getHeroX(),0.001);
    }

    @Test
    public void setHeroX() {
        this.level.setHeroX(100);
        assertEquals(100, this.level.getHeroX(),0.001);
    }

    @Test
    public void getProtagonist() {
        Hero protagonist_expected = this.hero;
        Hero protagonist_actual =  this.level.getProtagonist();
        assertEquals(protagonist_expected.getFacingDirection(), protagonist_actual.getFacingDirection());
        assertEquals(protagonist_expected.getFalling(), protagonist_actual.getFalling());
        assertEquals(protagonist_expected.getHeight(), protagonist_actual.getHeight(),0.001);
        assertEquals(protagonist_expected.getImagePath(), protagonist_actual.getImagePath());
        assertEquals(protagonist_expected.getJump(), protagonist_actual.getJump());
        assertEquals(protagonist_expected.getLayer(), protagonist_actual.getLayer());
        assertEquals(protagonist_expected.getSize(), protagonist_actual.getSize());
        assertEquals(protagonist_expected.getstay(), protagonist_actual.getstay());
        assertEquals(protagonist_expected.getWidth(), protagonist_actual.getWidth(),0.001);
        assertEquals(protagonist_expected.getXPos(), protagonist_actual.getXPos(),0.001);
        assertEquals(protagonist_expected.getYPos(), protagonist_actual.getYPos(),0.001);
    }

    @Test
    public void setLevelFinished() {
        this.level.setLevelFinished();
        assertTrue(this.level.getLevelFinished());
    }

    @Test
    public void getLevelFinished() {
        assertFalse(this.level.getLevelFinished());
    }


    @Test
    public void getCloudVelocity() {
        assertEquals(this.cloud_velocity, this.level.getCloudVelocity(),0.001);
    }

    @Test
    public void getLevel_type_Normal() {
        assertEquals(Level_Type.Normal, this.level.getLevel_type());
    }
}