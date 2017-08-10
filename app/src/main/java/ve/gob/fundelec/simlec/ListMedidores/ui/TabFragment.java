package ve.gob.fundelec.simlec.ListMedidores.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.LecturaGestionar.ui.LecturaGestionarFragment;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.ListMedidores.RecorridoPressenter;
import ve.gob.fundelec.simlec.ListMedidores.di.RecorridoComponent;
import ve.gob.fundelec.simlec.SimlecApplication;
import ve.gob.fundelec.simlec.lib.base.EventBus;

public class TabFragment extends Fragment implements RecorridoView {

    @BindView(R.id.subtitulo)
    TextView subtitulo;
    @BindView(R.id.letter_s)
    ImageView letterS;
    @BindView(R.id.letter_p)
    ImageView letterP;
    @BindView(R.id.search)
    ImageView search;


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

        return view;
    }

    private void setupInject() {
        SimlecApplication application=(SimlecApplication)getActivity().getApplication();
        RecorridoComponent component= application.getRecorridoComponent(this);
        component.inject(this);
    }

    private void setupToolbar() {
        letterS.setVisibility(View.VISIBLE);
        letterP.setVisibility(View.VISIBLE);
        search.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNombreObjConexion(String nombre) {
        subtitulo.setText(nombre);
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
                .replace(R.id.frameMedidor, LecturaGestionarFragment.newInstance())
                .commit();
    }

    @OnClick(R.id.next_button)
    @Override
    public void nextMedidor() {

    }

    @OnClick(R.id.prev_button)
    @Override
    public void prevMedidor() {

    }
    @OnClick(R.id.next_objeto)
    @Override
    public void sigObjetoConexion() {

    }

    @OnClick(R.id.prev_objeto)
    @Override
    public void prevObjetoConexion() {

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
        Configuracion.letterP(eventBus);
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
}
