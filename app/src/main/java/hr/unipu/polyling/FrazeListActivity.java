package hr.unipu.polyling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import hr.unipu.polyling.baza.Baza;

public class FrazeListActivity extends AppCompatActivity {

    Baza baza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraze_list);

        baza = new Baza(this);

        TextView naslov = (TextView) findViewById(R.id.frazeNaslov);
        int kategorijaID = getIntent().getIntExtra("kategorijaID", 0);
        Log.d("POLYLING", "kategorijaID: "+kategorijaID);
        String imeKategorije = baza.getKategorijabyID(kategorijaID).getNaziv_en();
        Log.d("POLYLING", "imeKategorije: "+imeKategorije);
        naslov.setText("Fraze iz kategorije " +imeKategorije);

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
