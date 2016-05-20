package hr.unipu.polyling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class KategorijeActivity extends AppCompatActivity {

    private List<Kategorija> kategorije = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorije);

        //test podaci
        kategorije.add(new Kategorija(0, "Test", "Proba", "mis"));
        kategorije.add(new Kategorija(1, "Animals", "Proba", "mis"));
        kategorije.add(new Kategorija(2, "Food", "Proba", "mis"));
        kategorije.add(new Kategorija(3, "Cars", "Proba", "mis"));


        GridView grid = (GridView) findViewById(R.id.kategorijeGrid);
        grid.setAdapter(new KategorijaArrayAdapter(this, 0, kategorije));

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
