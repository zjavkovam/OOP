# oop-2021-uto-16-b-lang-zjavkovam
oop-2021-uto-16-b-lang-zjavkovam created by GitHub Classroom

Monika Zjavková

V programe je hlavná trieda Aplikácia. Program zatiaľ na začiatku vždy vytvorí zamestnancov v konštruktory triedy Obchod. Pomocou okna vytvorí obejdnávku a
následne v triede Dielna je vytvorená keramika podľa objednávky, pri čom sa zo skladu odoberie potrebné množstvo na výrobu a pomocou tlačidla je možné hocikedy vypísať stav skladu. Tiež je v obchode metóda, ktorá vypočíta zisk, zatiaľ len na základe konštánt, a uvádza počet zákazníkov. 

Plnenie kritérii:

DEDENIE
Hierarchia dedenia je uplatnená v projekte pri triedach Zamestnanec a z nej dedia Hrnciar, Maliar a Hrnciar 

public class Hrnciar extends Zamestnanec{
    Hmota mojaHmota;
    public Hrnciar(String meno, int plat){
        super(meno,plat);
   }

AGREGÁCIA
Trieda Obchod má zoznam so všetkými vytvorenými zákazníkmi
private  PersonalneOddelenie personalneOddelenie;
private ArrayList<Zakaznik> zakaznici;


Polymorfizmus
Triedy Maliar aj Hrnciar majú vlastné implementácie metód vyrob a zobratMaterial, pri čom sú obe volané v triede Dielna 
for(Zamestnanec zam: zamestnanci){
  zam.vyrob(objednavka, sklad, pec);
  pec.vypalit();
}

Oddelenie aplikačnej logiky od rozhrania 
Vytváranie scény, všetkých potrebných buttonov a textových polí prebieha v triede AplikaciaView a AplikáciaController spracováva samotné stlačenie tlačidla
a zavolá metódu podľa daného tlačidla.


