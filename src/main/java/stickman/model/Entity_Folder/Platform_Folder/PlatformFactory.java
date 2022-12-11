package stickman.model.Entity_Folder.Platform_Folder;

import stickman.model.Entity_Folder.Size;
import stickman.model.Level_Folder.Level;
import stickman.model.Level_Folder.Level_Type;

public class PlatformFactory {
    World_State world_state;
    public PlatformFactory(Level level){
        if (level.getLevel_type().equals(Level_Type.Ice)) {
            this.world_state = World_State.Ice;
        } else {
            this.world_state = World_State.Normal;
        }
    }
    public Platform platform_maker(Size size, double start_position){
        if (this.world_state.equals(World_State.Ice)) {
            return new IcyPlatform(size, start_position);
        }
        return new GrassyPlatform(size, start_position);
    }

    public World_State getWorld_state() {
        return world_state;
    }
}
