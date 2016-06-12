
package hr.unipu.polyling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import hr.unipu.polyling.baza.Baza;
import hr.unipu.polyling.util.Fraza;

public class quizChoiceActivity extends AppCompatActivity {
    private Baza baza;
    private int kategorijaID;
    private TextView question;
    private RadioButton choice1;
    private RadioButton choice2;
    private RadioButton choice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_choice);

        kategorijaID = getIntent().getIntExtra("kategorijaID", 0);
        baza = new Baza(this);
        question = (TextView) findViewById(R.id.question);
        choice1 = (RadioButton) findViewById(R.id.choice1);
        choice2 = (RadioButton) findViewById(R.id.choice2);
        choice3 = (RadioButton) findViewById(R.id.choice3);

        setRandomQuestion();
    }

    private String[] getRandomLanguage(Fraza fraza, boolean randomOrder) {
        String[] result = new String[2];

        if (randomOrder) {
            result[0] = fraza.getNaziv_en();
            result[1] = fraza.getNaziv_hr();
        }
        else {
            result[1] = fraza.getNaziv_en();
            result[0] = fraza.getNaziv_hr();
        }

        return result;
    }

    private void setRandomQuestion() {
        ArrayList<Fraza> fraze = (ArrayList<Fraza>) baza.getRandomFraze(kategorijaID);
        ArrayList<Fraza> cloneFraze = (ArrayList<Fraza>) fraze.clone();
        Random random = new Random();
        int randQuestion = random.nextInt(cloneFraze.size());
        boolean randomOrder = random.nextBoolean();

        Fraza q1 = cloneFraze.get(randQuestion);
        cloneFraze.remove(q1);

        randQuestion = random.nextInt(cloneFraze.size());
        Fraza q2 = cloneFraze.get(randQuestion);
        cloneFraze.remove(q2);

        randQuestion = random.nextInt(cloneFraze.size());
        Fraza q3 = cloneFraze.get(randQuestion);
        cloneFraze.remove(q3);

        String[] pitanje1 = getRandomLanguage(q1, randomOrder);
        String[] pitanje2 = getRandomLanguage(q2, randomOrder);
        String[] pitanje3 = getRandomLanguage(q3, randomOrder);

        randQuestion = random.nextInt(fraze.size());

        switch (randQuestion + 1) {
            case 1:
                question.setText(pitanje1[0]);
                choice1.setText(pitanje1[1]);
                choice2.setText(pitanje2[1]);
                choice3.setText(pitanje3[1]);
                break;
            case 2:
                question.setText(pitanje1[0]);
                choice2.setText(pitanje1[1]);
                choice1.setText(pitanje2[1]);
                choice3.setText(pitanje3[1]);
                break;
            case 3:
                question.setText(pitanje1[0]);
                choice3.setText(pitanje1[1]);
                choice2.setText(pitanje2[1]);
                choice1.setText(pitanje3[1]);
                break;
        }
    }
}
