package Priestory;

import java.util.Random;
import Keramika.Keramika;
import Ludia.*;
import Nastroje.PecNaVypalovanie;
import Obchod.*;

import java.util.ArrayList;

public class Dielna {
    private int upratane = 100;
    private PecNaVypalovanie pec = new PecNaVypalovanie();

    /**
     * Metoda, v ktorej prebieha vyroba keramiky
     * @param objednavka - objednavka na základe ktorej je keramika zhotovena
     * @param zamestnanci - zamestnanci, ktory ju vyrobia
     * @param sklad - sklad, odkial sa zoberu suroviny a kde bude ulozeny finalny produkt
     */
    public Keramika vyroba(Objednavka objednavka, ArrayList<Zamestnanec> zamestnanci, Sklad sklad){

        /**
         * kazdy zamestnanec spravi svoju cast roboty, vdaka polymorfizmu, je to mozne volat cez jednu metodu
         */
        for(Zamestnanec zam: zamestnanci){
            zam.vyrob(objednavka, sklad, this);
            pec.vypalit();

            /**
             * nahodne vyberie na kolko percent je upratana dielna po praci zamestnancov
             */
            Random rand = new Random();
            this.upratane = rand.nextInt(100);
        }

        /**
       Vrati hotovy produkt
         */
        Keramika keramika = sklad.zoberKeremiku();
        return keramika;
    }

    public int getUpratane() {
        return upratane;
    }
    public void setUpratane(int n){
        this.upratane = n;
    }

    public PecNaVypalovanie getPec() {
        return pec;
    }
}
