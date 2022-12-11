package stickman.model.Entity_Folder.Clouds;

import stickman.model.Entity_Folder.EntityType;

public class CloudFactory{
    public Cloud makeCloud(double velocity, EntityType type, double start_position_x, double start_position_y) {
        switch(type){
            case type1:
                return new Cloud(velocity/4, start_position_x,start_position_y,  "cloud_1.png");
            case type2:
                return new Cloud(velocity/2, start_position_x,start_position_y, "cloud_2.png");
            default:
                return null;
        }
    }
}
