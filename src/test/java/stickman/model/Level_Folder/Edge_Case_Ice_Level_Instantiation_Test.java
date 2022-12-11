package stickman.model.Level_Folder;

import org.junit.Test;
import stickman.model.Entity_Folder.Size;

import static org.junit.Assert.*;

public class Edge_Case_Ice_Level_Instantiation_Test {

    @Test
    public void Hero_XPos_Testing_Input_Below_0(){
        Level level = new Current_Level(Size.Normal,0,0,Level_Type.Ice);
        assertEquals(50,level.getProtagonist().getXPos(),0.001);
    }
    @Test
    public void Hero_XPos_Testing_Input_Above_200(){
        Level level = new Current_Level(Size.Normal,2000,0,Level_Type.Ice);
        assertEquals(200,level.getProtagonist().getXPos(),0.001);
    }
    @Test
    public void Cloud_Velocity_Equal_0(){
        Level level = new Current_Level(Size.Normal,2000,0,Level_Type.Ice);
        assertEquals(1,level.getCloudVelocity(),0.001);
    }
    @Test
    public void Cloud_Velocity_Below_0(){
        Level level = new Current_Level(Size.Normal,2000,-10,Level_Type.Ice);
        assertEquals(1,level.getCloudVelocity(),0.001);
    }

    @Test
    public void Level_Type_Ice(){
        Level level = new Current_Level(Size.Normal,0,0,Level_Type.Ice);
        assertEquals(50,level.getProtagonist().getXPos(),0.001);
        assertEquals(Level_Type.Ice, level.getLevel_type());
    }
    @Test
    public void Level_Type_Windy(){
        Level level = new Current_Level(Size.Normal,0,0,Level_Type.Windy);
        assertEquals(50,level.getProtagonist().getXPos(),0.001);
        assertEquals(Level_Type.Windy, level.getLevel_type());
    }

}