package com.example.joaovitor.divulgadoreventos.Fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joaovitor.divulgadoreventos.R;

public class pageFragment extends Fragment {

    public pageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_fragment_layout,container,false);
        setRetainInstance(true);
        return view;
    }

}
