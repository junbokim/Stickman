package stickman.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import stickman.App;
import stickman.model.Entity_Folder.Size;
import stickman.model.Level_Folder.Level_Type;
import stickman.view.End_Screen_Status;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Stat_reader {
    private double start_position_x;
    private double Velocity;
    private Size size;
    private Level_Type level_type;
    private boolean Error;
    public Stat_reader(String fileName) throws IllegalArgumentException {
        this.Error = false;
        JSONParser parser = new JSONParser();
        try
        {
            URI uri = new URI(this.getClass().getResource(fileName).toString());
            BufferedReader bf = new BufferedReader(new FileReader(uri.getPath()));
            JSONObject file = (JSONObject) parser.parse(bf);
            this.Velocity = (double) file.get("cloudVelocity");
            this.level_type = Level_Type.valueOf((String) file.get("Level"));
            JSONObject stickmanPos = (JSONObject) file.get("stickmanPos");
            this.start_position_x = (double) stickmanPos.get("x");
            this.size = Size.valueOf((String) file.get("stickmanSize"));
            if(this.start_position_x > 200 || this.start_position_x < 50){
                throw new IllegalArgumentException();
            }
            if(this.Velocity > 5 || this.Velocity < 1){
                throw new IllegalArgumentException();
            }
            bf.close();
            file.clear();
        }
        catch(IllegalArgumentException e){
            this.Error = true;
            App.Finished(0, End_Screen_Status.Error);
        }
        catch (URISyntaxException | IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public double getstart_position_x(){
        return this.start_position_x;
    }
    public double getVelocity(){
        return this.Velocity;
    }
    public Size getSize(){
        return this.size;
    }
    public Level_Type getLevel_type() {
        return level_type;
    }
    public boolean isError() {
        return Error;
    }
}
