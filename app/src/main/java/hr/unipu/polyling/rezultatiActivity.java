package hr.unipu.polyling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class rezultatiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultati);

        int brojTocnih = getIntent().getIntExtra("brojTocnih", 0);
        String poruka = null;
         switch (brojTocnih) {
                 case 0: poruka="Very bad";
                     break;
                 case 1: poruka="Bad!";
                    break;
                 case 2: poruka="Not so good!";
                     break;
                 case 3: poruka="Good job!";
                     break;
                 case 4: poruka="Great!";
                     break;
                 case 5: poruka="Exellent!";
                     break;

         }

        TextView viewBrojTocnih = (TextView) findViewById(R.id.brojTocnih);
        TextView viewPoruka = (TextView) findViewById(R.id.poruka);

        viewBrojTocnih.setText(brojTocnih);
        viewPoruka.setText(poruka);



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
