package ve.gob.fundelec.simlec.Reporte.ui;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.Reporte.ReportPresenter;
import ve.gob.fundelec.simlec.Reporte.adapter.ExpandableListAdapter;
import ve.gob.fundelec.simlec.Reporte.di.ReportComponent;
import ve.gob.fundelec.simlec.SimlecApplication;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReporteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class ReporteFragment extends Fragment implements ReportView {
    private static final String TAG = ReporteFragment.class.getName();

    @BindView(R.id.subtitulo)
    TextView subtitulo;
    @BindView(R.id.toolbar)
    LinearLayout toolbar;
    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    @BindView(R.id.chart)
    PieChart chart;
    Unbinder unbinder;

    @Inject
    ReportPresenter presenter;
    @Inject
    EventBus eventBus;

    ExpandableListAdapter adapter;
    @BindView(R.id.scrollReporte)
    ScrollView scrollReporte;

    @BindView(R.id.total_ordenes_lectura)
    TextView totalOrdenesLectura;
    @BindView(R.id.total_ordenes_leidas)
    TextView totalOrdenesLeidas;
    @BindView(R.id.total_ordenes_faltantes)
    TextView totalOrdenesFaltantes;
    @BindView(R.id.porcentaje_realizado)
    TextView porcentajeRealizado;
    @BindView(R.id.porcentaje_por_leer)
    TextView porcentajePorLeer;
    @BindView(R.id.total_objetos_conexion)
    TextView totalObjetosConexion;
    @BindView(R.id.objetos_conexion_pendiente)
    TextView objetosConexionPendiente;

    public ReporteFragment() {
        // Required empty public constructor
    }

    public static ReporteFragment newInstance() {
        ReporteFragment fragment = new ReporteFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, null);
        unbinder = ButterKnife.bind(this, view);
        toolbar.setBackgroundColor(getResources().getColor(R.color.opcion1_4));
        subtitulo.setText(R.string.reporte);

        setupInject();
        presenter.onCreate();
        presenter.getListRutas();


        return view;
    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getActivity().getApplication();
        ReportComponent component = application.getReportComponent(this);
        component.inject(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.onDestroy();
    }

    @OnClick(R.id.back)
    @Override
    public void onBackPress() {
        Configuracion.back(eventBus);
    }

    @OnClick(R.id.menu)
    @Override
    public void onButtonMenu() {
        Configuracion.menu(eventBus);
    }

    @Override
    public void showListRutas(List<String> header, HashMap<String, List<QueryCalles>> listDataChild) {
        adapter = new ExpandableListAdapter(getContext(), header, listDataChild);
        expandableListView.setAdapter(adapter);        // setting list adapter
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            QueryCalles calle = adapter.getChild(groupPosition, childPosition);
            Log.e(TAG, "calle " + calle.toString());
            expandableListView.setVisibility(View.GONE);
            scrollReporte.setVisibility(View.VISIBLE);
            presenter.onSelectCalle(calle);
            return false;
        });
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showReport(float[] yData) {

        Description description = new Description();
        description.setText("   ");
        chart.setDescription(description);

        // configure pie chart
        chart.setUsePercentValues(true);

        // enable hole and configure
        chart.setDrawHoleEnabled(true);
        chart.setHoleRadius(7);
        chart.setTransparentCircleRadius(10);

        // enable rotation of the chart by touch
        chart.setRotationAngle(0);
        chart.setRotationEnabled(true);

        // set a chart value selected listener
        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });

        // add data
        addData(yData);

        // customize legends
        Legend l = chart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);
    }

    @Override
    public void showDetailsReport(int total_ord_lect, int total_ord_leidas, int ordenes_faltantes,
                                  float porcentaje_realiz, float porcentaje_x_leer,
                                  int total_obj_conexion, int objetos_conexion_pendiente) {

        this.totalOrdenesLectura.setText(String.valueOf(total_ord_lect));
        this.totalOrdenesLeidas.setText(String.valueOf(total_ord_leidas));
        this.totalOrdenesFaltantes.setText(String.valueOf(ordenes_faltantes));
        this.porcentajeRealizado.setText(String.valueOf(porcentaje_realiz));
        this.porcentajePorLeer.setText(String.valueOf(porcentaje_x_leer));
        this.totalObjetosConexion.setText(String.valueOf(total_obj_conexion));
        this.objetosConexionPendiente.setText(String.valueOf(objetos_conexion_pendiente));
    }


    private void addData(float[] yData) {
        String[] xData = {"LEIDO", "NO LEIDO",};

        ArrayList<PieEntry> yVals1 = new ArrayList<PieEntry>();

        for (int i = 0; i < yData.length; i++)
            yVals1.add(new PieEntry(yData[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xData.length; i++)
            xVals.add(xData[i]);

        // create pie data set
        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);

        // add many colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);

        // instantiate pie data object now
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);

        chart.setData(data);

        // undo all highlights
        chart.highlightValues(null);

        // update pie chart
        chart.invalidate();
    }


}
