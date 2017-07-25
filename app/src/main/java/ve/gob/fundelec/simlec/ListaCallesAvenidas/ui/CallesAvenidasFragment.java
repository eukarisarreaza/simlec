package ve.gob.fundelec.simlec.ListaCallesAvenidas.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ve.gob.fundelec.simlec.R;


public class CallesAvenidasFragment extends Fragment {

    public CallesAvenidasFragment() {
        // Required empty public constructor
    }

    public static CallesAvenidasFragment newInstance() {
        CallesAvenidasFragment fragment = new CallesAvenidasFragment();
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
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
