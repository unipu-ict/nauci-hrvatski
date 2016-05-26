package hr.unipu.polyling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

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

    public void otvoriSearch(View view) {
        onSearchRequested();
    }


}
