package Ludia;

import Keramika.Keramika;
import Obchod.Objednavka;

/**
 * Trieda reprezentujuca zakaznika a metody ktore reprezentuju jeho moznosti pri objednavani tovaru
 */
public class Zakaznik {
    private String meno;
    private int peniaze;
    private Keramika MojaKeramika;

    public Zakaznik(String meno, int peniaze){
        this.meno = meno;
        this.peniaze = peniaze;
    }

    /**
     * Vytvorenie objednavky na zaklade parametrov a poziadaviek
     */
    public Objednavka objednat(String TypHmoty, String Farba, String TypKeramiky, String Glazura){
        Objednavka MojaObjednavka = new Objednavka(this.meno, TypHmoty,Farba,TypKeramiky,Glazura);
        return MojaObjednavka;
    }

    public String get_meno(){
        return this.meno;
    }

    /**
     * zaplatenie cenu vyhodnotenu za dany produkt
     */
    public void zaplatit(int cena){
        this.peniaze-= cena;
    }
}
