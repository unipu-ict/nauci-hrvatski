package hr.unipu.polyling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private int kategorijaID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(getResources().getString(R.string.quiz_caption));

        kategorijaID = getIntent().getIntExtra("kategorijaID", 0);
        getRandomQuiz();
    }

    private void getRandomQuiz() {
        Class[] activities = {
                quizChoiceActivity.class,
                quizListenActivity.class,
                quizWriteActivity.class
        };

        Random random = new Random();
//        int randN = random.nextInt(4 - 1) + 1;
        int randN = 0;

        Intent intent = new Intent(this, activities[randN]);
        intent.putExtra("kategorijaID", kategorijaID);
        startActivity(intent);
    }
}
