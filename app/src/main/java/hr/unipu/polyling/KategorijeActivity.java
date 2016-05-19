package hr.unipu.polyling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class KategorijeActivity extends AppCompatActivity {

    private Kategorija[] kategorije = new Kategorija[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorije);

        //test podaci
        for(int i=0;i<kategorije.length;i++) {
            kategorije[i] = new Kategorija(i, "Category "+(i+1), "Kategorija "+(i+1));
        }


        GridView grid = (GridView) findViewById(R.id.kategorijeGrid);
        grid.setAdapter(new ArrayAdapter<Kategorija>(this, android.R.layout.simple_list_item_1, kategorije));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(KategorijeActivity.this, FrazeListActivity.class);
                intent.putExtra("frazaID", id);
                startActivity(intent);
            }
        });

    }
}
