
package hr.unipu.polyling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import hr.unipu.polyling.baza.Baza;
import hr.unipu.polyling.util.Fraza;

public class quizChoiceActivity extends AppCompatActivity {
    private Baza baza;
    private int kategorijaID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_choice);

        kategorijaID = getIntent().getIntExtra("kategorijaID", 0);
        baza = new Baza(this);

    }

    private void setRandomQuestion() {
        List<Fraza> fraze = baza.getRandomFraze(kategorijaID);

    }
}
