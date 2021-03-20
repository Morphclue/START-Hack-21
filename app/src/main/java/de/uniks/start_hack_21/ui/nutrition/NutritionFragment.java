package de.uniks.start_hack_21.ui.nutrition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import de.uniks.start_hack_21.R;

public class NutritionFragment extends Fragment {

    private NutritionViewModel nutritionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nutritionViewModel = new ViewModelProvider(this).get(NutritionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_nutrition, container, false);


        return root;
    }
}