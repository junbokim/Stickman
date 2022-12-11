package stickman.model.Entity_Folder.Hero_Folder;

import stickman.model.Entity_Folder.*;
import stickman.model.Entity_Folder.Slime.Enemy;
import stickman.model.Level_Folder.Level;

public class Hero_Enemy_interaction implements CheckTerrain {
    @Override
    public Whichside interact(Terrain_interactable entity, Level level) {
        double xpos = entity.getXPos();
        for(Enemy enemy : level.getEnemies()){
            if(xpos > enemy.getXPos() && xpos < enemy.getXPos() + enemy.getWidth() || xpos + entity.getWidth() > enemy.getXPos() && xpos+ entity.getWidth() < enemy.getXPos() + enemy.getWidth()){
                if(entity.getYPos() + entity.getHeight() == enemy.getYPos()){
                    if(entity.getFalling()){
                        level.deleteEnemy(enemy);
                        return Whichside.Top;
                    }
                }
                if(entity.getYPos() + entity.getHeight() >= enemy.getYPos() && entity.getYPos() + entity.getHeight() <= enemy.getYPos() + enemy.getHeight()
                        || entity.getYPos()>= enemy.getYPos() && entity.getYPos()<= enemy.getYPos() + enemy.getHeight()){
                    return Whichside.Side;
                }
            }
        }
        return Whichside.None;
    }
}