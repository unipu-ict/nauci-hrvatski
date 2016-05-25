package hr.unipu.polyling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import hr.unipu.polyling.baza.Baza;
import hr.unipu.polyling.model.Fraza;

public class FrazeListActivity extends AppCompatActivity {

    Baza baza;
    private List<Fraza> fraze;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraze_list);

        baza = new Baza(this);

        int kategorijaID = getIntent().getIntExtra("kategorijaID", 0);
        String imeKategorije = baza.getKategorijabyID(kategorijaID).getNaziv_en();
        Log.d("POLYLING", "imeKategorije: "+imeKategorije);
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(imeKategorije);

        ListView list = (ListView) findViewById(R.id.frazeList);
        assert list != null;
        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fraze));

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
