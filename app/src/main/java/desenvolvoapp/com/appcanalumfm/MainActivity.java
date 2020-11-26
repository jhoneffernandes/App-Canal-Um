package desenvolvoapp.com.appcanalumfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void paginicio(View view)
    {
        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void pagnoticias(View view)
    {
        Intent i;
        i = new Intent(this, NewsActivity.class);
        startActivity(i);
    }

    public void pagmusicas(View view)
    {
        Intent i;
        i = new Intent(this, MusicActivity.class);
        startActivity(i);
    }

    public void paglogin(View view)
    {
        Intent i;
        i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}