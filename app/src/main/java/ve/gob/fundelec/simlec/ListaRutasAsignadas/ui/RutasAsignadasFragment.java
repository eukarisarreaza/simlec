package ve.gob.fundelec.simlec.ListaRutasAsignadas.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import ve.gob.fundelec.simlec.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RutasAsignadasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RutasAsignadasFragment extends Fragment {

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
    Unbinder unbinder;




    public RutasAsignadasFragment() {
    }

    public static RutasAsignadasFragment newInstance(String param1, String param2) {
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




        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
