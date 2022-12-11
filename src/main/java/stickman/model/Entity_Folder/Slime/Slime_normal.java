package stickman.model.Entity_Folder.Slime;

public class Slime_normal implements Slime_behaviours {
    private Enemy enemy;
    public Slime_normal(Enemy enemy){
        this.enemy = enemy;
    }
    @Override
    public void do_behaviour() {
        if(this.enemy.Left){
            this.enemy.MoveLeft();
        }
        else{
            this.enemy.MoveRight();
        }
    }
}
