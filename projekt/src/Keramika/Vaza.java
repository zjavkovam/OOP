package Keramika;

public class Vaza extends Keramika{
    public Vaza(String hmota, String farba, String glazura){
      super(hmota, farba, glazura);
    }

    /**
     * polymorfná metoóda na vypočítanie ceny za dopravu
     */
    @Override
    public int doprava() {
        int vyska = 30;
        int sirka = 10;
        int hmotnost = 2;

        return vyska*sirka*hmotnost/10;
    }
}
