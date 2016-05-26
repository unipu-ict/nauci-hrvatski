package hr.unipu.polyling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import hr.unipu.polyling.baza.Baza;
import hr.unipu.polyling.baza.PunjenjeBaze;
import hr.unipu.polyling.util.Kategorija;
import hr.unipu.polyling.util.KategorijaArrayAdapter;

public class KategorijeActivity extends AppCompatActivity {

    Baza baza;
    private List<Kategorija> kategorije;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorije);
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(getResources().getString(R.string.category_list_caption));

        //instanciranje baze
        baza = new Baza(this);
        //čitanje svih kategorija u bazu i spremanje u listu
        kategorije = baza.sveKategorije();
        if(kategorije.size()==0) {
            //ukoliko nije pronađena ni jedna kategorija, treba napuniti bazu kategorijama
            PunjenjeBaze.puniKategorije(baza);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                //refreshaj bazu podataka
                PunjenjeBaze.puniKategorije(baza);
                PunjenjeBaze.puniFraze(baza);
                recreate();//resetira prikaz
                return true;
            case R.id.searchButton:
                onSearchRequested();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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
