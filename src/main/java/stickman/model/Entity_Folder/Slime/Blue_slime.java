package stickman.model.Entity_Folder.Slime;

import stickman.model.Level_Folder.Level;
import stickman.model.Entity_Folder.Size;

public class Blue_slime extends Enemy {
    public Blue_slime(Size size, double startingxPosition, Level level) {
        super(size, startingxPosition, level);
        this.ImagePath = "slimeBa.png";
        this.Speed = +0.25;
        this.behaviours = new Slime_Jumpy(this.YPos, this);
    }
    @Override
    public void switchImage(){
        if(this.ImagePath.equals("slimeBa.png")){
            this.ImagePath = "slimeBb.png";
        }
        else{
            this.ImagePath = "slimeBa.png";
        }
    }

    @Override
    public void tick(){
        if(this.tickcount == 100){
            switchImage();
            this.tickcount = 0;
        }
        else {
            this.tickcount += 1;
        }
        this.behaviours.do_behaviour();
        this.platforminteract();
    }

}
