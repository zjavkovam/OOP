package Priestory;

import Keramika.Keramika;

import java.util.ArrayList;
import java.util.List;

public class Sklad {
    ArrayList<Keramika> hotove = new ArrayList<Keramika>();
    int mnozstvo_hmota = 50;
    int mnozstvo_glazura = 50;


    /**
     * Implementacia navrhoveho vzoru observer
     * predstavuje ho zoznam so sledovatelmi a nasledne metoda, ktorá ich povedomi
     */
    private List<SkladObserver> sledovatelia = new ArrayList<>();
    public void pridajSledovatela(SkladObserver observer) {
        sledovatelia.add(observer);
    }

    public void upovedomSledovatelov() {
        for (SkladObserver s : sledovatelia) {
            s.upovedom(this);
        }
    }


    /**
     * metóda na úpravu stavu skladu
     * @param n - počet o ktorý sa zvýši stav v sklade
     * @param material - daný materiál, u ktorého sa zmení počet
     */
    public void set_sklad(int n, String material){
        if(material.equals("hmota")){
            this.mnozstvo_hmota += n;
        }

        if(material.equals("glazura")){
            this.mnozstvo_glazura += n;
        }

        upovedomSledovatelov();
    }

    /** vráti mnozstvo skladu podla poziadavke v parametry*/
    public int get_sklad(String material){
        if(material.equals("hmota")){
            return this.mnozstvo_hmota;
        }

        if(material.equals("glazura")){
            return this.mnozstvo_glazura;
        }
        return 0;
    }

    /**
     * Zistenie aktuálneho stavu počtu surovín na  sklade
     */
    public String stavSkladu(){
        String s = "Množstvo hmoty: "+this.mnozstvo_hmota+"kg.\n" +
                "Množstvo glázury: "+this.mnozstvo_glazura+"kg.\n";
        return s;
    }

    /**vybratie poslednej hotovej keramiky*/
    public Keramika zoberKeremiku(){
        return this.hotove.get(hotove.size()-1);
    }

    /**vlozenie do zoznamu s hotovou keramikoi */
    public void hotove(Keramika k){
        this.hotove.add(k);
    }
}
