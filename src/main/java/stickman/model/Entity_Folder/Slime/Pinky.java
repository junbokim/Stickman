package stickman.model.Entity_Folder.Slime;

import stickman.model.Entity_Folder.Size;
import stickman.model.Level_Folder.Level;

public class Pinky extends Enemy {
    public Pinky(Size size, double startingxPosition, Level level) {
        super(size, startingxPosition, level);
        this.ImagePath = "slimeRa.png";
        this.Speed = +1;
        this.behaviours = new Slime_normal(this);
    }

    @Override
    public void switchImage(){
        if(this.ImagePath.equals("slimeRa.png")){
            this.ImagePath = "slimeRb.png";
        }
        else{
            this.ImagePath = "slimeRa.png";
        }
    }

    @Override
    public void tick(){
        if(this.tickcount == 50){
            switchImage();
            this.tickcount = 0;
        }
        else{
            this.tickcount += 1;
        }
        this.behaviours.do_behaviour();
        this.platforminteract();
    }
}
