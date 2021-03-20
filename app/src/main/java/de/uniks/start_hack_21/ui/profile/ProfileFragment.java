package de.uniks.start_hack_21.ui.profile;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import de.uniks.start_hack_21.R;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        LinearLayout container_friends = root.findViewById(R.id.container_friends);

        PieChart pieChartFirst = root.findViewById(R.id.pieChart_view_first);
        PieChart pieChartSecond = root.findViewById(R.id.pieChart_view_second);
        PieChart pieChartThird = root.findViewById(R.id.pieChart_view_third);

        // never hardcode colors like that children
        fillPieChart(pieChartFirst, 64, "#ffa500");
        fillPieChart(pieChartSecond, 76, "#3ca567");
        fillPieChart(pieChartThird, 81, "#3ca567");

        fillFriends(container_friends, inflater);

        return root;
    }

    private void fillPieChart(PieChart pieChart, int percentage, String color) {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        String label = "type";

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor(color));
        colors.add(Color.parseColor("#808080"));

        String first = percentage + "%";
        pieEntries.add(new PieEntry(percentage, first));
        pieEntries.add(new PieEntry(100 -percentage));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, label);
        pieDataSet.setValueTextSize(12f);
        pieDataSet.setColors(colors);
        PieData pieData = new PieData(pieDataSet);
        pieData.setDrawValues(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.getDescription().setEnabled(false);

        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    private void fillFriends(LinearLayout friendsContainer, LayoutInflater inflater) {
        HashMap<String, String> friendsMap = new HashMap<>();
        friendsMap.put("Florian Microsoft", "42");
        friendsMap.put("Steffen Meister", "-1");
        friendsMap.put("Torbinho", "9000");

        for (String friend : friendsMap.keySet()) {
            View view = inflater.inflate(R.layout.component_friends_card, null);
            TextView nameView = view.findViewById(R.id.text_friend_name);
            TextView levelView = view.findViewById(R.id.text_friend_level);

            nameView.setText(friend);
            levelView.setText(friendsMap.get(friend));

            friendsContainer.addView(view);
        }

    }
}
