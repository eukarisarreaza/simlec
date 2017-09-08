package ve.gob.fundelec.simlec.Campaña.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.Campaña.CampanaPresenter;
import ve.gob.fundelec.simlec.Campaña.di.CampanaComponent;
import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;
import ve.gob.fundelec.simlec.lib.base.EventBus;


public class CampanaFragment extends Fragment implements CampanaView {


    @Inject
    EventBus eventBus;
    @Inject
    CampanaPresenter presenter;
    @BindView(R.id.editSearch)
    EditText editSearch;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.codigo)
    TextView codigo;
    @BindView(R.id.objetoConexion)
    EditText objetoConexion;
    @BindView(R.id.direccion)
    EditText direccion;
    @BindView(R.id.layoutInfo)
    LinearLayout layoutInfo;
    Unbinder unbinder;
    @BindView(R.id.actualizar)
    TextView actualizar;


    public CampanaFragment() {
        // Required empty public constructor
    }

    public static CampanaFragment newInstance() {
        CampanaFragment fragment = new CampanaFragment();
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
        View view = inflater.inflate(R.layout.fragment_campana, container, false);
        unbinder = ButterKnife.bind(this, view);

        setToolbar();
        setupInject();
        presenter.onCreate();

        return view;
    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getActivity().getApplication();
        CampanaComponent component = application.getCampanaComponent(this);
        component.inject(this);
    }

    private void setToolbar() {
        //toolbar.setBackgroundColor(getContext().getResources().getColor(R.color.opcion1_3));
        recyclerView.setVisibility(View.VISIBLE);
        actualizar.setVisibility(View.GONE);
        layoutInfo.setVisibility(View.GONE);

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
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
        unbinder.unbind();
    }



}
