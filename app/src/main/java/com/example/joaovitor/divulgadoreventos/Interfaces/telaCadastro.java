package com.example.joaovitor.divulgadoreventos.Interfaces;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.joaovitor.divulgadoreventos.Fragmentos.fragTermos;
import com.example.joaovitor.divulgadoreventos.R;

public class telaCadastro extends AppCompatActivity {

    private boolean cancel = false;
    private View focusView = null;
    private EditText Txt_Nome;
    private EditText Txt_Sobrenome;
    private EditText Txt_Email;
    private EditText Txt_Senha;
    private Button Btn_FacebookCadastro;
    private Button Btn_Cadastro;
    private Button Btn_Termos;


    public void abrirLogin() {
        Intent intent = new Intent(this, telaLogin.class);
        startActivity(intent);
        finish();
    }

    public void abrirTermos(){
        Fragment frag = new fragTermos();
    }

    public void checagemCadastro(){


        String nome = Txt_Nome.getText().toString();
        String sobrenome = Txt_Sobrenome.getText().toString();
        String email = Txt_Email.getText().toString();
        String senha = Txt_Senha.getText().toString();

        Txt_Nome.setError(null);
        Txt_Sobrenome.setError(null);
        Txt_Email.setError(null);
        Txt_Senha.setError(null);

        if (TextUtils.isEmpty(nome)){
            Txt_Nome.setError(getString(R.string.Erro_CampoObrigatorio));
            focusView = Txt_Nome;
        }

        if (TextUtils.isEmpty(sobrenome)){
            Txt_Sobrenome.setError(getString(R.string.Erro_CampoObrigatorio));
            focusView = Txt_Sobrenome;
        }

        if (TextUtils.isEmpty(email)){
            Txt_Email.setError(getString(R.string.Erro_CampoObrigatorio));
            focusView = Txt_Email;
        }

        if (TextUtils.isEmpty(senha)){
            Txt_Senha.setError(getString(R.string.Erro_CampoObrigatorio));
            focusView = Txt_Senha;
            cancel = true;
        }else if(senha.length() < 5){
            Txt_Senha.setError(getString(R.string.Erro_PasswordInvalido));
            focusView = Txt_Senha;
            cancel = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        Txt_Nome = (EditText) findViewById(R.id.Txt_Nome);
        Txt_Sobrenome = (EditText) findViewById(R.id.Txt_Sobrenome);
        Txt_Email = (EditText) findViewById(R.id.Txt_Email);
        Txt_Senha = (EditText) findViewById(R.id.Txt_Senha);
        Btn_FacebookCadastro = (Button) findViewById(R.id.Btn_FacebookCadastro);
        Btn_Cadastro = (Button) findViewById(R.id.Btn_Cadastro);
        Btn_Termos = (Button) findViewById(R.id.Btn_Termos);

        Btn_Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checagemCadastro();
            }
        });

        Btn_Termos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTermos();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        abrirLogin();
    }
}
