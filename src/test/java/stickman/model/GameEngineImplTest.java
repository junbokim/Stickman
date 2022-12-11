package stickman.model;

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
import stickman.model.Level_Folder.Current_Level;
import stickman.model.Level_Folder.Level;
import stickman.model.Level_Folder.Level_Type;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameEngineImplTest {
    private Level level;
    private GameEngineImpl model;
    private List<Cloud> Clouds;
    private List<Platform> Platforms;
    private List<Enemy> Enemies;
    private List<Heart> Hearts;
    private List<Entity> Entities;
    private CloudFactory cloudFactory;
    private PlatformFactory platformFactory;
    private Hero hero;
    private List<Tick> Tickable;

    @Before
    public void setUp() throws Exception {
        this.level = new Current_Level(Size.Normal, 51,3.2, Level_Type.Normal);
        this.model = new GameEngineImpl("/Test_Default.json");
        this.Clouds = new ArrayList<>();
        this.Platforms = new ArrayList<>();
        this.Enemies = new ArrayList<>();
        this.Hearts = new ArrayList<>();
        this.Entities = new ArrayList<>();
        this.cloudFactory = new CloudFactory();
        this.Tickable = new ArrayList<>();
        this.platformFactory = new PlatformFactory(this.level);
        this.Clouds.add(this.cloudFactory.makeCloud(this.level.getCloudVelocity()/2, EntityType.type1, 100, 25));
        this.Clouds.add(this.cloudFactory.makeCloud(this.level.getCloudVelocity()/3, EntityType.type1, 650, 50));
        this.Clouds.add(this.cloudFactory.makeCloud(this.level.getCloudVelocity()/2, EntityType.type1, 1000, 35));
        this.Clouds.add(this.cloudFactory.makeCloud(this.level.getCloudVelocity()/3, EntityType.type1, 1700, 80));
        this.Clouds.add(this.cloudFactory.makeCloud(this.level.getCloudVelocity()/3, EntityType.type2, 700, 30));
        this.Clouds.add(this.cloudFactory.makeCloud(this.level.getCloudVelocity()/3, EntityType.type2, 1200, 100));
        this.Clouds.add(this.cloudFactory.makeCloud(this.level.getCloudVelocity()/2, EntityType.type2, 1900, 50));
        this.Platforms.add(this.platformFactory.platform_maker(Size.Giant, -150));
        this.Platforms.add(this.platformFactory.platform_maker(Size.Normal, 550));
        this.Platforms.add(this.platformFactory.platform_maker(Size.Large, 750));
        this.Platforms.add(this.platformFactory.platform_maker(Size.Normal, 1250));
        this.Platforms.add(this.platformFactory.platform_maker(Size.Large, 1500));
        this.Platforms.add(this.platformFactory.platform_maker(Size.Large, 1750));
        this.Platforms.add(this.platformFactory.platform_maker(Size.Giant, 2000));
        this.Enemies.add(new Pinky(Size.Tiny, 1300, this.level));
        this.Enemies.add(new Blue_slime(Size.Normal, 1600, this.level));
        this.Hearts.add(new Heart(1));
        this.Hearts.add(new Heart(2));
        this.Hearts.add(new Heart(3));
        this.hero = new Hero(Size.Normal,50,this.level, Level_Type.Normal);
        this.Entities.add(this.hero);
        this.Entities.add(new Background_Colour("Blue_Background.png"));
        this.Entities.add(new Background_Trees("landscape_0000_1_trees.png"));
        this.Entities.addAll(Clouds);
        this.Entities.addAll(Platforms);
        this.Entities.addAll(Enemies);
        this.Entities.addAll(Hearts);
        this.Tickable.addAll(Clouds);
        this.Tickable.addAll(Enemies);
        this.Tickable.addAll(Hearts);
    }

    @Test
    public void getCurrentLevel() {
        for(int i = 0; i < this.Entities.size();i++){
            assertEquals(this.Entities.get(i).getXPos(), this.model.getCurrentLevel().getEntities().get(i).getXPos(), 0.001);
            assertEquals(this.Entities.get(i).getYPos(), this.model.getCurrentLevel().getEntities().get(i).getYPos(), 0.001);
            assertEquals(this.Entities.get(i).getHeight(), this.model.getCurrentLevel().getEntities().get(i).getHeight(), 0.001);
            assertEquals(this.Entities.get(i).getWidth(), this.model.getCurrentLevel().getEntities().get(i).getWidth(), 0.001);
            assertEquals(this.Entities.get(i).getImagePath(), this.model.getCurrentLevel().getEntities().get(i).getImagePath());
            assertEquals(this.Entities.get(i).getLayer(), this.model.getCurrentLevel().getEntities().get(i).getLayer());
            assertEquals(this.Entities.get(i).getstay(), this.model.getCurrentLevel().getEntities().get(i).getstay());
        }
    }

    @Test
    public void jump() {
        this.model.jump();
        assertTrue(this.model.getCurrentLevel().getProtagonist().getJump());
    }

    @Test
    public void moveLeft() {
        this.model.moveLeft();
        assertTrue(this.model.getCurrentLevel().getProtagonist().isGoingLeft());
    }

    @Test
    public void moveRight() {
        this.model.moveRight();
        assertTrue(this.model.getCurrentLevel().getProtagonist().isGoingRight());
    }

    @Test
    public void stopMoving() {
        this.model.stopMoving();
        assertTrue(!this.model.getCurrentLevel().getProtagonist().isGoingLeft() &&!this.model.getCurrentLevel().getProtagonist().isGoingRight() );
    }

    @Test
    public void tick() {
        this.model.tick();
        for(Tick tickable: this.Tickable){
            tickable.tick();
        }
        for(int i = 0; i < this.Entities.size();i++){
            assertEquals(this.Entities.get(i).getXPos(), this.model.getCurrentLevel().getEntities().get(i).getXPos(), 0.001);
            assertEquals(this.Entities.get(i).getYPos(), this.model.getCurrentLevel().getEntities().get(i).getYPos(), 0.001);
            assertEquals(this.Entities.get(i).getHeight(), this.model.getCurrentLevel().getEntities().get(i).getHeight(), 0.001);
            assertEquals(this.Entities.get(i).getWidth(), this.model.getCurrentLevel().getEntities().get(i).getWidth(), 0.001);
            assertEquals(this.Entities.get(i).getImagePath(), this.model.getCurrentLevel().getEntities().get(i).getImagePath());
            assertEquals(this.Entities.get(i).getLayer(), this.model.getCurrentLevel().getEntities().get(i).getLayer());
            assertEquals(this.Entities.get(i).getstay(), this.model.getCurrentLevel().getEntities().get(i).getstay());
        }
    }
}