package hr.unipu.polyling.baza;

public class PunjenjeBaze {


    public static void puniKategorije(Baza baza) {

        //prvo isprazniti tablicu ako postoje kategorije (korisno zbog refreshanja)
        baza.obrisiKategorije();

        baza.dodajKategoriju("Basic", "Osnove", "phrases");
        baza.dodajKategoriju("Time", "Vrijeme", "time");
        baza.dodajKategoriju("Weather", "Prognoza", "weather");
        baza.dodajKategoriju("Directions", "Upute", "directions");
        baza.dodajKategoriju("Emergency", "SOS", "emergency");
        baza.dodajKategoriju("Food", "Hrana", "food");
        baza.dodajKategoriju("Love", "Ljubav", "love");
        baza.dodajKategoriju("Money", "Novac", "money");
        baza.dodajKategoriju("Conversations", "Razgovori", "people");
        baza.dodajKategoriju("Shopping", "Kupovina", "shopping");

    }

    public static void puniFraze(Baza baza) {
        //TODO: implementirati po uzoru na puniKategorije
    }
}
