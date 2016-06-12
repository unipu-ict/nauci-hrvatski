
package hr.unipu.polyling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import hr.unipu.polyling.baza.Baza;
import hr.unipu.polyling.util.Fraza;

public class quizChoiceActivity extends AppCompatActivity {
    private Baza baza;
    private int kategorijaID;
    private TextView currentQuestionN;
    private TextView question;
    private RadioButton choice1;
    private RadioButton choice2;
    private RadioButton choice3;
    private RadioGroup radioGroup;
    private String[] correctFraza;
    private int correctAnswers = 0;
    private int numberOfQuestions = 0;

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
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        setRandomQuestion();
        updateCurrentQuestionNumber();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                String text = radioButton.getText().toString();
                if (correctFraza[1].compareTo(text) == 0) {
                    Toast.makeText(quizChoiceActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    correctAnswers++;
                }
                else
                    Toast.makeText(quizChoiceActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();

                radioButton.setChecked(false);

                if (numberOfQuestions > 4) {
//                    Toast.makeText(quizChoiceActivity.this, "Number of correct answers: " + correctAnswers, Toast.LENGTH_LONG).show();
//                    finish();
                    Intent intent = new Intent(quizChoiceActivity.this, rezultatiActivity.class);
                    intent.putExtra("brojTocnih", correctAnswers);
                    startActivity(intent);
                }

                setRandomQuestion();
                updateCurrentQuestionNumber();
            }
        });
    }

    private void updateCurrentQuestionNumber() {
        currentQuestionN = (TextView) findViewById(R.id.questionCounter);
        currentQuestionN.setText(numberOfQuestions + " / 5");
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
        Random random = new Random();
        int randQuestion = random.nextInt(fraze.size());
        int rand = random.nextInt(fraze.size());
        boolean randomOrder = random.nextBoolean();
        numberOfQuestions++;

        Fraza q1 = fraze.get(rand);
        fraze.remove(q1);

        rand = random.nextInt(fraze.size());
        Fraza q2 = fraze.get(rand);
        fraze.remove(q2);

        rand = random.nextInt(fraze.size());
        Fraza q3 = fraze.get(rand);
        fraze.remove(q3);

        String[] pitanje1 = getRandomLanguage(q1, randomOrder);
        String[] pitanje2 = getRandomLanguage(q2, randomOrder);
        String[] pitanje3 = getRandomLanguage(q3, randomOrder);

        correctFraza = pitanje1;

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
