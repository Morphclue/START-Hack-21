package de.uniks.start_hack_21.ui.insurances;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import de.uniks.start_hack_21.R;

public class InsurancesFragment extends Fragment {

    private InsuranceViewModel insuranceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        insuranceViewModel = new ViewModelProvider(this).get(InsuranceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_insurances, container, false);


        return root;
    }
}