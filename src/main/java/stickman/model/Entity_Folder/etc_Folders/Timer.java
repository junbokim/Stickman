package stickman.model.Entity_Folder.etc_Folders;

import stickman.model.Entity_Folder.Tick;

public class Timer implements Tick {
    int time;
    public Timer(){
        this.time = 0;
    }
    public void tick(){
        this.time += 1;
    }
    public int getTime() {
        return this.time / 170;
    }
}
