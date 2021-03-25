package de.uniks.start_hack_21.ui.training;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;

import de.uniks.start_hack_21.R;
import de.uniks.start_hack_21.data.ActivityResponse;
import de.uniks.start_hack_21.services.ActivityService;
import de.uniks.start_hack_21.services.ServiceBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrainingsFragment extends Fragment implements Callback<List<ActivityResponse>> {

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ActivityService activityService = ServiceBuilder.retrofit.create(ActivityService.class);

        // hard coded userId:
        String testUserId = "01E8091B7D4F004EFB77FA332F662C20";

        activityService.getActivities(testUserId).enqueue(this);

    }

    @Override
    public void onResponse(Call<List<ActivityResponse>> call, Response<List<ActivityResponse>> response) {
        List<ActivityResponse> activities = response.body();
        Log.d("trainingsFragment",activities.size() + " activities found");
    }

    @Override
    public void onFailure(Call<List<ActivityResponse>> call, Throwable t) {
        Log.e("trainingsFragment", "error:" + t);
    }
}
