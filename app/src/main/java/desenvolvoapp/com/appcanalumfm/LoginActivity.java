package desenvolvoapp.com.appcanalumfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void pagdash(View view)
    {
        Intent i;
        i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }

    public void paginicio(View view)
    {
        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}