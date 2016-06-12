package hr.unipu.polyling.baza;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

public class PunjenjeBaze extends AsyncTask<Baza,Integer,Void>{

    private static Baza baza;
    public static Activity activity;
    private static final int DICTIONARY_SIZE = 315;
    private static int currentSize = 1;
    ProgressDialog progressDialog;

    public PunjenjeBaze(Activity activity) {
        PunjenjeBaze.activity = activity;
        progressDialog = new ProgressDialog(activity);
    }

    private void dodajKategorijuWrapper(String kategorijaEn, String kategorijaHr, String slika) {
        baza.dodajKategoriju(kategorijaEn, kategorijaHr, slika);
        publishProgress(currentSize++);
    }

    private void dodajFrazeWrapper(String frazaEn, String frazaHr, int kategorija) {
        baza.dodajFrazu(frazaEn, frazaHr, kategorija);
        publishProgress(currentSize++);
    }

    public void puniKategorije(Baza baza) {
        PunjenjeBaze.baza = baza;
        //prvo isprazniti tablicu ako postoje kategorije (korisno zbog refreshanja)
        baza.obrisiKategorije();

        dodajKategorijuWrapper("Basic", "Osnove", "phrases");
        dodajKategorijuWrapper("Time", "Vrijeme", "time");
        dodajKategorijuWrapper("Weather", "Vremenska prognoza", "weather");
        dodajKategorijuWrapper("Directions", "Upute", "directions");
        dodajKategorijuWrapper("Emergency", "SOS", "emergency");
        dodajKategorijuWrapper("Food", "Hrana", "food");
        dodajKategorijuWrapper("Love", "Ljubav", "love");
        dodajKategorijuWrapper("Money", "Novac", "money");
        dodajKategorijuWrapper("Conversations", "Razgovori", "people");
        dodajKategorijuWrapper("Shopping", "Kupovina", "shopping");
    }

    public void puniFraze(Baza baza) {
        PunjenjeBaze.baza = baza;
        baza.obrisiFraze();

        dodajFrazeWrapper("What do you do?", "S čime se bavite?", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("What do you do for a living?", "Što radite?", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("What sort of work do you do?", "Kojom vrstom posla se bavite?", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("What line of work are you in?", "Kojom linijom posla se bavite?", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("I'm a …", "Ja sam …", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("Teacher", "Učitelj/učiteljica", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("Student", "Student/studentica", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("Doctor", "Doktor/doktorica", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("I work as a …", "Radim kao …", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("Journalist", "Novinar/novinarka", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("Programmer", "Programer/programerka", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("I work in …", "Radim u …", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("Television", "Televizijskoj kući", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("Publishing", "Izdavaštvu", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("PR (public relations)", "Odnosima s javnošću", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("Sales", "Prodaji", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("IT", "Telekomunikacijama", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("I work with …", "Radim sa …", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("Computers", "Kompjuterima", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("Children with disabilities", "Djecom sa teškoćama", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("I stay at home and look after the children", "Ostajem kući i brinem se o djeci", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("I'm a housewife", "Kućanica sam", baza.getKategorijaIdByNaziv("Business"));
        dodajFrazeWrapper("What's the time?", "Koliko je sati?", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("What time is it?", "Koliko je sati?", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Could you tell me the time, please?", "Možete li mi reći koliko je sati, molim vas?", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Do you happen to have the time?", "Znate li koliko je sati?", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Do you know what time it is?", "Znaš li koliko je sati?", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("It's …", "Sad je …", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Exactly ...", "Točno …", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("About ...", "Otprilike …", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Almost ...", "Skoro …", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Just gone ...", "Upravo je prošlo …", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("One o'clock", "Jedan sat", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Two o'clock", "Dva sata", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Three o'clock", "Tri sata", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Four o'clock", "Četiri sata", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Five o'clock", "Pet sati", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Six o'clock", "Šest sati", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Seven o'clock", "Sedam sati", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Eight o'clock", "Osam sati", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Nine o'clock", "Devet sati", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Ten o'clock", "Deset sati", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Eleven o'clock", "Jedanaest sati", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Twelve o'clock", "Dvanaest sati", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Quarter past …", "Kvarat poslije …", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("One", "Jedan", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Two", "Dva", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Three", "Tri", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Half past …", "Pola sata nakon …", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Half past one", "Jedan i pol", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Half past two", "Dva i pol", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Half past three", "Tri i pol", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Five past one", "Jedan i pet", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Ten past one", "Jedan i deset", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Twenty past one", "Jedan i dvadeset", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Twenty-five past one", "Jedan i dvadeset-pet", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Five to two", "Pet do dva", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Ten to two", "Deset do dva", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Twenty to two", "Dvadeset do dva", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Twenty-five to two", "Dvadeset-pet do dva", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Ten fifteen", "Deset i petnaest", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Ten thirty", "Deset i pol", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Ten forty-five", "Deset i četrdeset-pet", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Ten am", "Deset ujutro", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Six pm", "Šest sati", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Ten am", "Deset ujutro", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Six pm", "Šest sati", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Noon ili midday", "Podne ili dvanaest sati", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Midnight", "Ponoć", baza.getKategorijaIdByNaziv("Time"));
        dodajFrazeWrapper("Do you take credit cards?", "Primate li kreditne kartice?", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("I'll pay in cash", "Platit ću gotovinom", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("I'll pay by card", "Platit ću karticom", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("Could I have a receipt, please?", "Mogu li dobiti račun, molim?", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("I'd like to return this", "Želim vratiti ovo", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("I'd like to change this for a different size", "Želim zamijeniti ovo za drugu veličinu", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("Could I have a refund?", "Mogu li dobiti povrat novca?", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("Have you got the receipt?", "Imate li račun?", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("Enter your PIN", "Unesite vaš PIN", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("Please wait", "Molimo pričekajte", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("Remove card", "Izvadite karticu", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("Signature", "Potpis", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("What's the expiry date?", "Koji je datum isteka valjanosti?", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("What's the start date?", "Koji je početan datum?", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("What's the security number on the back?", "Koji je broj za sigurnosnu provjeru sa stražnje strane?", baza.getKategorijaIdByNaziv("Money"));
        dodajFrazeWrapper("Here", "Ovdje", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("There", "Tamo", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Everywhere", "Svugdje", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Nowhere", "Nigdje", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Somewhere", "Negdje", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Excuse me, could you tell me how to get to …?", "Oprostite, da li mi možete reći kako doći do …?", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("The bus station", "Autobusne stanice", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Excuse me, do you know where the … is?", "Oprostite, da li znate gdje se … nalazi?", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Post office", "Pošta", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("I'm sorry, I don't know", "Žao mi je, ne znam", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Sorry, I'm not from around here", "Žao mi je, nisam odavde", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("I'm sorry, I don't know", "Žao mi je, ne znam", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Sorry, I'm not from around here", "Žao mi je, nisam odavde", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("I'm looking for …", "Tražim …", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("This address", "Ovu adresu", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Are we on the right road for …?", "Jesmo li na ispravnoj cesti prema …?", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Is this the right way for …?", "Da li je ovo ispravan put prema …?", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Do you have a map?", "Imaš li mapu?", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Can you show me on the map?", "Možeš mi pokazati na mapi?", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("How far is it?", "Koliko je udaljeno?", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("How far is it to …?", "Koliko je daleko do …?", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("The airport", "Aerodroma", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("How far is it to … from here?", "Koliko daleko je … odavde?", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("The beach", "Plaža", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Is it far?", "Da li je daleko?", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Is it a long way?", "Da li je dugačak put?", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("It's …", "To …", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Not far", "Nije daleko", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Quite close", "Je prilično blizu", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Quite a long way", "Je prilično daleko", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("A long way on foot", "Je prilično daleko pješice", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("A long way to walk", "Je dugačak put za hodanje", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("About a mile from here", "Je otprilike milju odavde", baza.getKategorijaIdByNaziv("Directions"));
        dodajFrazeWrapper("Do you have any snacks?", "Imate li kakve grickalice?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Do you have any sandwiches?", "Imate li kakve sendviče?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Do you serve food?", "Poslužujete li hranu?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("What time does the kitchen close?", "Kada se kuhinja zatvara?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Are you still serving food?", "Poslužujete li još uvijek hranu?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("A packet of crisps, please", "Paket čipsa, molim", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("What flavour would you like?", "Koji okus želite?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Ready salted", "Slani", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Cheese and onion", "Sir i luk", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Salt and vinegar", "Sir i ocat", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("What sort of sandwiches do you have?", "Kakve sendviče imate?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Do you have any hot food?", "Imate li kakve tople obroke?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Today's specials are on the board", "Današnji specijaliteti su na ploči", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("What sort of sandwiches do you have?", "Kakve sendviče imate?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Do you have any hot food?", "Imate li kakve tople obroke?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Today's specials are on the board", "Današnji specijaliteti su na ploči", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Is it table service or self-service?", "Poslužuje li se za stolom ili je riječ o samoposluzi?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("What can I get you?", "Što vam mogu donijeti?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Would you like anything to eat?", "Želite li pojesti nešto?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Could we see a menu, please?", "Možemo li vidjeti cjenik, molim?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Eat in or take-away?", "Za ovdje ili za van?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("I'd like …", "Želim …", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("That piece of cheese", "Taj komad sira", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("A slice of pizza", "Krišku pizze", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Six slices of ham", "Šest kriški šunke", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Some olives", "Malo maslina", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("How much would you like?", "Koliko biste željeli?", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Half a kilo", "Pola kile", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Two pounds", "Dvije funte ", baza.getKategorijaIdByNaziv("Food"));
        dodajFrazeWrapper("Of course", "Naravno", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Of course not", "Naravno da ne", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("That's fine", "U redu je", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("That's right", "Tako je", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Sure", "Naravno", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Certainly", "Svakako", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Definitely", "Definitivno", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Absolutely", "Apsolutno", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("As soon as possible", "Čim prije moguće", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("That's enough", "To je dovoljno", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("It doesn't matter", "Nema veze", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("It's not important", "Nije važno", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("It's not serious", "Nije ozbiljno", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("It's not worth it", "Nije vrijedno toga", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("I'm in a hurry", "U žurbi sam", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("I've got to go", "Moram ići", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("I'm going out", "Idem van", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Sleep well", "Lijepo spavaj", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Same to you!", "Također", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Me too", "I ja", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Not bad", "Nije loše", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("I like …", "Sviđa mi se …", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Him", "On", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Her", "Ona", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("It", "Ono", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("I don't like …", "Ne sviđa mi se …", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Him", "On", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Her", "Ona", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("It", "Ono", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Look!", "Gle!", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Great!", "Odlično!", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Come on!", "Hajde!", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Only joking! ili just kidding!", "Šalim se! ili samo se šalim!", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Bless you!", "Nazdravlje! (nakon što netko kihne)", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("That's funny!", "To je smiješno!", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("That's life!", "To je život!", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("Damn it!", "K vragu!", baza.getKategorijaIdByNaziv("Basic"));
        dodajFrazeWrapper("What's your name?", "Kako se zoveš?", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("My name's …", "Zovem se …", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("This is …", "Ovo je …", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("My wife", "Moja žena", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("My husband", "Moj muž", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("My boyfriend", "Moj dečko", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("My girlfriend", "Moja djevojka", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("My son", "Moj sin", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("My daughter", "Moja kćer", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("Do you know each other?", "Poznajete li se?", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("Nice to meet you", "Drago mi je upoznati vas", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("Pleased to meet you", "Zadovoljstvo mi je upoznati vas", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("How do you know each other?", "Kako se poznajete?", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("We work together", "Radimo zajedno", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("We used to work together", "Nekad smo radili zajedno", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("We were at school together", "Išli smo zajedno u školu", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("We're at university together", "Studiramo zajedno", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("We went to university together", "Studirali smo zajedno", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("Through friends", "Preko prijatelja", baza.getKategorijaIdByNaziv("Conversations"));
        dodajFrazeWrapper("Call an ambulance!", "Zovite hitnu pomoć!", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("I need a doctor", "Trebam doktora", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("There's been an accident", "Dogodila se nesreća", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("Please hurry!", "Molim, požurite!", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("I've cut myself", "Porezao/porezala sam se!", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("I've burnt myself", "Opekao/opekla sam se!", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("Are you OK?", "Da li si dobro?", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("Is everyone OK?", "Da li su svi dobro?", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("I'd like to report a theft", "Želim prijaviti krađu", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("My car's been broken into", "Netko je provalio u moj auto", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("Fire!", "Požar!", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("Call the fire brigade!", "Zovite vatrogasce!", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("Can you smell burning?", "Osjetite li dim?", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("There's a fire", "Tamo je požar", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("The building's on fire", "Zgrada gori", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("Stop, thief!", "Stani, lopov!", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("Call the police!", "Zovite policiju!", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("My wallet's been stolen", "Moj novčanik je ukraden", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("My purse has been stolen", "Moja torbica je ukradena", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("My handbag's been stolen", "Moja torba je ukradena", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("My laptop's been stolen", "Moj laptop je ukraden", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("My phone's been stolen", "Moj mobitel je ukraden", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("I've been mugged", "Opljačkan/opljačkana sam", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("I've been attacked", "Napadnut/napadnuta sam", baza.getKategorijaIdByNaziv("Emergency"));
        dodajFrazeWrapper("What's the weather like?", "Kakvo je vrijeme?", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("It's …", "Vrijeme je …", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("Sunny", "Sunčano", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("Cloudy", "Oblačno", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("Windy", "Vjetrovito", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("Foggy", "Maglovito", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("Stormy", "Olujno", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("It's …", "Vrijeme je …", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("Raining", "Kišovito", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("Hailing", "Tuča", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("Snowing", "Snježno", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("What a nice day!", "Kakav predivan dan!", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("What a beautiful day!", "Kakav prekrasan dan!", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("It's not a very nice day", "Nije jako lijep dan", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("What a terrible day!", "Kakav užasan dan!", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("What miserable weather!", "Kakvo loše vrijeme", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("It's starting to rain", "Počinje padati kiša", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("It's stopped raining", "Prestala je kiša", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("It's pouring with rain", "Kiša pljušti", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("It's raining cats and dogs", "Lijeva kao iz kabla", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("The weather's fine", "Vrijeme je u redu", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("The sun's shining", "Sunce sja", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("There's not a cloud in the sky", "Nema nijednog oblaka na nebu", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("The sky's overcast", "Nebo je prekriveno", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("It's clearing up", "Čisti se", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("The sun's come out", "Sunce je izašlo", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("The sun's just gone in", "Sunce je upravo zašlo", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("There's a strong wind", "Vjetar je snažan", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("The wind's dropped", "Vjetar je oslabio", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("That sounds like thunder", "To zvuči kao grmljavina", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("That's lightning", "Sijeva", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("We had a lot of heavy rain this morning", "Jutros je jako padala kiša", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("We haven't had any rain for a fortnight", "Kiša nije padala dva tjedna", baza.getKategorijaIdByNaziv("Weather"));
        dodajFrazeWrapper("Could I try this on?", "Mogu li isprobati ovo?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Could I try these on?", "Mogu li probati ove?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Could I try these shoes on?", "Mogu li probati ove cipele?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Do you want to try it on?", "Želite li probati to?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Do you want to try them on?", "Želite li ih probati?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("What size are you?", "Koja ste veličina?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("What size do you take?", "Koju veličinu uzimate?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Do you have this in a size …?", "Imate li ovo u veličini …?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Do you have these in a size …?", "Imate li ove u veličini …?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Do you have a fitting room?", "Imate li garderobu?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Where's the fitting room?", "Gdje je garderoba?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Have you got this in a smaller size?", "Imate li ovo u manjoj veličini?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Have you got this in a larger size?", "Imate li ovo u većoj veličini?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Could you measure my …?", "Možete li izmjeriti moj/moja …?", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Waist", "Struk", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Neck", "Vrat", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Chest", "Prsa", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("It's much too small", "Prilično je malo", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("It's a little too small", "Premalo je", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("It's a little too big", "Preveliko je", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("It's just right", "Taman je", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("They're just right", "Taman su", baza.getKategorijaIdByNaziv("Shopping"));
        dodajFrazeWrapper("Can I buy you a drink?", "Mogu li te počastiti pićem?", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("Would you like a drink?", "Želiš li piće?", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("Can I get you a drink?", "Mogu li ti donijeti piće?", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("Are you on your own?", "Jesi li sam/sama?", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("Would you like to join us?", "Želiš nam se pridružiti?", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("Do you mind if I join you?", "Da li smeta ako vam se pridružim?", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("Do you mind if we join you?", "Da li smeta ako vam se mi pridružimo?", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("Do you come here often?", "Dolaziš li ovdje često?", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("Is this your first time here?", "Je li ovo prvi put da si ovdje?", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("Have you been here before?", "Jesi li već bio/bila ovdje prije?", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("Would you like to dance?", "Želiš li plesati?", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("You look great", "Izgledaš odlično", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("You look very nice tonight", "Izgledaš jako lijepo večeras", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("I like your outfit", "Sviđa mi se tvoje odijelo", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("You're beautiful", "Prekrasna si (govori se ženi)", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("You're really good-looking", "Jako dobro izgledaš", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("You're really sexy", "Jako si seksi", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("You've got beautiful eyes", "Imaš prekrasne oči", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("You've got a great smile", "Imaš predivan osmijeh", baza.getKategorijaIdByNaziv("Love"));
        dodajFrazeWrapper("Thanks for the compliment!", "Hvala na komplimentu", baza.getKategorijaIdByNaziv("Love"));

    }

    @Override
    protected void onPreExecute() {
        progressDialog.setTitle("Database Refresh");
        progressDialog.setMessage("Updating database...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(DICTIONARY_SIZE);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Baza[] params) {
        Baza baza = params[0];

        puniKategorije(baza);
        puniFraze(baza);

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressDialog.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressDialog.dismiss();
        currentSize = 0;
        activity.recreate();
    }
}
