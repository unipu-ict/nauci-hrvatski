package hr.unipu.polyling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FrazeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraze_list);

        TextView naslov = (TextView) findViewById(R.id.frazeNaslov);
        long frazaID = getIntent().getLongExtra("frazaID", 0);
        //promijeniti tako da doda naziv kategorije s tim ID-om iz baze
        naslov.setText("Fraze iz kategorije " +(frazaID+1));

    }
}
