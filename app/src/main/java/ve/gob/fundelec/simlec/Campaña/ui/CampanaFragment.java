package ve.gob.fundelec.simlec.Campaña.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.Campaña.CampanaPresenter;
import ve.gob.fundelec.simlec.Campaña.di.CampanaComponent;
import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores;
import ve.gob.fundelec.simlec.Main.ui.AdapterSearch;
import ve.gob.fundelec.simlec.Main.ui.ListenerMedidores;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;
import ve.gob.fundelec.simlec.lib.base.EventBus;


public class CampanaFragment extends Fragment implements CampanaView, ListenerMedidores {

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
    @BindView(R.id.actualizar)
    TextView actualizar;
    Unbinder unbinder;

    @Inject
    EventBus eventBus;
    @Inject
    CampanaPresenter presenter;


    AdapterSearch adapterSearch;

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
        setupSearch();
        setupRecycler();
        presenter.onCreate();

        return view;
    }

    private void setupRecycler() {
        adapterSearch = new AdapterSearch(new ArrayList<Medidores>(), this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapterSearch);
    }

    private void setupSearch() {
        editSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty())
                    setRecycler(s.toString());
            }
        });

    }
    public void setRecycler(String recycler) {
        presenter.getListMedidores(recycler);
    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getActivity().getApplication();
        CampanaComponent component = application.getCampanaComponent(this);
        component.inject(this);
    }

    private void setToolbar() {
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

    @Override
    public void showListMedidores(List<Medidores> list) {
        adapterSearch.setList(list);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
        unbinder.unbind();
    }


    @Override
    public void onClickMedidor(Medidores medidor) {
        recyclerView.setVisibility(View.GONE);
        actualizar.setVisibility(View.VISIBLE);
        layoutInfo.setVisibility(View.VISIBLE);

        codigo.setText(medidor.getNumero());
        direccion.setText("");
        objetoConexion.setText("");

    }
}
