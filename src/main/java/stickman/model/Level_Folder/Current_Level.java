package stickman.model.Level_Folder;

import stickman.App;
import stickman.model.Entity_Folder.Clouds.Cloud;
import stickman.model.Entity_Folder.Entity;
import stickman.model.Entity_Folder.MovingEntity;
import stickman.model.Entity_Folder.Platform_Folder.Platform;
import stickman.model.Entity_Folder.Size;
import stickman.model.Entity_Folder.Tick;
import stickman.model.Entity_Folder.etc_Folders.Heart;
import stickman.model.Entity_Folder.etc_Folders.Timer;
import stickman.model.Entity_Folder.Hero_Folder.Hero;
import stickman.model.Entity_Folder.Slime.Enemy;
import stickman.view.End_Screen_Status;

import java.util.ArrayList;
import java.util.List;

public class Current_Level implements Level {
    // entitities
    private List<Cloud> Clouds;
    private List<Platform> Platforms;
    private List<Heart> Hearts;
    private List<Enemy> Enemies;
    private List<Entity> Entity;
    private List<MovingEntity> MovingEntities;
    private List<Tick> Tickable;

    private Timer timer;
    private Hero Protagonist;
    private double FloorHeight;
    private double HeroX;
    private boolean LevelFinished;
    private double CloudVelocity;

    private Level_Type level_type;

    public Current_Level(Size size, double start_position, double cloud_velocity, Level_Type level_type){
        if(start_position <50){
            start_position = 50;
        }
        else if(start_position >200){
            start_position = 200;
        }
        if(cloud_velocity <= 0){
            cloud_velocity = 1;
        }
        this.Tickable = new ArrayList<Tick>();
        this.Clouds = new ArrayList<Cloud>();
        this.Platforms = new ArrayList<Platform>();
        this.Hearts = new ArrayList<Heart>();
        this.Enemies = new ArrayList<Enemy>();
        this.MovingEntities = new ArrayList<MovingEntity>();
        this.Protagonist = new Hero(size, start_position, this, level_type);
        this.timer = new Timer();
        this.Tickable.add(this.timer);
        this.Tickable.add(this.Protagonist);
        this.MovingEntities.add(this.Protagonist);
        this.FloorHeight = 334;
        this.HeroX = this.Protagonist.getXPos();
        switch (level_type){
            case Windy:
                this.CloudVelocity = -cloud_velocity*2;
                break;
            default:
                this.CloudVelocity = cloud_velocity;
                break;
        }
        this.Entity = new ArrayList<>();
        this.Entity.add(0, this.Protagonist);
        this.LevelFinished = false;
        this.level_type = level_type;
        new Level1_object_instantiation(this).instantiate();
    }

    @Override
    public List<Platform> getPlatforms() {
        return this.Platforms;
    }
    @Override
    public List<Entity> getEntities() {
        return this.Entity;
    }
    @Override
    public List<Enemy> getEnemies() {
        return Enemies;
    }
    @Override
    public void deleteEnemy(Enemy enemy){
        this.Entity.remove(enemy);
        this.Enemies.remove(enemy);
    }
    @Override
    public Timer getTimer() {
        return timer;
    }
    @Override
    public void tick(){
        for(Tick tickable: Tickable){
            tickable.tick();
        }
    }
    @Override
    public void reset(){
        if(this.Hearts.size() >0){
            Heart to_remove = this.Hearts.get(this.Hearts.size()-1);
            this.Hearts.remove(to_remove);
            this.Entity.remove(to_remove);
        }
        else{
            this.LevelFinished = true;
            App.Finished(this.timer.getTime(), End_Screen_Status.Lost);
        }
    }
    @Override
    public double getFloorHeight() {
        return this.FloorHeight;
    }
    @Override
    public double getHeroX() {
        return this.HeroX;
    }
    public void setHeroX(double XPos){ this.HeroX = XPos;}
    @Override
    public Hero getProtagonist(){return this.Protagonist;}
    @Override
    public void finished(End_Screen_Status end_screen_status){
        App.Finished(this.timer.getTime(), end_screen_status);
    }
    @Override
    public void setLevelFinished() {
        this.LevelFinished = true;
    }
    @Override
    public boolean getLevelFinished(){
        return this.LevelFinished;
    }
    @Override
    public List<Cloud> getClouds() {
        return Clouds;
    }
    @Override
    public List<Heart> getHearts() {
        return Hearts;
    }
    @Override
    public List<Tick> getTickable() {
        return Tickable;
    }
    @Override
    public double getCloudVelocity() {
        return CloudVelocity;
    }
    @Override
    public Level_Type getLevel_type() {
        return level_type;
    }
    @Override
    public List<MovingEntity> getMovingEntities() {
        return MovingEntities;
    }
}
