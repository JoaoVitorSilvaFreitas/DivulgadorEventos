package com.example.joaovitor.divulgadoreventos.Interfaces;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.joaovitor.divulgadoreventos.R;


public class telaSplash extends AppCompatActivity {

    //Função para chamar a telaLogin.
    private void AbrirLogin(){
        Intent intent = new Intent(this,telaLogin.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);
        //Handler para adicionar delay ao exibir o logo.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // AbrirMain();
                AbrirLogin();
            }
        },2500);

    }
}
