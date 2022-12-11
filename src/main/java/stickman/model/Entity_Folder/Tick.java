package stickman.model.Entity_Folder;

public interface Tick {
    void tick();
    default boolean tickable(){return true;}
}
