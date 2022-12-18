package Nastroje;
import Keramika.*;

public class Glazura extends Materialy{
    /**
     * kazda glazura ma svoju farbu a efekt
     * podla druhu keramiky sa mení mnozstvo potrebne na namalovanie
     */
    private String farba;
    private String efekt;

    public Glazura(String farba, String efekt){
        super(4, 240);
        this.farba = farba;
        this.efekt = efekt;
    }

    /**
     * @param produkt - produkt, ktory ma byt vyrobeny
     * zisti sa podla rtti o aky druh keramiky sa jedna a na zaklade toho
     * vrati mnozstvo, ktore je potrebne na jej vyrobu
     */
    public int potrebne_mnozstvo(Keramika produkt){
        int tanier = 20;
        int vaza = 30;
        int hrncek = 25;

        if(produkt instanceof Hrncek){
            mnozstvo=hrncek;
        }
        else if(produkt instanceof Vaza){
            this.mnozstvo -= vaza;
        }
        else {
            this.mnozstvo -= tanier;
        }

        return this.mnozstvo;
    }

    public int get_mnozstvo(){
        return this.mnozstvo;
    }
    public void set_mnozstvo(int nove){
        this.mnozstvo = nove;
    }
}
