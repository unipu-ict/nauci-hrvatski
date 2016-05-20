package hr.unipu.polyling;


public class Kategorija {

    int id;
    String naziv_en;
    String naziv_hr;
    String slika;


    public Kategorija() {
    }


    public Kategorija(int id, String naziv_en, String naziv_hr, String slika) {
        this.id = id;
        this.naziv_en = naziv_en;
        this.naziv_hr = naziv_hr;
        this.slika = slika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv_en() {
        return naziv_en;
    }

    public void setNaziv_en(String naziv_en) {
        this.naziv_en = naziv_en;
    }

    public String getNaziv_hr() {
        return naziv_hr;
    }

    public void setNaziv_hr(String naziv_hr) {
        this.naziv_hr = naziv_hr;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    @Override
    public String toString() {
        //ovisno o postavljenom jeziku vratiti neki drugi?
        return naziv_hr;
    }
}
