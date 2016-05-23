package hr.unipu.polyling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class KategorijeActivity extends AppCompatActivity {

    Baza baza;
    private List<Kategorija> kategorije;// = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorije);

        //instanciranje baze
        baza = new Baza(this);

        kategorije = baza.sveKategorije();
        if(kategorije.size()==0) {
            //test podaci
//            kategorije.add(new Kategorija(0, "Test", "Proba", "mis"));
//            kategorije.add(new Kategorija(1, "Animals", "Proba", "mis"));
//            kategorije.add(new Kategorija(2, "Food", "Proba", "mis"));
//            kategorije.add(new Kategorija(3, "Cars", "Proba", "mis"));
//            kategorije.add(new Kategorija(3, "Money", "Proba", "mis"));
//            kategorije.add(new Kategorija(3, "Political Activism", "Proba", "mis"));
//            kategorije.add(new Kategorija(3, "Otorinolaringology", "Proba", "mis"));
//            kategorije.add(new Kategorija(3, "United States of America", "Proba", "mis"));
//            kategorije.add(new Kategorija(3, "A very long name of a category baby", "Proba", "mis"));
//TODO: odvojiti podatke nakon testiranja
            baza.dodajKategoriju("Drinks", "Proba", "mis");
            baza.dodajKategoriju("Animals", "Proba", "mis");
            baza.dodajKategoriju("Food", "Proba", "mis");
            baza.dodajKategoriju("Cars", "Proba", "mis");
            baza.dodajKategoriju("Money", "Proba", "mis");
            baza.dodajKategoriju("United States of America", "Proba", "mis");

            kategorije = baza.sveKategorije();

        }
        GridView grid = (GridView) findViewById(R.id.kategorijeGrid);
        assert grid != null;
        //postavljanje custom adaptera za grid view
        grid.setAdapter(new KategorijaArrayAdapter(this, 0, kategorije));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(KategorijeActivity.this, FrazeListActivity.class);
                //pronalazi koja je kategorija dodirnuta i pokreće novu aktivnost koja prikazuje fraze te kategorije
                int kategorijaID = kategorije.get(position).getId();
                intent.putExtra("kategorijaID", kategorijaID);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        baza.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        baza.close();
    }
}
