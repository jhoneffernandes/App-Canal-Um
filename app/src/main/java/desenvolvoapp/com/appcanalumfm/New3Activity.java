package desenvolvoapp.com.appcanalumfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class New3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new3);
        WebView w = findViewById(R.id.web);
        w.loadUrl("file:///android_asset/new3.html");
        w.setWebChromeClient(new WebChromeClient());
        w.setWebViewClient(new WebViewClient());
        w.getSettings().setJavaScriptEnabled(true);
        w.addJavascriptInterface(new Ponte(this), "Android");
    }
    public void pagnews(View view)
    {
        Intent i;
        i = new Intent(this, NewsActivity.class);
        startActivity(i);
    }
}