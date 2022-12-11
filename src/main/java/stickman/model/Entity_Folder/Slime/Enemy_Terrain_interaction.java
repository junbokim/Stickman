package stickman.model.Entity_Folder.Slime;

import stickman.model.Entity_Folder.*;
import stickman.model.Entity_Folder.Platform_Folder.Platform;
import stickman.model.Entity_Folder.Platform_Folder.GrassyPlatform;
import stickman.model.Level_Folder.Level;

public class Enemy_Terrain_interaction implements CheckTerrain {
    @Override
    public Whichside interact(Terrain_interactable entity, Level level) {
        double xpos = entity.getXPos();
        for(Platform terrain : level.getPlatforms()){
            if(xpos > terrain.getXPos() &&
                            xpos < terrain.getXPos() + terrain.getWidth() ||
                            xpos + entity.getWidth() > terrain.getXPos() &&
                                    xpos+ entity.getWidth() < terrain.getXPos() + terrain.getWidth()){
                return Whichside.Side;
            }
        }
        return Whichside.None;
    }
}
