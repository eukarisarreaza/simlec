package ve.gob.fundelec.simlec.AparatoSobrante.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AparatoSobranteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AparatoSobranteFragment extends Fragment implements AparatoSobranteView {

    @Inject
    EventBus eventBus;
    @BindView(R.id.subtitulo)
    TextView subtitulo;
    Unbinder unbinder;


    public AparatoSobranteFragment() {
        // Required empty public constructor
    }

    public static AparatoSobranteFragment newInstance() {
        AparatoSobranteFragment fragment = new AparatoSobranteFragment();
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
        View view = inflater.inflate(R.layout.fragment_aparato_sobrante, container, false);
        unbinder = ButterKnife.bind(this, view);

        setToolbar();

        return view;
    }

    private void setToolbar() {
        subtitulo.setText(getString(R.string.aparato_sobrante));
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
        unbinder.unbind();

    }
}
