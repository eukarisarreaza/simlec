package ve.gob.fundelec.simlec.ListadoCentrosMedicion.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.ObjetosConexionPressenter;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.adapter.AdapterObjetosConexion;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.adapter.OnClickObjetosConexion;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.di.ObjetosConexionComponent;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;
import ve.gob.fundelec.simlec.lib.base.EventBus;

public class ObjetosConexionFragment extends Fragment
        implements ObjetosConexionView, OnClickObjetosConexion {

    @BindView(R.id.subtitulo)
    TextView subtitulo;
    @BindView(R.id.route)
    TextView route;
    @BindView(R.id.area)
    TextView area;
    @BindView(R.id.unidadLectura)
    TextView unidadLectura;
    @BindView(R.id.progreso)
    TextView progreso;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.search)
    ImageView search;
    Unbinder unbinder;

    @Inject
    ObjetosConexionPressenter pressenter;
    @Inject
    EventBus eventBus;

    AdapterObjetosConexion adapter;


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
        unbinder = ButterKnife.bind(this, view);
        setupInject();
        setupRecycler();
        setupToolbar();

        pressenter.onCreate();
        pressenter.getInfoRuta();
        pressenter.getListObjetosConexion();

        return view;
    }

    private void setupToolbar() {
        /** MOSTRAR ICONO BUSCAR  */
        search.setVisibility(View.VISIBLE);
        subtitulo.setText(R.string.lista_de_centros);
    }

    private void setupRecycler() {
        List<QueryObjetoConexion> list = new ArrayList<>();
        adapter = new AdapterObjetosConexion(list, this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getActivity().getApplication();
        ObjetosConexionComponent component = application.getObjetosConexionComponent(this);
        component.inject(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        pressenter.onDestroy();
    }

    @Override
    public void onClickObjetosConexion(QueryObjetoConexion objetoConexion) {
        pressenter.onSelectObjeto(objetoConexion);
    }

    @Override
    public void showListObjetosConexion(List<QueryObjetoConexion> list) {
        adapter.setList(list);
    }

    @Override
    public void showInfoRuta(String ruta, String area) {
        route.setText(ruta);
    }

    @Override
    public void showInfoCalle(String nom_calle, String avance) {
        unidadLectura.setText(nom_calle);
        progreso.setText(avance);
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

    @OnClick(R.id.back)
    @Override
    public void back() {
        Configuracion.back(eventBus);
    }
}
