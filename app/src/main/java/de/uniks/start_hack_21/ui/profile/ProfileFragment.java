package de.uniks.start_hack_21.ui.profile;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.uniks.start_hack_21.R;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        LinearLayout container_overview = root.findViewById(R.id.container_overview);
        LinearLayout container_history = root.findViewById(R.id.container_history);
        LinearLayout container_friends = root.findViewById(R.id.container_friends);

        PieChart pieChartFirst = root.findViewById(R.id.pieChart_view_first);
        PieChart pieChartSecond = root.findViewById(R.id.pieChart_view_second);
        PieChart pieChartThird = root.findViewById(R.id.pieChart_view_third);

        // never hardcode colors like that children
        fillPieChart(pieChartFirst, 64, "#ffa500");
        fillPieChart(pieChartSecond, 76, "#3ca567");
        fillPieChart(pieChartThird, 81, "#3ca567");

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
}
