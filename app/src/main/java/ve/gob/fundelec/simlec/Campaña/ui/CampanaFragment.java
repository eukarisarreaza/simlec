package ve.gob.fundelec.simlec.Campaña.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ve.gob.fundelec.simlec.R;


public class CampanaFragment extends Fragment {

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

        return inflater.inflate(R.layout.fragment_campana, container, false);
    }

}
