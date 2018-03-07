package com.example.joaovitor.divulgadoreventos.Interfaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.joaovitor.divulgadoreventos.Banco.BancoDeDados;
import com.example.joaovitor.divulgadoreventos.Banco.Usuario;
import com.example.joaovitor.divulgadoreventos.R;

public class telaCadastro extends AppCompatActivity {

    private boolean cancel = false;
    private View focusView = null;
    private EditText Txt_Nome;
    private EditText Txt_Sobrenome;
    private EditText Txt_Email;
    private EditText Txt_Senha;
    private Button Btn_Cadastro;
    private Button Btn_Teste;
    private TextInputLayout Til_Nome;
    private TextInputLayout Til_Sobrenome;
    private TextInputLayout Til_EmailCadastro;
    private TextInputLayout Til_SenhaCadastro;
    private CheckBox Cbox_Termos;
    private ImageView Img_Retorno;
    private ListView Lst_ListView;

    private BancoDeDados bd = new BancoDeDados(this);

    public void abrirLogin() {
        Intent intent = new Intent(this, telaLogin.class);
        startActivity(intent);
        finish();
    }

    private void abrirMain(){
        Intent intent = new Intent(this,telaMain.class);
        startActivity(intent);
        finish();
    }

    // verifica se o e-mail é valido, se ele conter o "@".
    private boolean VerificaEmail(String email) {
        return email.contains("@example.com");
    }

    // Checar e setar os erros do cadastro.
    public void checagemCadastro() {


        String nome = Txt_Nome.getText().toString();
        String sobrenome = Txt_Sobrenome.getText().toString();
        String email = Txt_Email.getText().toString();
        String senha = Txt_Senha.getText().toString();

        //Setando os Til's para as mensagens de erro
        Til_Nome.setError(null);
        Til_Sobrenome.setError(null);
        Til_EmailCadastro.setError(null);
        Til_SenhaCadastro.setError(null);

        if (TextUtils.isEmpty(nome)) {
            Til_Nome.setError(getString(R.string.Erro_CampoVazio));
            focusView = Til_Nome;
        }

        if (TextUtils.isEmpty(sobrenome)) {
            Til_Sobrenome.setError(getString(R.string.Erro_CampoVazio));
            focusView = Til_Sobrenome;
        }

        // Erro de E-mail vazio.
        if (TextUtils.isEmpty(email)) {
            Til_EmailCadastro.setError(getString(R.string.Erro_CampoObrigatorio));
            focusView = Til_EmailCadastro;
            cancel = true;
            // Erro de e-mail invalido.
        } else if (!VerificaEmail(email)) {
            Til_EmailCadastro.setError(getString(R.string.Erro_EmailInvalido));
            focusView = Til_EmailCadastro;
            cancel = true;
        }

        //Erro de senha vázia.
        if (TextUtils.isEmpty(senha)) {
            Til_SenhaCadastro.setError(getString(R.string.Erro_CampoObrigatorio));
            focusView = Til_SenhaCadastro;
            cancel = true;
            //Erro de senha muito curta.
        } else if (senha.length() < 5) {
            Til_SenhaCadastro.setError(getString(R.string.Erro_PasswordInvalido));
            focusView = Til_SenhaCadastro;
            cancel = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        Txt_Nome = (EditText) findViewById(R.id.Txt_Nome);
        Txt_Sobrenome = (EditText) findViewById(R.id.Txt_Sobrenome);
        Txt_Email = (EditText) findViewById(R.id.Txt_EmailCadastro);
        Txt_Senha = (EditText) findViewById(R.id.Txt_Senha);
        Btn_Cadastro = (Button) findViewById(R.id.Btn_Cadastro);
        Btn_Teste = (Button) findViewById(R.id.Btn_Teste);
        Til_Nome = (TextInputLayout) findViewById(R.id.Til_Nome);
        Til_Sobrenome = (TextInputLayout) findViewById(R.id.Til_Sobrenome);
        Til_EmailCadastro = (TextInputLayout) findViewById(R.id.Til_EmailCadastro);
        Til_SenhaCadastro = (TextInputLayout) findViewById(R.id.Til_SenhaCadastro);
        Img_Retorno = (ImageView) findViewById(R.id.Img_Retorno);
        Lst_ListView = (ListView) findViewById(R.id.Lst_ListView);
        Cbox_Termos = (CheckBox) findViewById(R.id.Cbox_Termos);


        Img_Retorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirLogin();
            }
        });

        Btn_Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checagemCadastro();
            }
        });

        Btn_Teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = Txt_Nome.getText().toString();
                String sobrenome = Txt_Sobrenome.getText().toString();
                String email = Txt_Email.getText().toString();
                String senha = Txt_Senha.getText().toString();

                if (Cbox_Termos.isChecked()) {
                    bd.addUsuario(new Usuario(nome, sobrenome, email, senha));
                    Toast.makeText(telaCadastro.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();
                    abrirMain();
                } else {
                    Toast.makeText(telaCadastro.this, "Favor checar os termos", Toast.LENGTH_LONG).show();
                }

            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        abrirLogin();
    }
}
