package stickman.model.Entity_Folder.Hero_Folder;

import stickman.model.Entity_Folder.*;
import stickman.model.Entity_Folder.Platform_Folder.Platform;
import stickman.model.Level_Folder.Level;

public class Hero_Terrain_interaction implements CheckTerrain {
    @Override
    public Whichside interact(Terrain_interactable entity, Level level) {
        double xpos = entity.getXPos();
        Hero hero = (Hero) entity;
        boolean LeftSide = false;
        boolean RightSide = false;
        boolean Middle = false;
        for (Platform terrain: level.getPlatforms()){
            LeftSide = xpos > terrain.getXPos() && xpos < terrain.getXPos() + terrain.getWidth();
            Middle = xpos + (entity.getWidth()/2) > terrain.getXPos() && xpos + (entity.getWidth()/2) < terrain.getXPos() + terrain.getWidth();
            RightSide = xpos + entity.getWidth() > terrain.getXPos() && xpos + entity.getWidth() < terrain.getXPos() + terrain.getWidth();
            if(LeftSide||Middle|| RightSide){
                if(entity.getYPos() + entity.getHeight() == terrain.getYPos()){
                    if(entity.getFalling()){
                        return Whichside.Top;
                    }
                    else{
                        return Whichside.TopStay;
                    }
                }
                if(entity.getYPos() + entity.getHeight() > terrain.getYPos()){
                    switch (hero.getFacingDirection()){
                        case LEFT: case LEFTSTILL: case JUMPLEFT:
                            if(RightSide){
                                return Whichside.SideLeft;
                            }
                            if(LeftSide){
                                return Whichside.SideRight;
                            }
                        case RIGHTSTILL:case JUMPRIGHT:case RIGHT:
                            if(RightSide){
                                return Whichside.SideLeft;
                            }
                            if(LeftSide){
                                return Whichside.SideRight;
                            }
                    }
                }
            }
        }
        return Whichside.None;
    }
}
