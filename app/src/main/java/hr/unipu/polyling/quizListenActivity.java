package hr.unipu.polyling;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Locale;

import hr.unipu.polyling.baza.Baza;

public class quizListenActivity extends AppCompatActivity {

    private Baza baza;
    private int kategorijaID;
    private TextView question;
    private RadioButton choice1;
    private RadioButton choice2;
    private RadioButton choice3;
    private ImageView speakButton;
    private TextToSpeech spiker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_listen);

        kategorijaID = getIntent().getIntExtra("kategorijaID", 0);
        baza = new Baza(this);
//        question = (TextView) findViewById(R.id.question);
        choice1 = (RadioButton) findViewById(R.id.choice1);
        choice2 = (RadioButton) findViewById(R.id.choice2);
        choice3 = (RadioButton) findViewById(R.id.choice3);
        speakButton = (ImageView) findViewById(R.id.question);

        spiker = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    spiker.setLanguage(Locale.forLanguageTag("cs")); //češki fino čita
                    spiker.setSpeechRate(0.86f);
                }
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

            if (!spiker.isSpeaking()) {
                String tekst;// = nazivHr.getText().toString();
                //spiker.speak(tekst, TextToSpeech.QUEUE_FLUSH, null);
            }
    }
}
