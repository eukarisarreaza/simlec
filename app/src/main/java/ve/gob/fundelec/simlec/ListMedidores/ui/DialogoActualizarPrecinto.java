package ve.gob.fundelec.simlec.ListMedidores.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.R;

/**
 * Created by Eukaris on 12/04/2017.
 */

public class DialogoActualizarPrecinto extends DialogFragment {

    @BindView(R.id.retirado)
    EditText retirado;
    @BindView(R.id.actual)
    EditText actual;
    Unbinder unbinder;

    private ListenerActualizarPresinto listener;


    public static DialogoActualizarPrecinto newInstance(ListenerActualizarPresinto listener) {
        Bundle args = new Bundle();
        DialogoActualizarPrecinto fragment = new DialogoActualizarPrecinto();
        fragment.setArguments(args);
        fragment.setListener(listener);
        //fragment.imagen = photo;
        return fragment;
    }

    public void setListener(ListenerActualizarPresinto listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogo = super.onCreateDialog(savedInstanceState);
        dialogo.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialogo.setContentView(R.layout.dialogo_actualizar_precinto);
        dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogo.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        unbinder = ButterKnife.bind(this, dialogo);



        return dialogo;
    }

    @OnClick(R.id.aceptar)
    public void cerrar() {
        if(!retirado.getText().toString().isEmpty() && !actual.getText().toString().isEmpty()){
            listener.onClickGrabar(retirado.getText().toString(), actual.getText().toString());
        }else {
            Toast.makeText(getContext(), "Datos Inválidos", Toast.LENGTH_SHORT).show();
        }
        dismiss();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}


