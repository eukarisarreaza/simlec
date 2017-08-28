package ve.gob.fundelec.simlec.Reporte.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ve.gob.fundelec.simlec.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReporteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReporteFragment extends Fragment implements ReportView{

    public ReporteFragment() {
        // Required empty public constructor
    }

    public static ReporteFragment newInstance(String param1, String param2) {
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
        View view= inflater.inflate(R.layout.fragment_report, null);


        return view;
    }

}
