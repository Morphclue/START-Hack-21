package de.uniks.start_hack_21;

import android.os.Bundle;

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

    public void changeFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.host_fragment_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void changeToDashboard(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DashboardFragment dashboardFragment = new DashboardFragment();
        ft.replace(R.id.host_fragment_container, dashboardFragment);
        ft.addToBackStack(null);
        ft.commit();

        FragmentTransaction nextTransaction = getSupportFragmentManager().beginTransaction();
        nextTransaction.replace(R.id.dashboard_fragment_container, fragment);
        nextTransaction.commit();
    }
}