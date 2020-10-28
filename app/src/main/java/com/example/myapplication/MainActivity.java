package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LineChart chart = findViewById(R.id.chart);
        initChart(chart);

        List<Pair<Float, Float>> values = Arrays.asList(
                new Pair<>(0f, 1f),
                new Pair<>(1f, 2f),
                new Pair<>(2f, 3f),
                new Pair<>(3f, 4f),
                new Pair<>(4f, 5f),
                new Pair<>(5f, 6f),
                new Pair<>(6f, 7f),
                new Pair<>(7f, 8f),
                new Pair<>(8f, 9f),
                new Pair<>(9f, 10f),
                new Pair<>(10f, 9f),
                new Pair<>(11f, 8f),
                new Pair<>(12f, 7f),
                new Pair<>(13f, 6f),
                new Pair<>(14f, 5f),
                new Pair<>(15f, 4f),
                new Pair<>(16f, 3f),
                new Pair<>(17f, 2f),
                new Pair<>(18f, 1f),
                new Pair<>(19f, 0f)
        );
        LineDataSet dataSet = new LineDataSet(createRawEntriesForValues(values), "dupka");
        dataSet.setLineWidth(1f);
        dataSet.setDrawCircles(true);
        dataSet.setDrawCircleHole(false);

        LimitLine ll = new LimitLine(5f, "Halko");
        ll.setLineColor(android.R.color.holo_red_dark);
        ll.setLineWidth(4f);

//        dataSet.setCircleHoleRadius(0f);
        dataSet.setCircleColor(ContextCompat.getColor(this, android.R.color.background_dark));
        dataSet.setDrawValues(false);
        dataSet.setHighLightColor(ContextCompat.getColor(this, android.R.color.background_dark));
        dataSet.setColor(ContextCompat.getColor(this, android.R.color.transparent));
        dataSet.setDrawFilled(false);
        chart.setData(new LineData(dataSet));


        chart.getAxisLeft().addLimitLine(ll);
        chart.invalidate();
    }

    private void initChart(LineChart chart) {
        chart.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
        chart.getDescription().setEnabled(false);
        chart.setDragEnabled(false);
        chart.setScaleEnabled(false);
        chart.setPinchZoom(false);
        chart.setTouchEnabled(false);
        chart.getAxisLeft().setDrawAxisLine(true);
        chart.getAxisRight().setEnabled(false);
        chart.getXAxis().setEnabled(true);


        chart.getXAxis().setAvoidFirstLastClipping(true);
        chart.getXAxis().setGranularity(1);
        chart.getXAxis().setLabelCount(5, true);

        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.setVisibleXRangeMaximum(1);
        chart.getLegend().setEnabled(false);
    }

    List<Entry> createRawEntriesForValues(List<Pair<Float, Float>> values) {
        List<Pair<Float, Float>> copiedValues = new ArrayList<>(values);
        return copiedValues.stream()
                .map(v -> new Entry(v.first, v.second, String.valueOf(v.second)))
                .collect(Collectors.toList());
    }

}