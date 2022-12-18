package Obchod;

import Ludia.*;
import Priestory.*;
import Keramika.*;

import java.util.ArrayList;

/**
 * hlavna trieda aplikacnej logiky
 */
public class Obchod {
    private int prijem;
    private int vydavky;
    private  Dielna dielna;
    private  Sklad sklad;
    private  PersonalneOddelenie personalneOddelenie;
    private ArrayList<Zakaznik> zakaznici;
    private static Obchod instance = null;

    private Obchod(){
        prijem = 0;
        vydavky = 0;
        dielna = new Dielna();
        sklad = new Sklad();
        personalneOddelenie = new PersonalneOddelenie();
        zakaznici = new ArrayList<>();
        this.personalneOddelenie.najat_zamestnancov();
        sklad.pridajSledovatela(personalneOddelenie.getKurier());
    }

    public static Obchod getInstance(){
        if(instance==null){
            instance = new Obchod();
        }
        return instance;
    }

    /**
     * vytvorenie objednavky na zaklade udajov v parametri
     * @param meno - meno zakaznika
     * @param TypHmoty - typ hmoty z akej je keramika vyrobena
     * @param Farba - farba
     * @param TypKeramiky - hrncek/vaza/tanier
     * @param Glazura - leskla/matna
     */
    public Objednavka spravit_objednavku(String meno, String TypHmoty, String Farba, String TypKeramiky, String Glazura){
        Zakaznik zakaznik = new Zakaznik(meno, 1000);
        zakaznici.add(zakaznik);
        Objednavka objednavka = zakaznik.objednat(TypHmoty, Farba, TypKeramiky, Glazura);
        return objednavka;
    }

    /**
     * predanie keramiky na zaklade vypocitanej ceny
     * peniaze sa od zakaznika odpocitaju a pridaju sa do prijmu
     */
    public void predaj(Objednavka objednavka, Keramika keramika){
        int cena = keramika.getCena();
        for(Zakaznik z: zakaznici){
            if(z.get_meno().equals(objednavka.get_meno())){
                z.zaplatit(cena);
                this.prijem += cena;
            }
        }
    }

    /**
     * vyhodnotenie zisku a vydavkov
     */
    public String uzavierka(){
        this.vydavky = personalneOddelenie.vyplatenie_zamestnancov();
        int zarobok = this.prijem - this.vydavky;
        String s = ("UZAVIERKA:" +
                "\n Prijmy obchodu: "+this.prijem+
                "\n Vydavky obchodu na material a mzdy: "+this.vydavky+
                "\n Pocet zakaznikov: "+zakaznici.size()+"" +
                "\n Celkový prijem: "+(zarobok)+".\n");
        return s;
    }

    /**
     * pomocna funkcia na zistenie, ci uz zakaznik pred tym nieco kupoval
     */
    public boolean opakovanyZakaznik(String meno){
        int p=0;
        for(Zakaznik z:zakaznici){
            if(z.get_meno().equals(meno)){
                p++;
            }
        }
        if(p>=2){
            return true;
        }
        return false;
    }

    /**
     * vybavenie objednavky
     * najskor sa vytvori a potom sa profukt v dielni vyrobi
     * pripocita sa cena za dopravu a vypocita sa pripadna zlava
     * nasledne vypise udaje o objednavke
     */
    public String vybavit_objednavku(Obchod obchod, String TypHmoty, String Farba, String TypKeramiky, String Glazura, String Meno) {


        /**
         * kontrola cez podmienku, ci nahodou jeden zo vstupov nie je prazdny
         */
        Kontrola k = new Kontrola();
        try{
            k.skontroluj(TypHmoty,Farba,TypKeramiky,Glazura,Meno);
        }
        catch (MyExeption e){
            return "Zle vyplnena objednavka";
        }


        Objednavka objednavka = obchod.spravit_objednavku(Meno, TypHmoty, Farba, TypKeramiky, Glazura);
        Keramika tovar = obchod.dielna.vyroba(objednavka, obchod.personalneOddelenie.get_zamestnanci(), obchod.sklad);
        obchod.predaj(objednavka, tovar);

        /**
         * nastavi sa cena za dopravu
         */
        tovar.setCena(tovar.doprava());

        /**
         * uplatnenie zlavy, ak zakaznik nakupi viackrat a jeho tovar je nad 110
         */
        double zlava = 0;
        if(opakovanyZakaznik(objednavka.get_meno())){
            KeramikaVisitor visitor = new KeramikaVisitor();
            zlava = tovar.accept(visitor);
        }
        /**
         * vypisanie vsetkych udajov o  objednavke
         */
            String s = "Objednavka zakaznika " + objednavka.get_meno() + ": \n" +
                    "- keramika: " + objednavka.get_TypKeramiky() +
                    "\n- hmota: " + tovar.getTypHmoty() +
                    "\n- farba: " + tovar.getFarba() +
                    "\n- glazura: " + tovar.getGlazura() +
                    "\n cena: " + (tovar.getCena()-zlava) +
                    "\n cena za dopravu: "+tovar.doprava()+
                    "\n zlava uplatnena pre opakujucich zákaznikov na produkt s cenou nad 110 - "+zlava+".\n";

        return s;
    }

    public Sklad getSklad() {
        return sklad;
    }

    public PersonalneOddelenie getPersonalneOddelenie(){
        return personalneOddelenie;
    }

    public String vypisZamestnancov(){
        String s="";
        for(Zamestnanec z: this.personalneOddelenie.get_zamestnanci()){
            s= s + z.getMeno()+" \n";
        }
        return s;
    }

    public String vypisZakaznikov(){
        String s="";
        System.out.println("M");
        for(Zakaznik z: zakaznici){
            s= s + z.get_meno() +" \n";
        }
        return s;
    }

    public static void main(String[] args) {
        Obchod obchod = new Obchod();
        obchod.uzavierka();
    }
}
