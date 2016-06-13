package hr.unipu.polyling;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import hr.unipu.polyling.baza.Baza;
import hr.unipu.polyling.util.Fraza;
import hr.unipu.polyling.util.FrazeArrayAdapter;

public class SearchActivity extends ListActivity {
    Baza baza;
    List<Fraza> fraze;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        baza = new Baza(this);
        handleIntent(getIntent());

    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            pretrazi(query);
        }
    }

    private void pretrazi(String query) {
        fraze = baza.searchFraze(query.trim());
        setListAdapter(new FrazeArrayAdapter(this, R.layout.fraza_item, fraze));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        baza.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        baza.close();
    }
}
