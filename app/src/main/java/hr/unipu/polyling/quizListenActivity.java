package hr.unipu.polyling;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import hr.unipu.polyling.baza.Baza;
import hr.unipu.polyling.util.Fraza;

public class quizListenActivity extends AppCompatActivity {

    private Baza baza;
    private int kategorijaID;
    private TextView currentQuestionN;
    private RadioButton choice1;
    private RadioButton choice2;
    private RadioButton choice3;
    private ImageView speakButton;
    private TextToSpeech spiker;
    private RadioGroup radioGroup;
    private Fraza correctFraza;
    private int correctAnswers = 0;
    private int numberOfQuestions = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_listen);

        kategorijaID = getIntent().getIntExtra("kategorijaID", 0);
        baza = new Baza(this);
        choice1 = (RadioButton) findViewById(R.id.choice1);
        choice2 = (RadioButton) findViewById(R.id.choice2);
        choice3 = (RadioButton) findViewById(R.id.choice3);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
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

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                String text = radioButton.getText().toString();
                if (correctFraza.getNaziv_en().compareTo(text) == 0) {
                    Toast.makeText(quizListenActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    correctAnswers++;
                }
                else
                    Toast.makeText(quizListenActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();

                radioButton.setChecked(false);

                if (numberOfQuestions > 4) {
                    Toast.makeText(quizListenActivity.this, "Number of correct answers: " + correctAnswers, Toast.LENGTH_LONG).show();
                    finish();
                }

                setRandomQuestion();
                updateCurrentQuestionNumber();
            }
        });

        setRandomQuestion();
        updateCurrentQuestionNumber();
    }

    private void setRandomQuestion() {
        ArrayList<Fraza> fraze = (ArrayList<Fraza>) baza.getRandomFraze(kategorijaID);
        Random random = new Random();
        int randQuestion = random.nextInt(fraze.size());
        int rand = random.nextInt(fraze.size());
        numberOfQuestions++;

        Fraza q1 = fraze.get(rand);
        fraze.remove(q1);

        rand = random.nextInt(fraze.size());
        Fraza q2 = fraze.get(rand);
        fraze.remove(q2);

        rand = random.nextInt(fraze.size());
        Fraza q3 = fraze.get(rand);
        fraze.remove(q3);

        correctFraza = q1;

        switch (randQuestion + 1) {
            case 1:
                choice1.setText(q1.getNaziv_en());
                choice2.setText(q2.getNaziv_en());
                choice3.setText(q3.getNaziv_en());
                break;
            case 2:
                choice2.setText(q1.getNaziv_en());
                choice1.setText(q2.getNaziv_en());
                choice3.setText(q3.getNaziv_en());
                break;
            case 3:
                choice3.setText(q1.getNaziv_en());
                choice2.setText(q2.getNaziv_en());
                choice1.setText(q3.getNaziv_en());
                break;
        }
    }

    private void updateCurrentQuestionNumber() {
        currentQuestionN = (TextView) findViewById(R.id.questionCounter);
        currentQuestionN.setText(numberOfQuestions + " / 5");
    }

    private void izgovori() {

            if (!spiker.isSpeaking()) {
                String tekst = correctFraza.getNaziv_hr();
                spiker.speak(tekst, TextToSpeech.QUEUE_FLUSH, null);
            }
    }
}