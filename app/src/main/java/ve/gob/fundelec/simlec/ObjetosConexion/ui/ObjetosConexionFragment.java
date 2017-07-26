package ve.gob.fundelec.simlec.ObjetosConexion.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ve.gob.fundelec.simlec.R;

public class ObjetosConexionFragment extends Fragment {


    public ObjetosConexionFragment() {
        // Required empty public constructor
    }


    public static ObjetosConexionFragment newInstance() {
        ObjetosConexionFragment fragment = new ObjetosConexionFragment();
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
        View view = inflater.inflate(R.layout.fragment_objetos_conexion, container, false);



        return view;
    }

}
