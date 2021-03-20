package de.uniks.start_hack_21;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import de.uniks.start_hack_21.data.User;
import de.uniks.start_hack_21.ui.dashboard.DashboardFragment;
import de.uniks.start_hack_21.ui.home.HomeFragment;
import de.uniks.start_hack_21.util.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        User user = Utils.loadData(getApplicationContext());
        changeFragment(new HomeFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.host_fragment_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void changeToDashboard(Fragment fragment, String suggestionText) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DashboardFragment dashboardFragment = new DashboardFragment(suggestionText);
        ft.replace(R.id.host_fragment_container, dashboardFragment);
        ft.addToBackStack(null);
        ft.commit();

        FragmentTransaction nextTransaction = getSupportFragmentManager().beginTransaction();
        nextTransaction.replace(R.id.dashboard_fragment_container, fragment);
        nextTransaction.commit();
    }
}