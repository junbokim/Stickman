package stickman.model;

import stickman.model.Level_Folder.Level;

public interface GameEngine {
    Level getCurrentLevel();

    // Hero inputs - boolean for success (possibly for sound feedback)
    boolean jump();
    void moveLeft();
    void moveRight();
    void stopMoving();

    void tick();
    boolean isError();
}
