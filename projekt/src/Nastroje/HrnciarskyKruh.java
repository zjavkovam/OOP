package Nastroje;
import Keramika.*;


/**
 * trieda sluziaca na spravenie konkretnej instancie triedy podla objednavky
 */
public class HrnciarskyKruh {

    public Keramika pouzi_kruh(Hmota hmota, String typ){
        Keramika produkt;

        /**
         * cez if sa zisti a aky produkt sa  jedna a vrati produkt
         * odcita sa mnozstvo potrebne na vyrobu a aktualizuje sa
         */
        if(typ.equals("hrncek")){
            produkt = new Hrncek(hmota.get_typ(),null,null);
        }
        else if(typ.equals("vaza")){
            produkt = new Vaza(hmota.get_typ(),null,null);
        }
        else{
            produkt = new Tanier(hmota.get_typ(),null,null);
        }

        int povodne = hmota.get_mnozstvo();
        int spotrebovane = hmota.potrebne_mnozstvo(produkt);
        hmota.set_mnozstvo(povodne-spotrebovane);
        return produkt;
    }
}
