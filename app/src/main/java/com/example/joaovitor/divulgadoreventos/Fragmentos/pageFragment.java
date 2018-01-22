package com.example.joaovitor.divulgadoreventos.Fragmentos;


import android.app.ActionBar;
import android.drm.DrmStore;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joaovitor.divulgadoreventos.Fragmentos.telaMaps;
import com.example.joaovitor.divulgadoreventos.R;

public class pageFragment extends Fragment {

    TextView Txt_Teste;
    public pageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_fragment_layout,container,false);

        Txt_Teste = view.findViewById(R.id.Txt_Teste);
        Bundle bdl = getArguments();
        String Mensagem = Integer.toString(bdl.getInt("count"));
        Txt_Teste.setText("A pagina atual é " + Mensagem );
        return view;

    }

}
