package com.example.joaovitor.divulgadoreventos.Fragmentos;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joaovitor.divulgadoreventos.Interfaces.telaConfiguracoes;
import com.example.joaovitor.divulgadoreventos.R;

public class fragCards extends Fragment {

    private void Configs() {
        Intent itconfig = new Intent(getActivity(), telaConfiguracoes.class);
        startActivity(itconfig);
    }

    public fragCards(){

    }

    private CardView Cview_c1l1;
    private CardView Cview_c2l1;
    private CardView Cview_c1l2;
    private CardView Cview_c2l2;
    private CardView Cview_c1l3;
    private CardView Cview_c2l3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_cards_layout,container,false);

        Cview_c1l1 = (CardView)view.findViewById(R.id.Cview_c1l1);
        Cview_c2l1 = (CardView)view.findViewById(R.id.Cview_c2l1);
        Cview_c1l2 = (CardView)view.findViewById(R.id.Cview_c1l2);
        Cview_c2l2 = (CardView)view.findViewById(R.id.Cview_c2l2);
        Cview_c1l3 = (CardView)view.findViewById(R.id.Cview_c1l3);
        Cview_c2l3 = (CardView)view.findViewById(R.id.Cview_c2l3);

        Cview_c2l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configs();
            }
        });

        setRetainInstance(true);
        return view;
    }

    public boolean onIsMultiPane() {
        return isXLargeTablet(getContext());
    }

    private static boolean isXLargeTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }



}
