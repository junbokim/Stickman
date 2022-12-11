package stickman.model.Level_Folder;

import stickman.model.Entity_Folder.*;
import stickman.model.Entity_Folder.Background.Background_Colour;
import stickman.model.Entity_Folder.Background.Background_Trees;
import stickman.model.Entity_Folder.Clouds.Cloud;
import stickman.model.Entity_Folder.Clouds.CloudFactory;
import stickman.model.Entity_Folder.Platform_Folder.Platform;
import stickman.model.Entity_Folder.etc_Folders.Heart;
import stickman.model.Entity_Folder.Platform_Folder.PlatformFactory;
import stickman.model.Entity_Folder.Slime.Blue_slime;
import stickman.model.Entity_Folder.Slime.Enemy;
import stickman.model.Entity_Folder.Slime.Pinky;

import java.util.List;

public class Level1_object_instantiation {
    private Level level;
    private List<Cloud> Clouds;
    private List<Platform> Platforms;
    private List<Enemy> Enemies;
    private List<Heart> Hearts ;
    private List<Tick> Tickable;
    private List<Entity> Entities;
    private List<MovingEntity> MovingEntities;
    public Level1_object_instantiation(Level level){
        this.level = level;
        this.Clouds = level.getClouds();
        this.Platforms = level.getPlatforms();
        this.Enemies = level.getEnemies();
        this.Entities = level.getEntities();
        this.Hearts = level.getHearts();
        this.Tickable = level.getTickable();
        this.MovingEntities = level.getMovingEntities();
    }
    public void instantiate(){
        CloudFactory cloudFactory = new CloudFactory();
        PlatformFactory platformFactory = new PlatformFactory(this.level);
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
        switch (this.level.getLevel_type()){
            case Ice: case Windy:
                this.Entities.add(new Background_Colour("landscape_0005_6_background.png"));
                break;
            default:
                this.Entities.add(new Background_Colour("Blue_Background.png"));
                break;
        }
        this.Entities.add(new Background_Trees("landscape_0000_1_trees.png"));
        this.Entities.addAll(Clouds);
        this.Entities.addAll(Platforms);
        this.Entities.addAll(Enemies);
        this.Entities.addAll(Hearts);
        this.Tickable.addAll(Clouds);
        this.Tickable.addAll(Enemies);
        this.Tickable.addAll(Hearts);
        this.MovingEntities.addAll(Enemies);
    }
}
