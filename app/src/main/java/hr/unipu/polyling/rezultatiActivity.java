package hr.unipu.polyling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class rezultatiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultati);

//        int brojTocnih = getIntent().getIntExtra("brojTocnih");


    }



    public void otvoriPocetnu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void otvoriQuiz(View view) {
        Intent intent = new Intent(this, KategorijeActivity.class);
        intent.putExtra("kviz", true);
        startActivity(intent);
    }
}
