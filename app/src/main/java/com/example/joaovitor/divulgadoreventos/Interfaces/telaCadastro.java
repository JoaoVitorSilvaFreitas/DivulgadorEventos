package com.example.joaovitor.divulgadoreventos.Interfaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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


    public void abrirLogin() {
        Intent intent = new Intent(this, telaLogin.class);
        startActivity(intent);
        finish();
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

        String nome = Txt_Nome.getText().toString();
        String sobrenome = Txt_Nome.getText().toString();
        String email = Txt_Nome.getText().toString();
        String senha = Txt_Nome.getText().toString();

        Txt_Nome.setError(null);
        Txt_Sobrenome.setError(null);
        Txt_Email.setError(null);
        Txt_Senha.setError(null);

        if (TextUtils.isEmpty(nome)){
            Txt_Nome.setError(getString(R.string.Erro_CampoObrigatorio));
            focusView = Txt_Nome;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        abrirLogin();
    }
}
