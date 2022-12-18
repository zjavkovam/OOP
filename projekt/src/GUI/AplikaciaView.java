package GUI;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * zobrazenie uvodneho okna s menu
 */

public class AplikaciaView {
    private ScrollPane pane;
    private Scene scene;
    private Stage stage;


    private Button zamestnanec = new Button("Zamestnanec");
    private Button zakaznik = new Button("Zakaznik");

    public AplikaciaView(Stage primaryStage, AplikaciaController controller) {
        this.stage = primaryStage;
        this.pane = new ScrollPane();

        zamestnanec.setOnAction(controller);
        zakaznik.setOnAction(controller);

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(zamestnanec);
        flowPane.getChildren().add(zakaznik);
        pane.setContent(flowPane);

        this.scene = new Scene(pane, 500, 700);
        stage.setTitle("Obchod s keramikou");
        stage.setScene(scene);
    }


    public Button getZakaznik() {
        return zakaznik;
    }

    public Button getZamestnanec(){
        return zamestnanec;
    }
}
