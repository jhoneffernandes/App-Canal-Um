package desenvolvoapp.com.appcanalumfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        WebView w = findViewById(R.id.web);
        w.loadUrl("file:///android_asset/index.html");
        w.setWebChromeClient(new WebChromeClient());
        w.setWebViewClient(new WebViewClient());
        w.getSettings().setJavaScriptEnabled(true);
        w.addJavascriptInterface(new Ponte(this), "Android");
    }
}

class Ponte {
    private Context contexto;


    public Ponte(Context contexto) {
        this.contexto = contexto;
    }

    @JavascriptInterface
    public void mostraMensagem(String texto) {
        Toast.makeText(this.contexto, texto, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void grava(String nome, String mensagem, String musica, String artista) {
        Banco bd = new Banco(this.contexto);
        if (bd.insere(nome, mensagem, musica, artista) > 0) {
            Toast.makeText(contexto, "Dados Gravados com Sucesso", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(contexto, "Dados não Gravados", Toast.LENGTH_LONG).show();
        }
    }

    @JavascriptInterface
    public String consulta() {
        Banco bd = new Banco(this.contexto);
        return bd.consulta();
    }

    @JavascriptInterface
    public void abrir() {
        Intent i = new Intent(contexto, MainActivity.class);
        contexto.startActivity(i);
    }

}