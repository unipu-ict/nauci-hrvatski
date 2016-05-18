package hr.unipu.polyling;


public class Kategorija {

    int id;
    String naziv_en;
    String naziv_hr;

    public Kategorija(int id, String naziv_en, String naziv_hr) {
        this.id = id;
        this.naziv_en = naziv_en;
        this.naziv_hr = naziv_hr;
    }

    @Override
    public String toString() {
        //ovisno o postavljenom jeziku vratiti neki drugi?
        return naziv_hr;
    }
}
