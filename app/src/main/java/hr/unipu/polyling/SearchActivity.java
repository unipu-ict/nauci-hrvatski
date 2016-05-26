package hr.unipu.polyling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(getResources().getString(R.string.search_title));

    }
}
