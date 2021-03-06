package de.uniks.start_hack_21.ui.sleep;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;


import java.util.ArrayList;
import java.util.List;

import de.uniks.start_hack_21.R;
import de.uniks.start_hack_21.data.SleepData;
import de.uniks.start_hack_21.data.User;
import de.uniks.start_hack_21.util.UserManagement;

public class SleepFragment extends Fragment {

    BarChart barChart;

    @SuppressLint("ResourceType")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sleep, container, false);

        barChart = root.findViewById(R.id.sleep_bar_chart);
        User user = UserManagement.getUser();
        initBarChart();
        showBarChart(user);

        PieChart pieChart = root.findViewById(R.id.pieChart_view_first);
        fillPieChart(pieChart, 64, getResources().getString(R.color.cardOkayColor));

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

    private void showBarChart(User user){
        ArrayList<Double> light_sleep_hours = new ArrayList<>();
        ArrayList<Double> deep_sleep_hours = new ArrayList<>();
        ArrayList<Double> sleep_hours = new ArrayList<>();
        ArrayList<BarEntry> entries = new ArrayList<>();

        List<SleepData> sleep = user.getSleep();

        for (SleepData single: sleep) {
            light_sleep_hours.add((double)single.getLightSleep()/60);
        }

        for (SleepData single: sleep) {
            deep_sleep_hours.add((double)single.getDeepSleep()/60);
        }
        for (SleepData single: sleep) {
            sleep_hours.add((double)single.getMinutes()/60);
        }
        for (int i = 0; i < sleep.size(); i++) {
            BarEntry barEntry = new BarEntry(i,
                    new float[]{deep_sleep_hours.get(i).floatValue(), light_sleep_hours.get(i).floatValue()});
            entries.add(barEntry);
        }

        MyBarDataSet barDataSet = new MyBarDataSet(entries, "", sleep_hours);
        BarData data = new BarData(barDataSet);
        barChart.setData(data);
        barDataSet.setStackLabels(new String[]{"Deep Sleep", "Light Sleep"});
        barChart.invalidate();


        initBarDataSet(barDataSet);
    }

    @SuppressLint("ResourceType")
    private void initBarDataSet(BarDataSet barDataSet){    //Changing the color of the bar
        barDataSet.setColors(Color.parseColor("#777777"),
                Color.parseColor(getResources().getString(R.color.cardGoodColor)),
                Color.parseColor(getResources().getString(R.color.cardOkayColor)),
                Color.parseColor(getResources().getString(R.color.cardBadColor)));
        barDataSet.setFormSize(15f);    //showing the value of the bar, default true if not set
        barDataSet.setDrawValues(false);    //setting the text size of the value of the bar
        barDataSet.setValueTextSize(12f);
    }

    private void initBarChart(){
        //hiding the grey background of the chart, default false if not set
        barChart.setDrawGridBackground(false);
        //remove the bar shadow, default false if not set
        barChart.setDrawBarShadow(false);
        //remove border of the chart, default false if not set
        barChart.setDrawBorders(false);



        //remove the description label text located at the lower right corner
        Description description = new Description();
        description.setEnabled(false);
        barChart.setDescription(description);

        //setting animation for y-axis, the bar will pop up from 0 to its value within the time we set
        barChart.animateY(1000);
        //setting animation for x-axis, the bar will pop up separately within the time we set
        barChart.animateX(1000);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);

        final String[] weekdays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        xAxis.setValueFormatter(new IndexAxisValueFormatter(weekdays));

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setDrawAxisLine(false);
        leftAxis.setAxisMinimum(0f);

        YAxis rightAxis = barChart.getAxisRight();
        //hiding the right y-axis line, default true if not set
        rightAxis.setDrawAxisLine(false);
        rightAxis.setAxisMinimum(0f);

        Legend legend = barChart.getLegend();
        //setting the shape of the legend form to line, default square shape
        legend.setForm(Legend.LegendForm.LINE);
        //setting the text size of the legend
        legend.setTextSize(11f);
        //setting the alignment of legend toward the chart
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        //setting the stacking direction of legend
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //setting the location of legend outside the chart, default false if not set
        legend.setDrawInside(false);

    }

    private static class MyBarDataSet extends BarDataSet {
        List<Double> total;
        public MyBarDataSet(List<BarEntry> yVals, String label, List<Double> total) {
            super(yVals, label);
            this.total = total;
        }

        @Override
        public int getColor(int index) {
            if(index%2 == 0) {
                return mColors.get(0);
            }else {
                if (total.get(index/2) < 8.5 && total.get(index/2) > 6)
                    return mColors.get(1);
                else if (total.get(index/2) < 11 && total.get(index/2) > 4.5)
                    return mColors.get(2);
                else
                    return mColors.get(3);

            }
        }
    }
}