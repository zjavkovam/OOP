package Nastroje;

import Keramika.Keramika;
import java.util.ArrayList;


/**
 * trieda, kde prebieha vyplaovanie keramiky - zaradenie do prislusneho zoznamu
 * podla toho, v akom kroku vyroby sa produkt nachadza
 */
public class PecNaVypalovanie {
    ArrayList <Keramika> v_peci = new ArrayList<Keramika>();
    ArrayList <Keramika> nenamalovane = new ArrayList<Keramika>();

    /**
     * vlozenie do pece - robi hrnciar
     */
    public void vloz(Keramika produkt){
        this.v_peci.add(produkt);
    }

    /**
     * produkt sa presunie zo zoznamu na vypalenie do zoznamu pre nenamalovane
     * odkial zoberie keramiku hrnciar
     */
    public void vypalit(){
        for(Keramika k: this.v_peci){
            this.v_peci.remove(k);
            this.nenamalovane.add(k);
            if(this.v_peci.size()==0){
                return;
            }
        }
    }


    /**
     * vybratie poslednej keramiky vlozenej do pece
     */
    public Keramika vyber(){
        return this.nenamalovane.get(nenamalovane.size()-1);
    }
}
