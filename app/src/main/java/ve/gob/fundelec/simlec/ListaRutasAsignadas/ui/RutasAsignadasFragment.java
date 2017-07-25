package ve.gob.fundelec.simlec.ListaRutasAsignadas.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import ve.gob.fundelec.simlec.DataBase.entities.Ruta;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.RutasAsignadasPresenter;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.adapter.AdapterRutasAsignadas;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.adapter.OnItemClickListener;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.di.RutasAsignadasComponent;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.Main.event.MainEvent;
import ve.gob.fundelec.simlec.Main.event.RecorridoEvent;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RutasAsignadasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RutasAsignadasFragment extends Fragment implements RutasAsignadasView, OnItemClickListener {
    private static final String TAG= RutasAsignadasFragment.class.getName();
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.perfil)
    TextView perfil;
    @BindView(R.id.ultimo_inicio)
    TextView ultimoInicio;
    @BindView(R.id.version)
    TextView version;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.menu)
    ImageView menu;
    @BindView(R.id.listRutas)
    RecyclerView listRutas;
    @BindView(R.id.rutasBloquedas)
    RecyclerView rutasBloquedas;
    @BindView(R.id.nombre)
    EditText nombre;

    Unbinder unbinder;

    @Inject
    RutasAsignadasPresenter presenter;
    @Inject
    AdapterRutasAsignadas adapter;
    @Inject
    EventBus eventBus;

    public RutasAsignadasFragment() {
    }

    public static RutasAsignadasFragment newInstance() {
        RutasAsignadasFragment fragment = new RutasAsignadasFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
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
        View view = inflater.inflate(R.layout.fragment_rutas_asignadas, container, false);
        unbinder = ButterKnife.bind(this, view);
        setupInject();
        setupRecycler();
        presenter.onCreate();
        presenter.getInfoUser();
        presenter.getVersionApp();
        presenter.getListRutas();
        return view;
    }

    private void setupRecycler() {
        listRutas.setLayoutManager(new LinearLayoutManager(getContext()));
        listRutas.setAdapter(adapter);
    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getActivity().getApplication();
        RutasAsignadasComponent component = application.getRutasAsignadasComponent(this, this);
        component.inject(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.onDestroy();
    }


    @Override
    public void showInfoUser(String nombret, String perfilT) {
        perfil.setText(perfilT);
        nombre.setText(nombret);
    }

    @Override
    public void showVersionName(String version_text) {
        version.setText(version_text);
    }

    @Override
    public void showListRutasCurso(List<QueryRutas> list) {
        adapter.setList(list);

    }

    @OnClick(R.id.search)
    @Override
    public void search() {
        MainEvent event= new MainEvent();
        event.setEventType(MainEvent.onSearch);
        eventBus.post(event);
    }

    @OnClick(R.id.menu)
    @Override
    public void menu() {
        MainEvent event= new MainEvent();
        event.setEventType(MainEvent.onButtonMenu);
        eventBus.post(event);
    }

    @Override
    public void onClickRuta(QueryRutas ruta) {
        presenter.onClickRuta(ruta);
    }

    @Override
    public void onClickRutaMap(QueryRutas ruta) {
        Log.e(TAG, "map de la ruta "+ruta.getNom_ruta());
    }
}
