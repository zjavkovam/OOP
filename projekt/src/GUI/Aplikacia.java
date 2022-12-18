package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * hlavna trieda z ktorej sa spusta aplikcacia
 */
public class Aplikacia  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Obchod s Keramikou");
        AplikaciaController controler = new AplikaciaController(primaryStage);
        primaryStage.show();
    }
}