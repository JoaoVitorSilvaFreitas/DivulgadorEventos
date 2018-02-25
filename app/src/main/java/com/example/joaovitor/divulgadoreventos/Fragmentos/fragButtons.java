package com.example.joaovitor.divulgadoreventos.Fragmentos;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.joaovitor.divulgadoreventos.Interfaces.telaConfiguracoes;
import com.example.joaovitor.divulgadoreventos.R;

public class fragButtons extends android.support.v4.app.Fragment{

    private void Configs() {
        Intent itconfig = new Intent(getActivity(), telaConfiguracoes.class);
        startActivity(itconfig);
    }

    public fragButtons(){

    }

    private Fragment fragment;
    private ImageView Img_Cultura;
    private ImageView Img_Esportes;
    private ImageView Img_Alimenticios;
    private ImageView Img_Musica;
    private ImageView Img_Gerais;
    private ImageView Img_Configs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_buttons_layout,container,false);

        Img_Configs = (ImageView) view.findViewById(R.id.Img_Configs);
        Img_Gerais = (ImageView) view.findViewById(R.id.Img_Gerais);
        Img_Musica = (ImageView) view.findViewById(R.id.Img_Musica);
        Img_Alimenticios = (ImageView) view.findViewById(R.id.Img_Alimenticios);
        Img_Esportes = (ImageView) view.findViewById(R.id.Img_Esportes);
        Img_Cultura = (ImageView) view.findViewById(R.id.Img_Cultura);

        Img_Configs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configs();
            }
        });


        setRetainInstance(true);
        return view;
    }

}
