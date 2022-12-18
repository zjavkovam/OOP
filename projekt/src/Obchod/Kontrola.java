package Obchod;


/**
 * trieda na kontrolu vstpu a vyhodenie vlastnej výnimky
 */
public class Kontrola{

    void skontroluj(String TypHmoty, String Farba, String TypKeramiky,
                    String Glazura, String Meno) throws MyExeption{

        if(TypHmoty.equals("") || Farba.equals("") || TypKeramiky.equals("") || Glazura.equals("") || Meno.equals("")){
            throw new MyExeption("nesprávny vstup");
        }
    }

}
