package hr.unipu.polyling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import hr.unipu.polyling.baza.PunjenjeBaze;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL);
    }

    public void otvoriKategorije(View view) {
        Intent intent = new Intent(this, KategorijeActivity.class);
        startActivity(intent);
    }
    public void otvoriKategorijeKviz(View view) {
        Intent intent = new Intent(this, KategorijeActivity.class);
        intent.putExtra("kviz", true);
        startActivity(intent);
    }
    public void otvoriSearch(View view) {
        onSearchRequested();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.searchButton:
                onSearchRequested();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
