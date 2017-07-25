package ve.gob.fundelec.simlec.AparatoSobrante.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AparatoSobranteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AparatoSobranteFragment extends Fragment {

    public AparatoSobranteFragment() {
        // Required empty public constructor
    }

    public static AparatoSobranteFragment newInstance() {
        AparatoSobranteFragment fragment = new AparatoSobranteFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
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
        View view = inflater.inflate(R.layout.fragment_aparato_sobrante, container, false);

        return view;
    }



}
