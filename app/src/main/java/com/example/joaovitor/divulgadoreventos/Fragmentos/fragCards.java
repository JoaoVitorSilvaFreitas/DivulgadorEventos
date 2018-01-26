package com.example.joaovitor.divulgadoreventos.Fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joaovitor.divulgadoreventos.R;

public class fragCards extends Fragment {

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
        Cview_c1l1 = (CardView)getActivity().findViewById(R.id.Cview_c1l1);
        Cview_c2l1 = (CardView)getActivity().findViewById(R.id.Cview_c2l1);
        Cview_c1l2 = (CardView)getActivity().findViewById(R.id.Cview_c1l2);
        Cview_c2l2 = (CardView)getActivity().findViewById(R.id.Cview_c2l2);
        Cview_c1l3 = (CardView)getActivity().findViewById(R.id.Cview_c1l3);
        Cview_c2l3 = (CardView)getActivity().findViewById(R.id.Cview_c2l3);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_cards_layout,container,false);
        setRetainInstance(true);
        return view;
    }


}
