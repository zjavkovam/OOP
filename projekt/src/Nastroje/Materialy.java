package Nastroje;


/**
 * trieda zahrnajuca vsetky materialy
 */
public class Materialy {
    protected int cena;
    protected int mnozstvo;

    public Materialy(int cena, int teplota){
        this.mnozstvo = 0;
        this.cena = cena;
    }

    public int getCena() {
        return cena;
    }

    public int get_mnozstvo(){
        return this.mnozstvo;
    }

    public void set_mnozstvo(int nove){
        this.mnozstvo = nove;
    }

}
