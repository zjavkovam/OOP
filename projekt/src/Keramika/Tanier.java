package Keramika;

public class Tanier extends Keramika{
    public Tanier(String hmota, String farba, String glazura){
        super(hmota, farba, glazura);
    }

    /**
     * polymorfná metoóda na vypočítanie ceny za dopravu
     */
    @Override
    public int doprava() {
        int vyska = 5;
        int sirka = 25;
        int hmotnost = 1;

        return vyska*sirka*hmotnost/10;
    }
}
