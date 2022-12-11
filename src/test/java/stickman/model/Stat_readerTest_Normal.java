package stickman.model;

import org.junit.Before;
import org.junit.Test;
import stickman.model.Entity_Folder.Size;
import stickman.model.Level_Folder.Level_Type;

import static org.junit.Assert.*;

public class Stat_readerTest_Normal {
    private Stat_reader stat_reader;
    @Before
    public void setUp() throws Exception {
        this.stat_reader = new Stat_reader("/Test_Default.json");
    }

    @Test
    public void getstart_position_x() {
        assertEquals(50,this.stat_reader.getstart_position_x(),0.001);
    }

    @Test
    public void getVelocity() {
        assertEquals(3.2, this.stat_reader.getVelocity(),0.001);
    }

    @Test
    public void getSize() {
        assertEquals(Size.Normal, this.stat_reader.getSize());
    }

    @Test
    public void getLevel_type() {
        assertEquals(Level_Type.Normal, this.stat_reader.getLevel_type());
    }
}