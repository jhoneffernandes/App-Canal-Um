package desenvolvoapp.com.appcanalumfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void pagrelatorio(View view)
    {
        Intent i;
        i = new Intent(this, RelatorioActivity.class);
        startActivity(i);
    }

    public void paginicio(View view)
    {
        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}