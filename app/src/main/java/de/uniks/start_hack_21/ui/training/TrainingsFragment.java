package de.uniks.start_hack_21.ui.training;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.HashMap;

import de.uniks.start_hack_21.R;

public class TrainingsFragment extends Fragment {

    private TrainingsViewModel trainingsViewModel;
    private View root;
    private LayoutInflater inflater;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        trainingsViewModel = new ViewModelProvider(this).get(TrainingsViewModel.class);
        this.inflater = inflater;
        root = inflater.inflate(R.layout.fragment_trainings, container, false);

        generateActivities();
        return root;
    }

    private void generateActivities(){
        LinearLayout trainingContainer = root.findViewById(R.id.fragment_container_trainings);
        HashMap<String, String> nameTimeMap = new HashMap<>();
        nameTimeMap.put("Swimming", "20min");
        nameTimeMap.put("Cardio", "1h 20min");
        nameTimeMap.put("Tennis", "12min");
        nameTimeMap.put("Walk", "5min");
        nameTimeMap.put("Hiking", "42min");

        for (String key : nameTimeMap.keySet()) {
            View view = inflater.inflate(R.layout.component_sports_card, null);
            TextView sportActivity = view.findViewById(R.id.text_sport_activity);
            TextView sportTime = view.findViewById(R.id.text_sport_time);
            sportActivity.setText(key);
            sportTime.setText(nameTimeMap.get(key));

            trainingContainer.addView(view);
        }
    }
}