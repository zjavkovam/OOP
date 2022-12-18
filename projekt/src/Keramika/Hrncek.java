package Keramika;

public class Hrncek extends Keramika{
    public Hrncek(String hmota, String farba, String glazura){
        super(hmota, farba, glazura);
    }

    /**
     * polymorfná metoóda na vypočítanie ceny za dopravu
     */
    @Override
    public int doprava() {
        int vyska = 10;
        int sirka = 15;
        int hmotnost = 1;

        return vyska*sirka*hmotnost/10;
    }
}
