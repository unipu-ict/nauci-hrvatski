package hr.unipu.polyling.baza;

public class PunjenjeBaze {


    public static void puniKategorije(Baza baza) {

        //prvo isprazniti tablicu ako postoje kategorije (korisno zbog refreshanja)
        baza.obrisiKategorije();

        baza.dodajKategoriju("Drinks", "Proba", "mis");
        baza.dodajKategoriju("Animals", "Proba", "mis");
        baza.dodajKategoriju("Food", "Proba", "mis");
        baza.dodajKategoriju("Cars", "Proba", "mis");
        baza.dodajKategoriju("Money", "Proba", "mis");
        baza.dodajKategoriju("United States of America", "Proba", "mis");
    }
}
