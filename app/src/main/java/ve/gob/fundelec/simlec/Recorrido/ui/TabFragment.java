package ve.gob.fundelec.simlec.Recorrido.ui;


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
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.Recorrido.RecorridoPressenter;
import ve.gob.fundelec.simlec.Recorrido.di.RecorridoComponent;
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

    @OnClick(R.id.next_button)
    @Override
    public void next() {

    }

    @OnClick(R.id.prev_button)
    @Override
    public void prev() {

    }

    @OnClick(R.id.next_medidor)
    @Override
    public void sigFragment() {

    }

    @OnClick(R.id.prev_medidor)
    @Override
    public void prevFragment() {

    }

    @Override
    public void search() {
        Configuracion.searh(eventBus);
    }

    @Override
    public void menu() {
        Configuracion.menu(eventBus);
    }

    @Override
    public void letter_p() {
        Configuracion.letterP(eventBus);
    }

    @Override
    public void letter_s() {
        Configuracion.letterS(eventBus);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        pressenter.onDestroy();
    }
}
