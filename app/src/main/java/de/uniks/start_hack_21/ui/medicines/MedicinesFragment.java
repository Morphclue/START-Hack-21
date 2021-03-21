package de.uniks.start_hack_21.ui.medicines;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.uniks.start_hack_21.R;

public class MedicinesFragment extends Fragment {

    private MedicinesViewModel medicinesViewModel;
    private View root;
    private LayoutInflater inflater;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        medicinesViewModel = new ViewModelProvider(this).get(MedicinesViewModel.class);
        this.inflater = inflater;
        root = inflater.inflate(R.layout.fragment_medicines, container, false);

        generatePillActivities();
        generateDiseaseActivities();
        return root;
    }

    private void generatePillActivities(){
        LinearLayout pillContainer = root.findViewById(R.id.container_pills);
        List<String> pillNames= new ArrayList<>();
        pillNames.add("L-Thyroxin");
        pillNames.add("Ramipril");

        for (String pillName: pillNames) {
            View view = inflater.inflate(R.layout.component_pill_card, null);
            TextView pillActivity = view.findViewById(R.id.text_pill_activity);
            pillActivity.setText(pillName);
            pillContainer.addView(view);
        }
    }

    private void generateDiseaseActivities(){
        LinearLayout diseaseContainer = root.findViewById(R.id.container_diseases);

        View view = inflater.inflate(R.layout.component_disease_card, null);
        TextView diseaseActivity = view.findViewById(R.id.text_disease_name);
        TextView diseaseDate = view.findViewById(R.id.text_disease_date);
        diseaseActivity.setText("Headache");
        diseaseDate.setText("20.03.2021");
        diseaseContainer.addView(view);

        View view2 = inflater.inflate(R.layout.component_disease_card, null);
        TextView diseaseActivity2 = view2.findViewById(R.id.text_disease_name);
        TextView diseaseDate2 = view2.findViewById(R.id.text_disease_date);
        diseaseActivity2.setText("Headache");
        diseaseDate2.setText("19.03.2021");
        diseaseContainer.addView(view2);

        View view3 = inflater.inflate(R.layout.component_disease_card, null);
        TextView diseaseActivity3 = view3.findViewById(R.id.text_disease_name);
        TextView diseaseDate3 = view3.findViewById(R.id.text_disease_date);
        diseaseActivity3.setText("Headache");
        diseaseDate3.setText("17.03.2021");
        diseaseContainer.addView(view3);
    }
}