package ve.gob.fundelec.simlec.TomaLectura.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;
import ve.gob.fundelec.simlec.TomaLectura.di.TomaLecturaComponent;


public class MedidorFragment extends Fragment implements TomaLecturaView{





    public MedidorFragment() {
        // Required empty public constructor
    }

    public static MedidorFragment newInstance() {
        MedidorFragment fragment = new MedidorFragment();
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
        View view=inflater.inflate(R.layout.fragment_medidor, container, false);

        setupInject();


        return view;
    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getActivity().getApplication();
        TomaLecturaComponent component = application.getTomaLecturaComponent(this);
        component.inject(this);
    }


    @Override
    public void showNotaLectura(String[] data) {

    }

    @Override
    public void showInfoRuta(String nom_ruta, String area) {



    }

    @Override
    public void showNotify(String message) {

    }
}
