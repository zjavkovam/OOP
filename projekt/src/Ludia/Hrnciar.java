package Ludia;
import Keramika.Keramika;
import Nastroje.*;
import Priestory.*;
import Obchod.Objednavka;

public class Hrnciar extends Zamestnanec implements Uprac{
    int vyrobene;
    Hmota hlina;
    Hmota porcelan;
    HrnciarskyKruh kruh;


    public Hrnciar(String meno, int plat){
        super(meno,plat);
        this.hlina = new Hlina();
        this.porcelan = new Porcelan();
        this.kruh = new HrnciarskyKruh();
        this.vyrobene = 0;
    }

    /**
     * metoda, v ktorej je vyrobeny produkt na zaklade objednavky
     * @param objednavka - objednavka podla ktorej sa spravi produkt
     * @param sklad - sklad odkial sa zoberu materialy a kde bude hotovy produkt
     * @param dielna - dielna na ziskanie pece na vypalenie keramiky, maliar ju odtial berie
     */
    public void vyrob(Objednavka objednavka, Sklad sklad, Dielna dielna){
        PecNaVypalovanie pec = dielna.getPec();
        Keramika produkt;
        String hmota = objednavka.get_TypHmoty();
        String typ = objednavka.get_TypKeramiky();

        /**
         * implementacia default metody
         * Ak je dielna upratana na menej ako 50% nemozu tam pracovat a najskor
         * ju musia upratat
         */
        this.upratanieDielne(dielna);


        /**
         * ak uz pri sebe nema hrnciar ziadmu hmotu zoberie zo skladu dalsiu
         */
        if(typ=="porcelan" && porcelan.get_mnozstvo()<=0 || typ=="hlina" && hlina.get_mnozstvo()<=0 )
            zobratMaterial(sklad, hmota, typ);


        /**
         * podla typu hmoty je vyrobeny novy  produkt
         */
        if(hmota.equals("porcelan")){
            produkt = kruh.pouzi_kruh(this.porcelan, typ);
            produkt.setCena(porcelan.potrebne_mnozstvo(produkt)*porcelan.getCena());
        }
        else{
            produkt = kruh.pouzi_kruh(this.hlina, typ);
            produkt.setCena(hlina.potrebne_mnozstvo(produkt)*hlina.getCena());
        }

        /**
         * spraveny produkt je vlozeny do pece
         */
        this.vyrobene++;
        pec.vloz(produkt);
    }


    /**Zobratie zo skladu potrebneho materialu na zaklade potrebneho typu*/
    public void zobratMaterial(Sklad sklad, String hmota, String typ){
        int mnozstvo = 100;
        sklad.set_sklad(mnozstvo*-1,"hmota");

        if(hmota.equals("porcelan")){
            porcelan.set_mnozstvo(mnozstvo);
        }
        else{
            hlina.set_mnozstvo(mnozstvo);
        }
    }

    public void vypocitajPlat(){
        this.plat += vyrobene*20;
    }
}
