package ve.gob.fundelec.simlec.ListaCallesAvenidas.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.CallesAvenidasPressenter;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.adapter.AdapterCallesAvenidas;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.adapter.OnClickCallesAvenidas;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.di.CallesAvenidasComponent;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;
import ve.gob.fundelec.simlec.lib.base.EventBus;


public class CallesAvenidasFragment extends Fragment implements CallesAvenidasView, OnClickCallesAvenidas {

    @BindView(R.id.subtitulo)
    TextView subtitulo;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.route)
    TextView route;
    @BindView(R.id.area)
    TextView area;
    @BindView(R.id.map)
    ImageButton map;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.iniciarRuta)
    TextView iniciarRuta;

    Unbinder unbinder;

    @Inject
    CallesAvenidasPressenter pressenter;
    @Inject
    AdapterCallesAvenidas adapter;
    @Inject
    EventBus eventBus;


    public CallesAvenidasFragment() {
    }

    public static CallesAvenidasFragment newInstance() {
        CallesAvenidasFragment fragment = new CallesAvenidasFragment();
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
        View view = inflater.inflate(R.layout.fragment_listados_calles, container, false);
        unbinder = ButterKnife.bind(this, view);
        setupInject();
        setupRecycler();
        setupToolbar();

        pressenter.onCreate();
        pressenter.getInfoRuta();
        pressenter.getListCalles();

        return view;
    }

    private void setupToolbar() {
        //toolbar.setBackgroundColor(getResources().getColor(R.color.opcion1_1));
        search.setVisibility(View.VISIBLE);
        subtitulo.setText(getString(R.string.calles_avenidas));
    }

    private void setupInject() {
        SimlecApplication application= (SimlecApplication)getActivity().getApplication();
        CallesAvenidasComponent component= application.getCallesAvenidasComponent(this, this);
        component.inject(this);
    }

    private void setupRecycler() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.back)
    @Override
    public void onBackPress() {
        Configuracion.back(eventBus);
    }

    @OnClick(R.id.menu)
    @Override
    public void onButtonMenu() {
        Configuracion.menu(eventBus);
    }

    @OnClick(R.id.search)
    @Override
    public void onSearch() {
        Configuracion.searh(eventBus);
    }

    @Override
    public void showInfoRuta(String nom_ruta, String area) {
        route.setText(nom_ruta);
    }

    @Override
    public void showListCalles(List<QueryCalles> callesList) {
        adapter.setList(callesList);
    }

    @Override
    public void onSelectCalle(QueryCalles calles) {
        if(iniciarRuta.getVisibility()==View.VISIBLE){
            iniciarRuta.setVisibility(View.GONE);
        }else {
            iniciarRuta.setVisibility(View.VISIBLE);
            if(calles.getCant_lect_gestionadasŗ()>0){
                iniciarRuta.setText(getString(R.string.continuar_recorrido));
            }
        }
    }

    @Override
    public void showNotify(String message) {

    }

    @Override
    public void onClickUnidadLectura(QueryCalles unidadLectura) {
        onSelectCalle(unidadLectura);
    }

    @OnClick(R.id.iniciarRuta)
    public void iniciarRuta(){
        pressenter.onClickCalle(adapter.getItem(adapter.getPosSeleccionado()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        pressenter.onDestroy();
    }


}
