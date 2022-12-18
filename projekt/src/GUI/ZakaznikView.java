package GUI;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *View trieda, ktorej ulohou je vytvorit scenu pre zobrazenie okna zakaznika
 * Obsahuje okna na napisanie objednavky a tlacidla pre objednanie
 * Vypise sa text na potvrdenie objednavky s cenou
 */

public class ZakaznikView{
    private ScrollPane pane;
    private Scene scene;
    private Stage stage;


    private TextField typHmoty = new TextField();
    private TextField farba = new TextField();
    private TextField typKeramiky = new TextField();
    private TextField glazura = new TextField();
    private TextField meno = new TextField();

    private Label LtypHmoty = new Label("Typ Hmoty: hlina/porcelan  ");
    private Label Lfarba = new Label("Farba: biela, modra, zlta, cervena  ");
    private Label LtypKeramiky = new Label("Keramika: tanier, vaza, hrncek  ");
    private Label Lglazura = new Label("Typ glazury: matna/leskla  ");
    private Label Lmeno = new Label("Meno:");

    private TextArea vypis = new TextArea();
    private Button objednat = new Button("Objednat");
    private Button spat = new Button("Spat");

    public ZakaznikView(Stage primaryStage, ZakaznikController controller) {
        this.stage = primaryStage;
        this.pane = new ScrollPane();
        objednat.setOnAction(controller);
        spat.setOnAction(controller);

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(LtypHmoty);
        flowPane.getChildren().add(typHmoty);
        flowPane.getChildren().add(Lfarba);
        flowPane.getChildren().add(farba);
        flowPane.getChildren().add(LtypKeramiky);
        flowPane.getChildren().add(typKeramiky);
        flowPane.getChildren().add(Lglazura);
        flowPane.getChildren().add(glazura);
        flowPane.getChildren().add(Lmeno);
        flowPane.getChildren().add(meno);
        flowPane.getChildren().add(objednat);
        flowPane.getChildren().add(vypis);
        flowPane.getChildren().add(spat);


        pane.setContent(flowPane);

        this.scene = new Scene(pane, 500, 700);
        stage.setTitle("Obchod s keramikou");
        stage.setScene(scene);
    }

    public Button getObjednat(){
        return objednat;
    }

    public TextArea getVypis(){
        return vypis;
    }

    public TextField getTypHmoty(){
        return typHmoty;
    }

    public TextField getFarba() {
        return farba;
    }

    public TextField getGlazura() {
        return glazura;
    }

    public TextField getTypKeramiky() {
        return typKeramiky;
    }

    public Button getSpat(){
        return this.spat;
    }

    public TextField getMeno() {
        return meno;
    }
}
