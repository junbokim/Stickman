package stickman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import stickman.model.GameEngine;
import stickman.model.GameEngineImpl;
import stickman.view.Draw_Entities.Background_resolutions;
import stickman.view.End_Screen_Status;
import stickman.view.GameWindow;
import stickman.view.End_Screen;
import java.util.Map;

public class App extends Application {
    private static Stage stage;
    private static Background_resolutions background_resolutions;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Map<String, String> params = getParameters().getNamed();
        String s = "Java 11 sanity check";
        if (s.isBlank()) {
            throw new IllegalStateException("You must be running Java 11+. You won't ever see this exception though" +
                    " as your code will fail to compile on Java 10 and below.");
        }

        window_run(primaryStage);
    }
    public static void window_run(Stage primaryStage){
        stage = primaryStage;
        GameEngine model = new GameEngineImpl("/default.json");
        if(!model.isError()){
            background_resolutions = new Background_resolutions(model, 640, 400);
            GameWindow window = new GameWindow(model, 640, 400);
            window.run();
            primaryStage.setTitle("Stickman");
            primaryStage.setScene(window.getScene());
            primaryStage.show();
            window.run();
        }
    }
    public static void Finished(int time, End_Screen_Status end_screen_status){
        if(end_screen_status.equals(End_Screen_Status.Error)){
            background_resolutions = new Background_resolutions(640,400);
        }
        String title = titleGenerator(end_screen_status);
        background_resolutions.setText(StringGenerator( time, end_screen_status));
        Pane pane = new Pane();
        End_Screen endScreen = new End_Screen(background_resolutions);
        endScreen.draw(pane);
        Scene scene = new Scene(pane, 640,400);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    public static void end(){
        stage.close();
    }
    public static void restart(){window_run(stage);}
    public static String StringGenerator(int Time, End_Screen_Status end_screen_status){
        String txt = "";
        int seconds = Time;
        int minutes = 0;
        int hours = 0;
        String timeText;
        if(seconds >= 60){
            minutes = seconds/60;
            seconds = seconds - (minutes *60);
            if(minutes > 60){
                hours = minutes/60;
                hours = minutes - (hours * minutes);
            }
        }
        if(hours > 0){
            timeText = Integer.toString(hours) + " Hours\n" + Integer.toString(minutes) + " Minutes\n" + Integer.toString(seconds) + " Seconds\n";
        }
        else if(hours == 0 && minutes > 0){
            timeText = Integer.toString(minutes) + " Minutes\n" + Integer.toString(seconds) + " Seconds\n";
        }
        else{
            timeText = Integer.toString(seconds) + " Seconds\n";
        }
        switch (end_screen_status){
            case Won:
                txt = "Congratulations! \n You have successfully finished the level!\n " +
                        "You have taken \n" + timeText+ " To complete the Level!";
                break;
            case Lost:
                txt = "You have lost this game... \n maybe next time you would be able to win!\n You took " + timeText + " to complete!";
                break;
            case Error:
                txt = "There appears to be an error present\n" +
                        "in your Json File Settings\n" +
                        "Please have a look and try again";
                break;
        }
        return txt;
    }
    public static String titleGenerator(End_Screen_Status end_screen_status){
        switch (end_screen_status){
            case Won:
                return "Congratulations!!! You Won!!";
            case Lost:
                return "Uh...Oh...You lost...";
            case Error:
                return "Error!! There was something wrong!";
        }
        return "This should not be printing";
    }
    public static Background_resolutions getBackground_resolutions() {
        return background_resolutions;
    }
}
