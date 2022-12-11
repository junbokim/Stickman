package stickman.model.Level_Folder;

import stickman.model.Entity_Folder.Clouds.Cloud;
import stickman.model.Entity_Folder.Hero_Folder.Hero;
import stickman.model.Entity_Folder.MovingEntity;
import stickman.model.Entity_Folder.Platform_Folder.GrassyPlatform;
import stickman.model.Entity_Folder.Platform_Folder.Platform;
import stickman.model.Entity_Folder.Slime.Enemy;
import stickman.model.Entity_Folder.Entity;
import stickman.model.Entity_Folder.etc_Folders.Heart;
import stickman.model.Entity_Folder.Tick;
import stickman.model.Entity_Folder.etc_Folders.Timer;
import stickman.view.End_Screen_Status;

import java.util.List;

public interface Level {
    List<Platform> getPlatforms();
    List<Entity> getEntities();
    List<Enemy> getEnemies();
    Timer getTimer();
    void tick();
    void reset();
    double getFloorHeight();
    double getHeroX();
    void setHeroX(double XPos);
    void deleteEnemy(Enemy enemy);
    Hero getProtagonist();
    void finished(End_Screen_Status end_screen_status);
    void setLevelFinished();
    boolean getLevelFinished();
    List<Cloud> getClouds();
    List<Heart> getHearts();
    List<Tick> getTickable();
    double getCloudVelocity();
    Level_Type getLevel_type();
    List<MovingEntity> getMovingEntities();
}
