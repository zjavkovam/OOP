package GUI;

import Obchod.Obchod;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class AplikaciaController implements EventHandler<ActionEvent> {
    Obchod obchod;
    AplikaciaView view;
    Stage primaryStage;

    public AplikaciaController(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.view = new AplikaciaView(primaryStage,this);
        this.obchod = Obchod.getInstance();
    }

    /**
     * prepne sa do okna pre zamestnanca alebo zakaznika podla stlacenia buttonu
     */
    public void handle(ActionEvent event){

        if (event.getSource()==view.getZakaznik()){
            ZakaznikController zakzanikC = new ZakaznikController(primaryStage);
        }

        if(event.getSource()==view.getZamestnanec()){
            ZamestnanecController zamC = new ZamestnanecController(primaryStage);
        }
    }

    public AplikaciaView getView(){
        return view;
    }
}
