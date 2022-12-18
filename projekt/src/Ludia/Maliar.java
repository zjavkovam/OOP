package Ludia;
import Nastroje.*;
import Keramika.*;
import Priestory.*;
import Obchod.Objednavka;
import Priestory.Uprac;

public class Maliar extends Zamestnanec implements Uprac {
    Glazura mojaGlazura;
    int vyrobene = 0;

    public Maliar(String meno, int plat){
        super(meno,plat);
    }


    public void vyrob(Objednavka objednavka, Sklad sklad, Dielna dielna){
        PecNaVypalovanie pec = dielna.getPec();
        String farba = objednavka.get_Farba();
        String glazura = objednavka.get_Glazura();
        Keramika produkt = pec.vyber();
        zobratMaterial(sklad, farba, glazura);


        /**
         * implementacia default metody
         * Ak je dielna upratana na menej ako 50% nemozu tam pracovat a najskor
         * ju musia upratat
         */
        this.upratanieDielne(dielna);

        /**
         * zobratie potrebneho materualu zo .
         */

        int povodne = this.mojaGlazura.get_mnozstvo();
        int spotrebovane = this.mojaGlazura.potrebne_mnozstvo(produkt);
        this.mojaGlazura.set_mnozstvo(povodne-spotrebovane);

        /**
         * pripocita sa k poctu uz spracovanych produktov a odlozi keramiku
         * do skladu
         */
        this.vyrobene++;
        produkt.set_glatura(farba,glazura);
        sklad.hotove(produkt);
    }

    /**
     *zobratie danej glazury  zo skladu
     */
    public void zobratMaterial(Sklad sklad, String farba, String efekt){
        int mnozstvo = 30;
        this.mojaGlazura = new Glazura(farba, efekt);
        this.mojaGlazura.set_mnozstvo(mnozstvo);
        sklad.set_sklad(mnozstvo*-1,"glazura");
    }

    public void vypocitajPlat(){
        this.plat += vyrobene*20;
    }
}
