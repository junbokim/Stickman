package stickman.model.Entity_Folder.Hero_Folder;

import stickman.model.Level_Folder.Level;

public class Windy implements LevelBehaviour {
    private int index;
    private Hero hero;
    private Normal normal;
    private String behaviour;
    public Windy(Hero hero ){
        this.hero = hero;
        this.index = 0;
        this.normal = new Normal(this.hero);
        this.behaviour = "Windy";
    }
    @Override
    public void do_behaviour() {
        if(index == 3){
            this.hero.MoveLeft();
            this.hero.platforminteract();
            index = 0;
        }
        else{
            index += 1;
        }
        this.normal.do_behaviour();
    }

    @Override
    public String getBehaviour() {
        return this.behaviour;
    }
}
