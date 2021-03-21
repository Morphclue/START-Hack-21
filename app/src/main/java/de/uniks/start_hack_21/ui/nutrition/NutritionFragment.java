package de.uniks.start_hack_21.ui.nutrition;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

import de.uniks.start_hack_21.R;
import de.uniks.start_hack_21.data.NutrientsData;
import de.uniks.start_hack_21.data.User;
import de.uniks.start_hack_21.util.UserManagement;

public class NutritionFragment extends Fragment {


    @SuppressLint("ResourceType")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_nutrition, container, false);
        User user = UserManagement.getUser();

        CombinedChart chart;

        chart = root.findViewById(R.id.nutrition_combined_chart);
        chart.getDescription().setEnabled(false);
        chart.setBackgroundColor(Color.WHITE);
        chart.setDrawGridBackground(false);
        chart.setDrawBarShadow(false);
        chart.setHighlightFullBarEnabled(false);

        // draw bars behind lines
        chart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE
        });

        CombinedData data = new CombinedData();
        data.setData(getLineData(2300));
        data.setData(getBarData(user, 2300));

        Legend l = chart.getLegend();
        l.setWordWrapEnabled(true);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        final String[] nutrition_label = {"Fat", "Proteins", "Carbs"};
        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(nutrition_label));
        xAxis.setAxisMinimum(-0.25f);
        xAxis.setAxisMaximum(data.getXMax() + 0.25f);

        chart.setData(data);
        chart.invalidate();

        BarChart kCalBar;
        kCalBar = root.findViewById(R.id.nutrition_cKal_bar_chart);
        //remove the description label text located at the lower right corner
        Description description = new Description();
        description.setEnabled(false);
        kCalBar.setDescription(description);

        kCalBar.getLegend().setEnabled(false);

        XAxis xAxisKCal = kCalBar.getXAxis();
        xAxisKCal.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxisKCal.setGranularity(1f);
        xAxisKCal.setDrawAxisLine(false);
        xAxisKCal.setDrawGridLines(false);
        xAxisKCal.setValueFormatter(new IndexAxisValueFormatter(new String[]{"KCalories"}));

        YAxis leftAxisKCal = kCalBar.getAxisLeft();
        leftAxisKCal.setEnabled(false);

        YAxis rightKCal = kCalBar.getAxisRight();
        rightKCal.setAxisMinimum(0f);

        kCalBar.setData(getKCalBarData(user, 2300));
        kCalBar.invalidate();

        PieChart pieChart = root.findViewById(R.id.pieChart_nutrition);
        fillPieChart(pieChart, 91, getResources().getString(R.color.cardGoodColor));

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

    @SuppressLint("ResourceType")
    private LineData getLineData(float targetCals) {
        double fatPerKCal = 0.033;
        double carbsPerKCal = 0.123;
        double proteinPerKCal = 0.036;

        LineData d = new LineData();

        ArrayList<Entry> entriesTop = new ArrayList<>();
        entriesTop.add(new Entry(0, (float)(fatPerKCal*targetCals*1.1)));
        entriesTop.add(new Entry(1, (float)(proteinPerKCal*targetCals*1.1)));
        entriesTop.add(new Entry(2, (float)(carbsPerKCal*targetCals*1.1)));

        ArrayList<Entry> entriesBottom = new ArrayList<>();
        entriesBottom.add(new Entry(0, (float)(fatPerKCal*targetCals*0.9)));
        entriesBottom.add(new Entry(1, (float)(proteinPerKCal*targetCals*0.9)));
        entriesBottom.add(new Entry(2, (float)(carbsPerKCal*targetCals*0.9)));


        LineDataSet setTop = new LineDataSet(entriesTop, "Upper Bound");
        setTop.setColor(Color.parseColor(getResources().getString(R.color.cardGoodColor)));
        setTop.setLineWidth(2.5f);
        setTop.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        setTop.setDrawValues(false);

        LineDataSet setBottom = new LineDataSet(entriesBottom, "Lower Bound");
        setBottom.setColor(Color.parseColor(getResources().getString(R.color.cardGoodColor)));
        setBottom.setLineWidth(2.5f);
        setBottom.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        setBottom.setDrawValues(false);


        setTop.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(setTop);
        d.addDataSet(setBottom);

        return d;
    }

    @SuppressLint("ResourceType")
    private BarData getKCalBarData(User user, double targetCals){
        List<NutrientsData> nutrients = user.getNutrition();
        NutrientsData last_nutrients = nutrients.get(nutrients.size()-1);
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, last_nutrients.getCalories()));

        List<Double> targetCKalsList = new ArrayList<>();
        targetCKalsList.add(targetCals);

        MyBarDataSet set = new MyBarDataSet(entries, "Calories", targetCKalsList);
        set.setColors(Color.parseColor(getResources().getString(R.color.cardGoodColor)),
                Color.parseColor(getResources().getString(R.color.cardOkayColor)),
                Color.parseColor(getResources().getString(R.color.cardBadColor)));
        set.setValueTextColor(Color.rgb(0, 0, 0));
        set.setValueTextSize(10f);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);

        BarData d = new BarData(set);
        float barWidth = 0.45f;
        d.setBarWidth(barWidth);
        return d;
    }

    @SuppressLint("ResourceType")
    private BarData getBarData(User user, double targetCals) {
        double fatPerKCal = 0.033;
        double carbsPerKCal = 0.123;
        double proteinPerKCal = 0.036;

        List<Double> nutrientsTarget = new ArrayList<>();
        nutrientsTarget.add(fatPerKCal*targetCals);
        nutrientsTarget.add(proteinPerKCal*targetCals);
        nutrientsTarget.add(carbsPerKCal*targetCals);

        List<NutrientsData> nutrients = user.getNutrition();
        NutrientsData last_nutrients = nutrients.get(nutrients.size()-1);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, last_nutrients.getFat()));
        entries.add(new BarEntry(1, last_nutrients.getProteins()));
        entries.add(new BarEntry(2, last_nutrients.getCarbs()));

        MyBarDataSet set1 = new MyBarDataSet(entries, "Nutritions", nutrientsTarget);
        set1.setColors(Color.parseColor(getResources().getString(R.color.cardGoodColor)),
                Color.parseColor(getResources().getString(R.color.cardOkayColor)),
                Color.parseColor(getResources().getString(R.color.cardBadColor)));
        set1.setValueTextColor(Color.rgb(0, 0, 0));
        set1.setValueTextSize(10f);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);

        float barWidth = 0.45f;

        BarData d = new BarData(set1);
        d.setBarWidth(barWidth);

        return d;
    }

    private static class MyBarDataSet extends BarDataSet {
        List<Double> total;
        public MyBarDataSet(List<BarEntry> yVals, String label, List<Double> total) {
            super(yVals, label);
            this.total = total;
        }

        @Override
        public int getColor(int index) {
            if (getEntryForIndex(index).getY() < total.get(index)*1.1 && getEntryForIndex(index).getY() > total.get(index)*0.9){
                return mColors.get(0);}
            else if (getEntryForIndex(index).getY() < total.get(index)*1.3 && getEntryForIndex(index).getY() > total.get(index)*0.7)
                return mColors.get(1);
            else
                return mColors.get(2);
        }
    }

}