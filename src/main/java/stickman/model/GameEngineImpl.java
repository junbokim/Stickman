package stickman.model;

import stickman.model.Entity_Folder.Hero_Folder.FacingDirection;
import stickman.model.Level_Folder.Current_Level;
import stickman.model.Level_Folder.Level;

public class GameEngineImpl implements GameEngine{
    private Level level;
    private boolean Error;

    public GameEngineImpl(String fileName){
        Stat_reader stat = new Stat_reader(fileName);
        this.Error = stat.isError();
        if(!this.Error){
            this.level = new Current_Level(stat.getSize(),stat.getstart_position_x(), stat.getVelocity(), stat.getLevel_type());
        }
    }
    @Override
    public Level getCurrentLevel() {
        return this.level;
    }
    @Override
    public boolean jump() {
        return(this.getCurrentLevel().getProtagonist().SetJump());
    }
    @Override
    public void moveLeft() {
        this.getCurrentLevel().getProtagonist().setMovementDirection(FacingDirection.LEFT);
    }
    @Override
    public void moveRight() {
        this.getCurrentLevel().getProtagonist().setMovementDirection(FacingDirection.RIGHT);
    }
    @Override
    public void stopMoving() {
        this.getCurrentLevel().getProtagonist().StopMoving();
    }
    @Override
    public void tick() {
        if(!this.level.getLevelFinished() && !this.Error){
            this.level.tick();
        }
    }

    public boolean isError() {
        return Error;
    }
}
