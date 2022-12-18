package Keramika;

import Obchod.ObjednavkaVisitor;
import Obchod.Visitable;

/**
 * trieda reprezentujuca produkt, blizsie je specifikovana jej podtriedami podla typu keramiky
 */
public class Keramika implements Visitable {
    private String TypHmoty;
    private String Farba;
    private String Glazura;
    private int cena=0;

    public Keramika(String hmota, String farba, String glazura){
        this.TypHmoty = hmota;
        this.Farba = farba;
        this.Glazura = glazura;
    }

    /**
     * metoda na prijatie visitora
     */
    public double accept(ObjednavkaVisitor visitor){
        double zlava = visitor.visit(this);
        return zlava;
    }

    public void set_glatura(String farba, String glazura){
        this.Farba = farba;
        this.Glazura = glazura;
    }

    /**
     * metoda na vypocitanie dopravy
     */
    public int doprava(){
        return 0;
    };

    public String getFarba() {
        return Farba;
    }

    public String getGlazura() {
        return Glazura;
    }

    public String getTypHmoty() {
        return TypHmoty;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena){
        this.cena+=cena;
    }
}
