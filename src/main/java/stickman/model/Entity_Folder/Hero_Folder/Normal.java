package stickman.model.Entity_Folder.Hero_Folder;

import stickman.model.Level_Folder.Level;

public class Normal implements LevelBehaviour {
    private Hero hero;
    private String behaviour;
    public Normal(Hero hero){
        this.hero = hero;
        this.behaviour = "Normal";
    }
    @Override
    public void do_behaviour() {
        this.hero.getLevel().setHeroX(this.hero.getXPos());
    }

    @Override
    public String getBehaviour() {
        return this.behaviour;
    }
}
