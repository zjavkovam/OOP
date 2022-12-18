package GUI;

import Ludia.Zamestnanec;
import Obchod.Obchod;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.Stage;


/**
 * Kontroler pre okno zakaznika, ktory spracovava udalosti pri kliknuti na button
 * po stlaceni sa zavola prislusna funkcia
 */

public class ZakaznikController implements EventHandler<ActionEvent> {
    Obchod obchod;
    ZakaznikView view;
    Stage primaryStage;

    public ZakaznikController(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.view = new ZakaznikView(primaryStage,this);
        this.obchod = Obchod.getInstance();
    }

    public void handle(ActionEvent event){
        /**
         * vytvorenie objednavky
         */
        if (event.getSource() == view.getObjednat()) {
            view.getVypis().appendText("Objednávka bola zaregistrovaná.\n");
            view.getVypis().appendText(obchod.vybavit_objednavku(obchod,
                    view.getTypHmoty().getText(),
                    view.getFarba().getText(),
                    view.getTypKeramiky().getText(),
                    view.getGlazura().getText(),
                    view.getMeno().getText()));
        }
        /**
         * vratenie sa na predchadzajucu stranku
         */
        if(event.getSource() == view.getSpat()){
            AplikaciaController aplikaciaC = new AplikaciaController(primaryStage);
        }
    }

    public ZakaznikView getView(){
        return view;
    }
}
