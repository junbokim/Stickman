package stickman.model.Entity_Folder.Hero_Folder;

import stickman.model.Entity_Folder.Entity;
import stickman.model.Entity_Folder.ImgUpdate;

public class Hero_movement implements ImgUpdate {
    byte counter = 0;
    private Hero hero;

    public void update(Entity hero){
        this.hero = (Hero) hero;
        switch(this.hero.getFacingDirection()){
            case RIGHT:
                updateRight(hero);
                break;
            case LEFT:
                updateLeft(hero);
                break;
            case LEFTSTILL:
                updateRest_left(hero);
                break;
            case RIGHTSTILL:
                updateRest_right(hero);
                break;
            case JUMPLEFT:
                jumpLeft(hero);
                break;
            case JUMPRIGHT:
                jumpRight(hero);
                break;
        }
    }
    public void jumpLeft(Entity Entity){
        this.hero.setImage("ch_walk8.png");
    }
    public void jumpRight(Entity Entity){
        this.hero.setImage("ch_walk4.png");
    }
    @Override
    public void updateRight(Entity entity) {
        switch (this.hero.getImagePath()){
            case "ch_walk1.png":case "ch_walk2.png":case "ch_walk3.png":case "ch_walk4.png":
                if (counter == 10){
                    counter = 0;
                    switch(this.hero.getImagePath()){
                        case "ch_walk1.png":
                            hero.setImage("ch_walk2.png");
                            break;
                        case "ch_walk2.png":
                            hero.setImage("ch_walk3.png");
                            break;
                        case "ch_walk3.png":
                            hero.setImage("ch_walk4.png");
                            break;
                        default:
                            hero.setImage("ch_walk1.png");
                            break;
                    }
                }
                else{
                    counter += 1;
                }
                break;
            default:
                hero.setImage("ch_walk1.png");
                break;
        }
    }
    @Override
    public void updateLeft(Entity entity) {
        switch(this.hero.getImagePath()){
            case("ch_walk5.png"):case("ch_walk6.png"):case("ch_walk7.png"):case("ch_walk8.png"):
                if(counter == 10){
                    counter = 0;
                    switch(this.hero.getImagePath()){
                        case("ch_walk5.png"):
                            hero.setImage("ch_walk6.png");
                            break;
                        case("ch_walk6.png"):
                            hero.setImage("ch_walk7.png");
                            break;
                        case("ch_walk7.png"):
                            hero.setImage("ch_walk8.png");
                            break;
                        default:
                            hero.setImage("ch_walk5.png");
                            break;
                    }
                }
                else{
                    counter += 1;
                }
                break;
            default:
                hero.setImage("ch_walk5.png");
                break;
        }
    }
    @Override
    public void updateRest_right(Entity entity) {
        switch (this.hero.getImagePath()){
            case("ch_stand1.png"):case("ch_stand2.png"):case("ch_stand3.png"):
                if(counter == 10){
                    counter = 0;
                    switch(this.hero.getImagePath()){
                        case("ch_stand1.png"):
                            hero.setImage("ch_stand2.png");
                            break;
                        case("ch_stand2.png"):
                            hero.setImage("ch_stand3.png");
                            break;
                        default:
                            hero.setImage("ch_stand1.png");
                            break;
                    }
                }
                else{
                    counter += 1;
                }
                break;
            default:
                hero.setImage("ch_stand1.png");
                break;
        }
    }
    @Override
    public void updateRest_left(Entity entity) {
        switch  (this.hero.getImagePath()){
            case("ch_stand4.png"):case("ch_stand5.png"):case("ch_stand6.png"):
                if(counter == 10){
                    counter = 0;
                    switch(this.hero.getImagePath()){
                        case("ch_stand4.png"):
                            hero.setImage("ch_stand5.png");
                            break;
                        case("ch_stand5.png"):
                            hero.setImage("ch_stand6.png");
                            break;
                        default:
                            hero.setImage("ch_stand4.png");
                            break;
                    }
                }
                else{
                    counter += 1;
                }
                break;
            default:
                hero.setImage("ch_stand4.png");
        }
    }
}
