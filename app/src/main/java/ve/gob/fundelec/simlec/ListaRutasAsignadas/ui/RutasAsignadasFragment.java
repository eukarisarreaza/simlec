package ve.gob.fundelec.simlec.ListaRutasAsignadas.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import ve.gob.fundelec.simlec.DataBase.entities.Ruta;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.RutasAsignadasPresenter;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.di.RutasAsignadasComponent;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RutasAsignadasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RutasAsignadasFragment extends Fragment implements RutasAsignadasView {

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
        presenter.onCreate();
        presenter.getInfoUser();
        presenter.getVersionApp();
        presenter.getListRutas();
        return view;
    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getActivity().getApplication();
        RutasAsignadasComponent component = application.getRutasAsignadasComponent(this);
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
    public void showVersionName(String version) {

    }

    @Override
    public void showListRutasCurso(List<Ruta> list) {

    }
}
