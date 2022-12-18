package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


/**
 *View trieda, ktorej ulohou je vytvorit scenu pre zobrazenie okna zamestnanca
 * Obsahuje buttony a text area na vypis
 */

public class ZamestnanecView{
    private ScrollPane pane;
    private Scene scene;
    private Stage stage;

    private Button stavSkladu = new Button("Stav Skladu");
    private Button uzavierka = new Button("Uzavierka");
    private Button vypisatZamestnancov = new Button("Vypisat zamestnancov");
    private Button vypisZakaznikov = new Button("Vypisat zakaznikov");
    private Button spat = new Button("Spat");

    private TextArea vypis = new TextArea();

    public ZamestnanecView(Stage primaryStage, ZamestnanecController controller){
        this.stage = primaryStage;
        this.pane = new ScrollPane();


        stavSkladu.setOnAction(controller);
        uzavierka.setOnAction(controller);
        spat.setOnAction(controller);
        vypisatZamestnancov.setOnAction(controller);
        vypisZakaznikov.setOnAction(controller);


        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(stavSkladu);
        flowPane.getChildren().add(uzavierka);
        flowPane.getChildren().add(vypisatZamestnancov);
        flowPane.getChildren().add(vypisZakaznikov);
        flowPane.getChildren().add(vypis);
        flowPane.getChildren().add(spat);

        pane.setContent(flowPane);

        this.scene = new Scene(pane, 500, 700);
        stage.setTitle("Zamestnanec");
        stage.setScene(scene);
    }


    public Button getUzavierka() {
        return uzavierka;
    }

    public Button getStavSkladu(){
        return stavSkladu;
    }

    public TextArea getVypis(){
        return this.vypis;
    }

    public Button getSpat() {
        return spat;
    }

    public Button getVypisatZamestnancov() {
        return vypisatZamestnancov;
    }

    public Button getVypisZakaznikov() {
        return vypisZakaznikov;
    }
}
