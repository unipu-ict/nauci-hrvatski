package hr.unipu.polyling;



public class Fraza {
    int id;
    String naziv_hr;
    String naziv_en;
    int kategorija_id;

    public Fraza() {
    }

    public Fraza(int id, String naziv_hr, String naziv_en, int kategorija_id) {
        this.id = id;
        this.naziv_hr = naziv_hr;
        this.naziv_en = naziv_en;
        this.kategorija_id = kategorija_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv_hr() {
        return naziv_hr;
    }

    public void setNaziv_hr(String naziv_hr) {
        this.naziv_hr = naziv_hr;
    }

    public String getNaziv_en() {
        return naziv_en;
    }

    public void setNaziv_en(String naziv_en) {
        this.naziv_en = naziv_en;
    }

    public int getKategorija_id() {
        return kategorija_id;
    }

    public void setKategorija_id(int kategorija_id) {
        this.kategorija_id = kategorija_id;
    }

    @Override
    public String toString() {
        //ovisno o postavljenom jeziku vratiti neki drugi?
        return naziv_hr;
    }
}
