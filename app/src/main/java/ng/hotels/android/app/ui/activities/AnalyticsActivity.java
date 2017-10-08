package ng.hotels.android.app.ui.activities;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import ng.hotels.android.app.R;

public class AnalyticsActivity extends AppCompatActivity implements OnChartValueSelectedListener,
        OnChartGestureListener {

    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // To make full screen layout
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_analytics);


        /*
        * This takes care of the Line Chart
        * */
        mChart = (LineChart) findViewById(R.id.lineChart);
        mChart.setOnChartGestureListener(this);
        mChart.setOnChartValueSelectedListener(this);
        mChart.setDrawGridBackground(false);

        // add data
        setData();

        // get the legend (only possible after setting data)
        Legend l = mChart.getLegend();

        // modify the legend ...
         //l.setPosition(Legend.LegendPosition.LEFT_OF_CHART);
         l.setPosition(Legend.LegendPosition.ABOVE_CHART_LEFT);
        l.setForm(Legend.LegendForm.LINE);


        // enable touch gestures
        mChart.setTouchEnabled(true);

        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis leftAxis = mChart.getAxisLeft();
        // reset all limit lines to avoid overlapping lines
        leftAxis.removeAllLimitLines();
        leftAxis.setAxisMaxValue(100f);
        leftAxis.setAxisMinValue(0f);
        leftAxis.enableGridDashedLine(5f, 5f, 0f);
        leftAxis.setDrawZeroLine(false);

        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);

        mChart.getAxisRight().setEnabled(false);

        mChart.animateX(2500, Easing.EasingOption.EaseInOutQuart);

        //  dont forget to refresh the drawing
        mChart.invalidate();



        /*
        * This takes care of the Pie Chart
        * */

        PieChart pieChart = (PieChart) findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(true);

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        yvalues.add(new Entry(35f, 0));
        yvalues.add(new Entry(30f, 1));
        yvalues.add(new Entry(10f, 2));
        yvalues.add(new Entry(10f, 3));
        yvalues.add(new Entry(25f, 4));

        PieDataSet dataSet = new PieDataSet(yvalues, "");

        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("312 hours spent");
        xVals.add("13 days spent");
        xVals.add("4 Bookings");
        xVals.add("11 Ubers called");
        xVals.add("3 hotels visited");

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        pieChart.setData(data);
        pieChart.setDescription("Visit data");

        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(10f);
        pieChart.setHoleRadius(40f);
        pieChart.setCenterText("Total: #117,000");

        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.DKGRAY);
        pieChart.setOnChartValueSelectedListener(this);

        pieChart.animateXY(1400, 1400);

    }

    //Line Chart Data set
    private ArrayList<String> setXAxisValues(){
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("Sept 7");
        xVals.add("Sept 10");
        xVals.add("Sept 24");
        xVals.add("Oct 4");
        xVals.add("Oct 7");

        return xVals;
    }

    private ArrayList<Entry> setYAxisValues(){
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        yVals.add(new Entry(0, 0));
        yVals.add(new Entry(25, 1));
        yVals.add(new Entry(50.5f, 2));
        yVals.add(new Entry(50.5f, 3));
        yVals.add(new Entry(20, 4));

        return yVals;
    }

    private void setData() {
        ArrayList<String> xVals = setXAxisValues();

        ArrayList<Entry> yVals = setYAxisValues();

        LineDataSet set1;

        // create a dataset and give it a type
        set1 = new LineDataSet(yVals, "Visit Frequency (%)");

        set1.setFillAlpha(110);

        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(9f);
        set1.setDrawFilled(true);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(xVals, dataSets);

        // set data
        mChart.setData(data);

    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        Log.i("Gesture", "START, x: " + me.getX() + ", y: " + me.getY());
    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        Log.i("Gesture", "END, lastGesture: " + lastPerformedGesture);

        // un-highlight values after the gesture is finished and no single-tap
        if(lastPerformedGesture != ChartTouchListener.ChartGesture.SINGLE_TAP)
            mChart.highlightValues(null); // or highlightTouch(null) for callback to onNothingSelected(...)
    }

    @Override
    public void onChartLongPressed(MotionEvent me) {
        Log.i("LongPress", "Chart longpressed.");
    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {
        Log.i("DoubleTap", "Chart double-tapped.");
    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {
        Log.i("SingleTap", "Chart single-tapped.");
    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
        Log.i("Fling", "Chart flinged. VeloX: " + velocityX + ", VeloY: " + velocityY);
    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
        Log.i("Scale / Zoom", "ScaleX: " + scaleX + ", ScaleY: " + scaleY);
    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {
        Log.i("Translate / Move", "dX: " + dX + ", dY: " + dY);
    }


    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

        Log.i("Entry selected", e.toString());
        Log.i("LOWHIGH", "low: " + mChart.getLowestVisibleXIndex() + ", high: " + mChart.getHighestVisibleXIndex());
        Log.i("MIN MAX", "xmin: " + mChart.getXChartMin() + ", xmax: " + mChart.getXChartMax() + ", ymin: " + mChart.getYChartMin() + ", ymax: " + mChart.getYChartMax());


        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex);
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
