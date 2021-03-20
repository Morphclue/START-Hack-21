package de.uniks.start_hack_21.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import de.uniks.start_hack_21.R;

public class DashboardFragment extends Fragment {

    private DashboardsViewModel dashboardsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardsViewModel = new ViewModelProvider(this).get(DashboardsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);



        return root;
    }
}