package hr.unipu.polyling.baza;

public class PunjenjeBaze {


    public static void puniKategorije(Baza baza) {

        //prvo isprazniti tablicu ako postoje kategorije (korisno zbog refreshanja)
        baza.obrisiKategorije();

        baza.dodajKategoriju("Drinks", "Pića", "mis");
        baza.dodajKategoriju("Animals", "Životinje", "mis");
        baza.dodajKategoriju("Food", "Hrana", "mis");
        baza.dodajKategoriju("Cars", "Automobili", "mis");
        baza.dodajKategoriju("Money", "Novac", "mis");
        baza.dodajKategoriju("Household", "Domaćinstvo", "mis");
    }

    public static void puniFraze(Baza baza) {
        //TODO: implementirati po uzoru na puniKategorije
    }
}
