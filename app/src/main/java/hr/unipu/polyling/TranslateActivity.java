package hr.unipu.polyling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TranslateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle("Translate");

        WebView translator = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = translator.getSettings();
        webSettings.setJavaScriptEnabled(true);
        translator.setWebViewClient(new WebViewClient());
        translator.loadUrl("https://translate.google.com/#en/hr/");





    }
}
