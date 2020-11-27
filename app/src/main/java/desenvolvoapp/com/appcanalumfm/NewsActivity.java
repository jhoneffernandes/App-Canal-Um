package desenvolvoapp.com.appcanalumfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }
    public void paginicio(View view)
    {
        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void pagnew1(View view)
    {
        Intent i;
        i = new Intent(this, New1Activity.class);
        startActivity(i);
    }

    public void pagnew2(View view)
    {
        Intent i;
        i = new Intent(this, New2Activity.class);
        startActivity(i);
    }

    public void pagnew3(View view)
    {
       Intent i;
        i = new Intent(this, New3Activity.class);
       startActivity(i);
   }
}