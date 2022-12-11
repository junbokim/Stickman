package stickman.model.Entity_Folder;

public interface Entity {
    //Getting Image for the object
    String getImagePath();
    boolean getstay();
    //Getting X and Y position of the object
    double getXPos();
    double getYPos();

    //Getting the size of the obejct
    double getHeight();
    double getWidth();

    // getting the Layer associated with the object
    Layer getLayer();
    // Layer enum to attach onto object Entity;
    enum Layer{
        BACKGROUND, FOREGROUND, EFFECT
    }
}
