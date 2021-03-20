package de.uniks.start_hack_21.ui.medicines;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import de.uniks.start_hack_21.R;

public class MedicinesFragment extends Fragment {

    private MedicinesViewModel medicinesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        medicinesViewModel = new ViewModelProvider(this).get(MedicinesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_medicines, container, false);

        return root;
    }
}