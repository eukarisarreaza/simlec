package ve.gob.fundelec.simlec.Bateria;


import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.R;


public class BateriaFragment extends Fragment {


    @BindView(R.id.progress)
    RoundCornerProgressBar progress;
    @BindView(R.id.progresoPorc)
    TextView progresoPorc;
    @BindView(R.id.subtitulo)
    TextView subtitulo;
    @BindView(R.id.toolbar)
    LinearLayout toolbar;
    Unbinder unbinder;



    public BateriaFragment() {
        // Required empty public constructor
    }

    public static BateriaFragment newInstance() {
        BateriaFragment fragment = new BateriaFragment();
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
        View view = inflater.inflate(R.layout.fragment_bateria, null);
        unbinder = ButterKnife.bind(this, view);
        progress.setProgress(cargaBateria());
        progresoPorc.setText(String.valueOf(cargaBateria()) + " %");
        subtitulo.setText(R.string.bateria);
        toolbar.setBackgroundColor(getResources().getColor(R.color.opcion2_3));

        return view;
    }

    public int cargaBateria() {
        try {
            IntentFilter batIntentFilter =
                    new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent battery = getContext().registerReceiver(null, batIntentFilter);

            int nivelBateria = battery.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            return nivelBateria;
        } catch (Exception e) {
            Toast.makeText(getContext(), "Error al obtener estado de la batería", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void onClickMenu(){

    }

    public void onClickBack(){

    }
}
