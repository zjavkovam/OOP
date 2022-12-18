package Nastroje;
import Keramika.*;


public class Hmota extends Materialy{
    private String typ;

    public Hmota(String typ,int cena, int teplota){
        super(cena,teplota);
        this.typ = typ;
    }


    /**
     * @param produkt - produkt, ktory ma byt vyrobeny
     * zisti sa podla rtti o aky druh keramiky sa jedna a na zaklade toho
     * vrati mnozstvo, ktore je potrebne na jej vyrobu
     */
    public int potrebne_mnozstvo(Keramika produkt){
        int tanier = 40;
        int vaza = 50;
        int hrncek = 45;

        if(produkt instanceof Hrncek){
            this.mnozstvo=hrncek;
        }
        else if(produkt instanceof Vaza){
            this.mnozstvo = vaza;
        }
        else {
            this.mnozstvo = tanier;
        }

        return this.mnozstvo;
    }

    public String get_typ(){
        return this.typ;
    }
}


