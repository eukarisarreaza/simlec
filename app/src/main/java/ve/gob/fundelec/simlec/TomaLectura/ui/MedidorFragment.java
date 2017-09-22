package ve.gob.fundelec.simlec.TomaLectura.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.piotrek.customspinner.CustomSpinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;
import ve.gob.fundelec.simlec.TomaLectura.TomaLecturaPresenter;
import ve.gob.fundelec.simlec.TomaLectura.di.TomaLecturaComponent;


public class MedidorFragment extends Fragment implements TomaLecturaView {
    private static final String TAG = MedidorFragment.class.getName();

    @BindView(R.id.ruta)
    TextView ruta;
    @BindView(R.id.area)
    TextView area;
    @BindView(R.id.unidadLectura)
    TextView unidadLectura;
    @BindView(R.id.sumEnergCall1)
    TextView sumEnergCall1;
    @BindView(R.id.ptoSuministro)
    TextView ptoSuministro;
    @BindView(R.id.emplazamiento)
    TextView emplazamiento;
    @BindView(R.id.aparato)
    TextView aparato;
    @BindView(R.id.lectura1)
    TextView lectura1;
    @BindView(R.id.lectura2)
    TextView lectura2;
    @BindView(R.id.notasLectura)
    CustomSpinner notasLectura;
    @BindView(R.id.codMedidor)
    TextView codMedidor;
    @BindView(R.id.progreso)
    TextView progreso;

    Unbinder unbinder;

    @Inject
    TomaLecturaPresenter presenter;
    private String pos;

    public MedidorFragment() {
        // Required empty public constructor
    }

    public static MedidorFragment newInstance(String pos) {
        MedidorFragment fragment = new MedidorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setPos(pos);
        return fragment;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medidor, container, false);
        unbinder = ButterKnife.bind(this, view);

        setupInject();
        presenter.onCreate();
        presenter.getNotasTomaLectura();
        presenter.getInfoRuta();
        presenter.getParametrosLectura();
        setProgreso();

        return view;
    }

    private void setProgreso() {
        progreso.setText(pos);
    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getActivity().getApplication();
        TomaLecturaComponent component = application.getTomaLecturaComponent(this);
        component.inject(this);
    }

    @Override
    public void showNotaLectura(String[] data) {

        notasLectura.initializeStringValues(data, getString(R.string.spinner_hint));
        notasLectura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (!adapterView.getSelectedItem().equals(getString(R.string.spinner_hint))) {
                    String notaSelected = adapterView.getSelectedItem().toString();
                    Toast.makeText(getContext(), notaSelected, Toast.LENGTH_LONG).show();
                    Log.e(TAG, "posicion " + position);
                    presenter.grabarNota(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void showNumMedidor(String numMedidor) {
        codMedidor.setText(numMedidor);
    }

    @Override
    public void showInfoRuta(String nom_ruta, String area_t) {
        ruta.setText(nom_ruta);
        area.setText(area_t);
    }

    @Override
    public void showUnidadLecturua(String text) {
        unidadLectura.setText(text);
    }

    @Override
    public void showSumEnergCall1(String text) {
        sumEnergCall1.setText(text);
    }

    @Override
    public void showPuntoSuministro(String text) {
        ptoSuministro.setText(text);
    }

    @Override
    public void showEmplazamiento(String text) {
        emplazamiento.setText(text);
    }

    @Override
    public void showAparato(String text) {
        aparato.setText(text);
    }

    @Override
    public void showLectura1(String text) {
        lectura1.setText(text);
        lectura1.setTextColor(getContext().getResources().getColor(R.color.verde));
    }

    @Override
    public void showLectura2(String text) {
        lectura2.setText(text);
        lectura2.setTextColor(getContext().getResources().getColor(R.color.verde));
    }

    @Override
    public void setNumeroDecimalesEnteros(int decimales, int num_enteros) {
        Log.e(TAG, "decimales " + decimales + " " + num_enteros);


        lectura1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                //Log.e(TAG, "contiene punto "+s.toString().contains("."));
                if (!s.toString().contains(".") && s.toString().length() > num_enteros) {
                    lectura1.setError("sobrepasa numeros enteros");
                }

                if (s.toString().contains(".") && !s.toString().substring(s.toString().length() - 1).equals(".")) {
                    String[] parts = s.toString().split("[.]");
                    //Log.e(TAG, "cantidad de partes "+parts.length);

                    String part1 = parts[0]; // parte entera
                    String part2 = parts[1]; // parte decimal
                    if (part1.length() > num_enteros) {
                        lectura1.setError("sobrepasa numeros enteros");
                    }
                    if (part2.length() > decimales) {
                        lectura1.setError("sobrepasa numeros decimales");
                    }
                }
                lectura1.setTextColor(getResources().getColor(R.color.colorPrimary));
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });


        lectura2.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                //Log.e(TAG, "contiene punto "+s.toString().contains("."));
                if (!s.toString().contains(".") && s.toString().length() > num_enteros) {
                    lectura2.setError("sobrepasa numeros enteros");
                }
                if (s.toString().contains(".") && !s.toString().substring(s.toString().length() - 1).equals(".")) {
                    String[] parts = s.toString().split("[.]");
                    //Log.e(TAG, "cantidad de partes "+parts.length);

                    String part1 = parts[0]; // parte entera
                    String part2 = parts[1]; // parte decimal
                    if (part1.length() > num_enteros) {
                        lectura2.setError("sobrepasa numeros enteros");
                    }
                    if (part2.length() > decimales) {
                        lectura2.setError("sobrepasa numeros decimales");
                    }
                }
                lectura2.setTextColor(getResources().getColor(R.color.colorPrimary));

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });
    }

    @Override
    public void showNotaLectura(int pos) {
        notasLectura.setSelection(pos);
    }

    @Override
    public void showNotify(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccesGrabarLectura() {
        lectura1.setTextColor(getContext().getResources().getColor(R.color.verde));
        lectura2.setTextColor(getContext().getResources().getColor(R.color.verde));
        Toast.makeText(getContext(), "Lectura Grabada Satisfactoriamente!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailedGrabarLectura() {
        Toast.makeText(getContext(), "Fallo al grabar lectura!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getLectura1() {
        return lectura1.getText().toString();
    }

    @Override
    public String getLectura2() {
        return lectura2.getText().toString();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.onDestroy();
    }
}
