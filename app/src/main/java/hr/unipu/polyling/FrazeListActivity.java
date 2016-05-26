package hr.unipu.polyling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hr.unipu.polyling.baza.Baza;
import hr.unipu.polyling.util.Fraza;
import hr.unipu.polyling.util.OnSwipeTouchListener;

public class FrazeListActivity extends AppCompatActivity {

    Baza baza;
    private List<Fraza> fraze;
    private TextView naziv;
    private TextView nazivHr;
    private int frazeIndex = 0;

    private void setFrazaText() {
        naziv.setText(fraze.get(frazeIndex).getNaziv_en());
        nazivHr.setText(fraze.get(frazeIndex).getNaziv_hr());
    }

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

        fraze = baza.getFrazeByKategorijaId(kategorijaID);
        naziv = (TextView) findViewById(R.id.nazivFraze);
        nazivHr = (TextView) findViewById(R.id.nazivFrazeHr);

        setFrazaText();

        ViewGroup layout = (ViewGroup) findViewById(R.id.frazeLayout);
        layout.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeRight() {
                if (frazeIndex <= 0) frazeIndex = fraze.size() - 1;
                else
                    frazeIndex--;
                setFrazaText();
            }
            public void onSwipeLeft() {
                if (frazeIndex >= fraze.size() - 1) frazeIndex = 0;
                else
                    frazeIndex++;
                setFrazaText();
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
