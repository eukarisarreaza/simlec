package ve.gob.fundelec.simlec.ListMedidores.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.LecturaGestionar.ui.LecturaGestionarFragment;
import ve.gob.fundelec.simlec.ListMedidores.RecorridoPressenter;
import ve.gob.fundelec.simlec.ListMedidores.di.RecorridoComponent;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;
import ve.gob.fundelec.simlec.TomaLectura.ui.MedidorFragment;
import ve.gob.fundelec.simlec.lib.base.EventBus;

public class TabFragment extends Fragment implements RecorridoView, ListenerActualizarPresinto {

    @BindView(R.id.subtitulo)
    TextView subtitulo;
    @BindView(R.id.letter_s)
    ImageView letterS;
    @BindView(R.id.letter_p)
    ImageView letterP;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.prev_objeto)
    ImageButton prevObjeto;
    @BindView(R.id.prev_button)
    Button prevButton;
    @BindView(R.id.next_button)
    Button nextButton;
    @BindView(R.id.next_objeto)
    ImageButton nextObjeto;



    Unbinder unbinder;

    @Inject
    RecorridoPressenter pressenter;
    @Inject
    EventBus eventBus;



    public TabFragment() {
        // Required empty public constructor
    }

    public static TabFragment newInstance() {
        TabFragment fragment = new TabFragment();
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
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        unbinder = ButterKnife.bind(this, view);
        setupToolbar();
        setupInject();

        pressenter.onCreate();
        pressenter.registrarFragment();
        pressenter.getFragmentInicio();

        ocultarBotonesSiguinteMedidor();

        return view;
    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getActivity().getApplication();
        RecorridoComponent component = application.getRecorridoComponent(this);
        component.inject(this);
    }

    private void setupToolbar() {
        letterS.setVisibility(View.VISIBLE);
        letterP.setVisibility(View.VISIBLE);
        search.setVisibility(View.VISIBLE);
        subtitulo.setText(R.string.medidor);
    }

    @Override
    public void lecturaGestionar() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameMedidor, LecturaGestionarFragment.newInstance())
                .commit();
    }

    @Override
    public void valorLectura() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameMedidor, MedidorFragment.newInstance())
                .commit();
    }

    @Override
    public void showNotify(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ocultarBotonesSiguienteObjConexion() {
        nextObjeto.setVisibility(View.GONE);
        prevObjeto.setVisibility(View.GONE);
    }

    @Override
    public void ocultarBotonesSiguinteMedidor() {
        nextButton.setVisibility(View.GONE);
        prevButton.setVisibility(View.GONE);
    }

    @Override
    public void mostrarBotonesSiguienteObjConexion() {
        nextObjeto.setVisibility(View.VISIBLE);
        prevObjeto.setVisibility(View.VISIBLE);
    }

    @Override
    public void mostrarBotonesSiguinteMedidor() {
        nextButton.setVisibility(View.VISIBLE);
        prevButton.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.next_button)
    @Override
    public void nextMedidor() {
        pressenter.proximoMedidor();
    }

    @OnClick(R.id.prev_button)
    @Override
    public void prevMedidor() {
        pressenter.anteriorMedidor();
    }

    @OnClick(R.id.buttomSave)
    @Override
    public void saveLectrura() {
        pressenter.saveLecrura();
    }

    @OnClick(R.id.next_objeto)
    @Override
    public void sigObjetoConexion() {
        pressenter.proximoObjetoConexion();
    }

    @OnClick(R.id.prev_objeto)
    @Override
    public void prevObjetoConexion() {
        pressenter.anteriorObjetoConexion();
    }

    @Override
    public void dialogoActualizarPresinto(String retirado) {

        DialogoActualizarPrecinto dialogo = DialogoActualizarPrecinto.newInstance(this, retirado);
        dialogo.show(getFragmentManager(), "");

    }


    @OnClick(R.id.search)
    @Override
    public void search() {
        Configuracion.searh(eventBus);
    }

    @OnClick(R.id.menu)
    @Override
    public void menu() {
        Configuracion.menu(eventBus);
    }

    @OnClick(R.id.letter_p)
    @Override
    public void letter_p() {
        pressenter.selectLetterP();
    }

    @OnClick(R.id.letter_s)
    @Override
    public void letter_s() {
        Configuracion.letterS(eventBus);
    }

    @OnClick(R.id.back)
    @Override
    public void back() {
        Configuracion.back(eventBus);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        pressenter.onDestroy();
    }

    @Override
    public void onClickGrabar(String retirado, String actual) {
        pressenter.actualizarPresinto(retirado, actual);
    }
}
