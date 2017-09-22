package ve.gob.fundelec.simlec.LecturaGestionar.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.piotrek.customspinner.CustomSpinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.LecturaGestionar.LecturaGestionarPresenter;
import ve.gob.fundelec.simlec.LecturaGestionar.di.LecturaGestionarComponent;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;

public class LecturaGestionarFragment extends Fragment implements LecturaGestionarView {
    private static final String TAG = LecturaGestionarFragment.class.getName();
    @BindView(R.id.notasLectura)
    CustomSpinner notasLectura;
    @BindView(R.id.nom_ruta)
    TextView nomRuta;
    @BindView(R.id.area)
    TextView area;
    @BindView(R.id.municipio)
    TextView municipio;
    @BindView(R.id.parroquia)
    TextView parroquia;
    @BindView(R.id.urbanizacion)
    TextView urbanizacion;
    @BindView(R.id.calle)
    TextView calle;
    @BindView(R.id.unidadLectura)
    TextView unidadLectura;
    @BindView(R.id.objConexion)
    TextView objConexion;
    @BindView(R.id.codObjetoConexion)
    TextView codObjetoConexion;
    @BindView(R.id.orden)
    TextView orden;

    Unbinder unbinder;

    @Inject
    LecturaGestionarPresenter presenter;
    private String pos;


    public LecturaGestionarFragment() {
        // Required empty public constructor
    }

    public static LecturaGestionarFragment newInstance(String pos) {
        LecturaGestionarFragment fragment = new LecturaGestionarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setPos(pos);
        return fragment;
    }


    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lectura_gestionar, container, false);
        unbinder = ButterKnife.bind(this, view);
        setupInject();
        presenter.onCreate();
        presenter.getListNotasLecturas();
        showPos();

        return view;
    }

    private void showPos() {
        orden.setText(pos);
    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getActivity().getApplication();
        LecturaGestionarComponent component = application.getLecturaGestionarComponent(this);
        component.inject(this);
    }

    @Override
    public void showListNotas(String[] data) {

        notasLectura.initializeStringValues(data, getString(R.string.spinner_hint));
        notasLectura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (!adapterView.getSelectedItem().equals(getString(R.string.spinner_hint))) {
                    String notaSelected = adapterView.getSelectedItem().toString();
                    Toast.makeText(getContext(), notaSelected, Toast.LENGTH_LONG).show();
                    Log.e(TAG, "posicion " + position);
                    presenter.grabarNotaUnidadLectura(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void showNotify(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInfoRuta(String nom_ruta, String area_t) {
        nomRuta.setText(nom_ruta);
        area.setText(area_t);
    }

    @Override
    public void showUnidadLectura(String unidad_lectura) {
        unidadLectura.setText(unidad_lectura);
    }

    @Override
    public void showObjetoConexion(String objConexion_t) {
        objConexion.setText(objConexion_t);
    }

    @Override
    public void showNotaLectura(int pos) {
        notasLectura.setSelection(pos);
    }

    @Override
    public void showCodObjetoConexion(String objConexion) {
        codObjetoConexion.setText("Cód. Obj. Conexión Actual: "+objConexion);
    }

    @Override
    public void showDireccion(String municipio_t, String parroquia_t, String urbanizacion_t, String calle_t) {
        municipio.setText(municipio_t);
        parroquia.setText(parroquia_t);
        urbanizacion.setText(urbanizacion_t);
        calle.setText(calle_t);
    }

    @OnClick(R.id.selectObjConexion)
    @Override
    public void onSelectObjeto() {
        presenter.onSelectObjeto();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.onDestroy();
    }
}
