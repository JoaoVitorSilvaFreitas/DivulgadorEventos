package com.example.joaovitor.divulgadoreventos.Banco;

public class Usuario {

    int Codigo;
    String Nome;
    String Email;
    String Sobrenome;
    String Senha;


    public Usuario(String nome,String Sobrenome, String email, String senha){

    }

    public int Usuario(int codigo, String nome,String sobrenome, String email,String senha) {
        this.Codigo = codigo;
        this.Nome = nome;
        this.Sobrenome = sobrenome;
        this.Email = email;
        this.Senha = senha;

        return Codigo;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}

