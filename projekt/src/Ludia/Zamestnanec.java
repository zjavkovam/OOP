package Ludia;
import Priestory.*;
import Obchod.Objednavka;

/**
 * abstraktna trieda, ktora definuje zamestnanca - jeho hlavne atributy ako su meno a plat
 */

public abstract class Zamestnanec {
    private String Meno;
    int plat;

    public Zamestnanec(String meno, int plat){
        this.Meno = meno;
        this.plat = plat;
    }

    public int get_plat(){
        return this.plat;
    }
    public String getMeno(){
        return this.Meno;
    }


    /**
     * metody ktore su prekonane v potomkoch na zaklade prace, ktoru budu vykonavat
     * @param objednavka - objednavka podla ktorej sa spravi produkt
     * @param sklad - sklad odkial sa zoberu materialy a kde bude hotovy produkt
     * @param dielna - dielna na ziskanie pece na vypalenie keramiky, maliar ju odtial berie
     */
    public void vyrob(Objednavka objednavka, Sklad sklad, Dielna dielna){ }

    public void zobratMaterial(Sklad sklad, String farba, String typ){}

    public void vypocitajPlat(){}
}
