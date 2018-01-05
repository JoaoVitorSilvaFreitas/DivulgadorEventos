package com.example.joaovitor.divulgadoreventos.Interfaces;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.joaovitor.divulgadoreventos.R;


public class telaSplash extends AppCompatActivity {

    private void AbrirMain(){
        Intent intent = new Intent(this,telaMain.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AbrirMain();
            }
        },2000);

    }
}
