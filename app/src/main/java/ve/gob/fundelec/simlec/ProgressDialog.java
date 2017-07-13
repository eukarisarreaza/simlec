package ve.gob.fundelec.simlec;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eukaris on 12/04/2017.
 */

public class ProgressDialog extends DialogFragment {

    @BindView(R.id.message)
    TextView message;

    public static ProgressDialog newInstance() {
        Bundle args = new Bundle();
        ProgressDialog fragment = new ProgressDialog();
        fragment.setArguments(args);
        //fragment.imagen = photo;
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogo = super.onCreateDialog(savedInstanceState);
        dialogo.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialogo.setContentView(R.layout.dialogo_progress);
        dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogo.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialogo.setCancelable(false);
        ButterKnife.bind(this, dialogo);


        return dialogo;
    }

    public void setMessage(String text){
        message.setText(text);
    }


}