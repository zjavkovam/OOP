package Obchod;
import Keramika.*;

public class KeramikaVisitor implements ObjednavkaVisitor {
    public double visit(Keramika keramika) {
        int cena = keramika.getCena();
        double zlava = 0;

        if (cena > 110) {
            zlava = ((double) cena / 100) * 10;
        }
        return zlava;
    }
}
