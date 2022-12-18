package Ludia;

import Priestory.Sklad;
import Priestory.SkladObserver;

public class Kurier extends Zamestnanec implements SkladObserver {
    int dovezene=0;

    public Kurier(String meno, int plat){
        super(meno,plat);
    }

    /**
     * Ked je kureier upovedomeny na to, ze uz nie su v sklade zasoby
     * dovezie do skladu dalsich 1000
     */
    @Override
    public void upovedom(Sklad sklad) {
        if(sklad.get_sklad("hmota")<=0){
            sklad.set_sklad(1000,"hmota");
            dovezene++;
        }

        if(sklad.get_sklad("glazura")<=0){
            dovezene++;
            sklad.set_sklad(1000, "glazura");
        }
    }

    public void vypocitajPlat(){
        this.plat += dovezene*10;
    }
}
