package ve.gob.fundelec.simlec.ObjetosConexion.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.ObjetosConexion.ObjetosConexionPressenter;
import ve.gob.fundelec.simlec.ObjetosConexion.adapter.AdapterObjetosConexion;
import ve.gob.fundelec.simlec.ObjetosConexion.adapter.OnClickObjetosConexion;
import ve.gob.fundelec.simlec.ObjetosConexion.di.ObjetosConexionComponent;
import ve.gob.fundelec.simlec.ObjetosConexion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;

public class ObjetosConexionFragment extends Fragment implements ObjetosConexionView, OnClickObjetosConexion {

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
    Unbinder unbinder;

    @Inject
    ObjetosConexionPressenter pressenter;

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

        pressenter.onCreate();


        return view;
    }

    private void setupRecycler() {
        List<QueryObjetoConexion> list= new ArrayList<>();
        adapter= new AdapterObjetosConexion(list, this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void setupInject() {
        SimlecApplication application= (SimlecApplication)getActivity().getApplication();
        ObjetosConexionComponent component= application.getObjetosConexionComponent(this);
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
}
