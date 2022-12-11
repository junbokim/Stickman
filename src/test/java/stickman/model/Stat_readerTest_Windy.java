package stickman.model;

import org.junit.Before;
import org.junit.Test;
import stickman.model.Level_Folder.Level_Type;

import static org.junit.Assert.*;

public class Stat_readerTest_Windy {
    private Stat_reader stat_reader;
    @Before
    public void setUp() throws Exception {
        this.stat_reader = new Stat_reader("/Windy.json");
    }
    @Test
    public void getLevel_type() {
        assertEquals(Level_Type.Windy, this.stat_reader.getLevel_type());
    }
}