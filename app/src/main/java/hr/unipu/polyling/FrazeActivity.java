package hr.unipu.polyling;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import hr.unipu.polyling.baza.Baza;
import hr.unipu.polyling.baza.PunjenjeBaze;
import hr.unipu.polyling.util.Fraza;
import hr.unipu.polyling.util.OnSwipeTouchListener;

public class FrazeActivity extends AppCompatActivity {

    Baza baza;
    private List<Fraza> fraze;
    private TextView naziv;
    private TextView nazivHr;
    private Button speakButton;
    private TextToSpeech spiker;
    private int frazeIndex = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraze);

        baza = new Baza(this);
        spiker = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    spiker.setLanguage(Locale.UK);
                }
            }
        });

        int kategorijaID = getIntent().getIntExtra("kategorijaID", 0);
        String imeKategorije = baza.getKategorijabyID(kategorijaID).getNaziv_en();
        Log.d("POLYLING", "imeKategorije: "+imeKategorije);
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(imeKategorije);

        fraze = baza.getFrazeByKategorijaId(kategorijaID);
        naziv = (TextView) findViewById(R.id.nazivFraze);
        nazivHr = (TextView) findViewById(R.id.nazivFrazeHr);
        speakButton = (Button) findViewById(R.id.speakButton);

        setFrazaText();

        ViewGroup layout = (ViewGroup) findViewById(R.id.frazeLayout);
        assert layout != null;
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

        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                izgovori();
            }
        });

    }

    private void izgovori() {
        //TODO: naći bolju funkciju i nek izgovara hrvatski naziv fraze, ovako je namjerno na eng jer ne liči na ništa kad izgovara hrvatske riječi
        if (!spiker.isSpeaking()) {
            String tekst = naziv.getText().toString();
            spiker.speak(tekst, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    private void setFrazaText() {
        naziv.setText(fraze.get(frazeIndex).getNaziv_en());
        nazivHr.setText(fraze.get(frazeIndex).getNaziv_hr());
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
        if(spiker!=null) {
            spiker.shutdown();
        }
    }
}
