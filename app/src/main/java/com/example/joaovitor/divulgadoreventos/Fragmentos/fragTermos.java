package com.example.joaovitor.divulgadoreventos.Fragmentos;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.joaovitor.divulgadoreventos.Interfaces.telaMain;
import com.example.joaovitor.divulgadoreventos.R;


public class fragTermos extends Fragment {

    public fragTermos(){

    }

    public void abrirCadastro(){
        Intent intent = new Intent(getActivity(),telaMain.class);
        startActivity(intent);
    }

    private Button Btn_Concordo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Btn_Concordo = (Button)getView().findViewById(R.id.Btn_Confirmar);

        Btn_Concordo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCadastro();
            }
        });

    }
}
