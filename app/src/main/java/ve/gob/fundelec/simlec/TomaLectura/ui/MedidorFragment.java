package ve.gob.fundelec.simlec.TomaLectura.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.piotrek.customspinner.CustomSpinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;
import ve.gob.fundelec.simlec.TomaLectura.TomaLecturaPresenter;
import ve.gob.fundelec.simlec.TomaLectura.di.TomaLecturaComponent;


public class MedidorFragment extends Fragment implements TomaLecturaView{
    private static final String TAG= MedidorFragment.class.getName();

    @BindView(R.id.ruta)
    TextView ruta;
    @BindView(R.id.area)
    TextView area;
    @BindView(R.id.unidadLectura)
    TextView unidadLectura;
    @BindView(R.id.sumEnergCall1)
    TextView sumEnergCall1;
    @BindView(R.id.ptoSuministro)
    TextView ptoSuministro;
    @BindView(R.id.emplazamiento)
    TextView emplazamiento;
    @BindView(R.id.aparato)
    TextView aparato;
    @BindView(R.id.lectura1)
    EditText lectura1;
    @BindView(R.id.lectura2)
    EditText lectura2;
    @BindView(R.id.notasLectura)
    CustomSpinner notasLectura;
    Unbinder unbinder;

    @Inject
    TomaLecturaPresenter presenter;


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
        unbinder = ButterKnife.bind(this, view);

        setupInject();
        presenter.onCreate();
        presenter.getNotasTomaLectura();

        return view;
    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getActivity().getApplication();
        TomaLecturaComponent component = application.getTomaLecturaComponent(this);
        component.inject(this);
    }


    @Override
    public void showNotaLectura(String[] data) {

        notasLectura.initializeStringValues(data, getString(R.string.spinner_hint));
        notasLectura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (!adapterView.getSelectedItem().equals(getString(R.string.spinner_hint))) {
                    String notaSelected = adapterView.getSelectedItem().toString();
                    Toast.makeText(getContext(), notaSelected, Toast.LENGTH_LONG).show();
                    Log.e(TAG, "posicion " + position);
                    presenter.grabarNota(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void showInfoRuta(String nom_ruta, String area) {



    }

    @Override
    public void showNotify(String message) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.onDestroy();
    }
}
