package Obchod;

import Ludia.*;

import java.util.ArrayList;

public class PersonalneOddelenie {
    private ArrayList<Zamestnanec> zamestnanci = new ArrayList<Zamestnanec>();

    /**
    Vytvorenie zamestnancov, ktory su pridani do zoznamu so vsetkymi zamestnancami
     */
    public void najat_zamestnancov(){
        Hrnciar hrnciar = new Hrnciar("hrnciar", 100);
        zamestnanci.add(hrnciar);

        Maliar maliar = new Maliar("maliar", 100);
        zamestnanci.add(maliar);

        Kurier kurier = new Kurier("kurier",100);
        zamestnanci.add(kurier);
    }


    /**
     * vypocitanie platov pre zamestnancov na  zaklade ich odrobenej prace
     * vsetky platy sa scitaju a vrati celkovu sumu vynalozenu na platy
     */
    public  int vyplatenie_zamestnancov(){
        int platy=0;
        zamestnanci.forEach(n->n.vypocitajPlat());

        for(Zamestnanec z: zamestnanci){
            platy += z.get_plat();
        }
        return platy;
    }

    public Kurier getKurier() {
        for (Zamestnanec zam : zamestnanci) {
            if (zam instanceof Kurier) {
                return (Kurier) zam;
            }
        }
        return null;
    }

    public ArrayList<Zamestnanec> get_zamestnanci(){
        return this.zamestnanci;
    }
}
