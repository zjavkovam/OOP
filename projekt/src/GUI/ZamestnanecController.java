package GUI;

import Obchod.Obchod;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.Stage;

/**
 * Kontroler pre okno zamestnanca, ktory spracovava udalosti pri kliknuti na button
 * po stlaceni sa zavola prislusna funkcia
 */
public class ZamestnanecController implements EventHandler<ActionEvent> {
    Obchod obchod;
    ZamestnanecView view;
    Stage primaryStage;

    public ZamestnanecController(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.view = new ZamestnanecView(primaryStage,this);
        this.obchod = Obchod.getInstance();
    }

    public void handle(ActionEvent event){
        /**
         *vratit sa na uvodnu stranku
         */
        if(event.getSource() == view.getSpat()){
            AplikaciaController aplikaciaC = new AplikaciaController(primaryStage);
        }

        /**
         *metoda na vypisanie ziskov a predaja
         */
        if (event.getSource()==view.getUzavierka()){
            view.getVypis().appendText(obchod.uzavierka());
        }


        /**
         * metoda na vypisanie stavu skladu
         */
        if (event.getSource()==view.getStavSkladu()){
            view.getVypis().appendText(obchod.getSklad().stavSkladu());
        }

        if (event.getSource()==view.getVypisZakaznikov()){
            System.out.println("M");
            view.getVypis().appendText(obchod.vypisZakaznikov());
        }

        if(event.getSource()==view.getVypisatZamestnancov()){
            view.getVypis().appendText(obchod.vypisZamestnancov());
        }
    }
}
