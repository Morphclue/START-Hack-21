package de.uniks.start_hack_21.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import de.uniks.start_hack_21.R;

public class DashboardFragment extends Fragment {

    private DashboardsViewModel dashboardsViewModel;
    private String suggestionText;

    public DashboardFragment(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardsViewModel = new ViewModelProvider(this).get(DashboardsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        TextView textView = root.findViewById(R.id.text_suggestions);
        textView.setText(suggestionText);
        return root;
    }
}