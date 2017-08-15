package ve.gob.fundelec.simlec.TomaLectura.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

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
    TextView retirado;
    @BindView(R.id.actual)
    EditText actual;
    Unbinder unbinder;



    public static DialogoActualizarPrecinto newInstance() {
        Bundle args = new Bundle();
        DialogoActualizarPrecinto fragment = new DialogoActualizarPrecinto();
        fragment.setArguments(args);
        //fragment.imagen = photo;
        return fragment;
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
        dismiss();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}


