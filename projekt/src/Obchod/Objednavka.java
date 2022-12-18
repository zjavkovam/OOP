package Obchod;

/**
 * trieda, ktora zaznamenava objednavku
 * kazda ma informacie o tom, aky ma byt vysledny produkt a meno zakaznika
 */
public class Objednavka {
    private String MenoZakaznika;
    private String TypHmoty;
    private String Farba;
    private String TypKeramiky;
    private String Glazura;

    public Objednavka(String meno, String typhmoty, String farba, String typkeramiky, String glazura){
        this.MenoZakaznika = meno;
        this.TypHmoty = typhmoty;
        this.Farba = farba;
        this.TypKeramiky = typkeramiky;
        this.Glazura = glazura;
    }

    public String get_TypHmoty(){
        return this.TypHmoty;
    }

    public String get_Farba(){
        return this.Farba;
    }

    public String get_TypKeramiky(){
        return this.TypKeramiky;
    }

    public String get_Glazura(){
        return this.Glazura;
    }

    public String get_meno(){
        return this.MenoZakaznika;
    }
}
