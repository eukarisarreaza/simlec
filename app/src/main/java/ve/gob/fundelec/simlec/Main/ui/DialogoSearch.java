package ve.gob.fundelec.simlec.Main.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores;
import ve.gob.fundelec.simlec.R;

/**
 * Created by fundelec on 24/08/17.
 */

public class DialogoSearch extends DialogFragment implements ListenerMedidores {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.editText)
    EditText editText;
    Unbinder unbinder;


    List<Medidores> medidoresList;

    AdapterSearch adapterSearch;



    public static DialogoSearch newInstance() {
        Bundle args = new Bundle();
        DialogoSearch fragment = new DialogoSearch();
        fragment.setArguments(args);
        //fragment.imagen = photo;
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogo = super.onCreateDialog(savedInstanceState);
        dialogo.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialogo.setContentView(R.layout.dialogo_search);
        dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogo.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialogo.setCancelable(false);
        unbinder = ButterKnife.bind(this, dialogo);

        adapterSearch = new AdapterSearch(new ArrayList<Medidores>(), this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapterSearch);

        //searchView.requestFocus(View.FOCUS_RIGHT);
        setListMedidores();
        setSearchView();


        return dialogo;
    }

    private void setListMedidores() {
        medidoresList = new Select()
                .from(Medidores.class)
                .queryList();
    }



    private void setSearchView() {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                setRecycler(s.toString());
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public void setRecycler(String query) {
        ///NUMERO DE MEDIDOR  U OBJETO DE CONEXION
        List<Medidores> list = new ArrayList<>();

        for (Medidores medidores : medidoresList) {
            if (medidores.getNumero().contains(query)) {
                list.add(medidores);
            }
        }
        adapterSearch.setList(list);


    }

    @Override
    public void onClickMedidor(Medidores medidor) {

    }

}
