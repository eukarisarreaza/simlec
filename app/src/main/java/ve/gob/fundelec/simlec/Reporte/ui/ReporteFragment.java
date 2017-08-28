package ve.gob.fundelec.simlec.Reporte.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReporteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class ReporteFragment extends Fragment implements ReportView{

    @BindView(R.id.subtitulo)
    TextView subtitulo;
    @BindView(R.id.toolbar)
    LinearLayout toolbar;
    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    @BindView(R.id.chart)
    PieChart chart;
    Unbinder unbinder;

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




        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.back)
    @Override
    public void onBackPress() {

    }

    @OnClick(R.id.menu)
    @Override
    public void onButtonMenu() {

    }

    @Override
    public void showListRutas() {

    }
}
