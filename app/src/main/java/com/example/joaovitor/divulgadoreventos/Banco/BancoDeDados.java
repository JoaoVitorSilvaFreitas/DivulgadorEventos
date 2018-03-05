package com.example.joaovitor.divulgadoreventos.Banco;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BancoDeDados extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_USUARIO = "bd.usuarios";

    private static final String TABELA_USUARIO = "tabela";
    private static final String COLUNA_CODIGO = "codigo";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_SOBRENOME = "sobrenome";
    private static final String COLUNA_EMAIL = "email";
    private static final String COLUNA_SENHA = "senha";

    public BancoDeDados(Context context) {
        super(context, BANCO_USUARIO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String QUERY_COLUNA = "CREATE TABLE " + TABELA_USUARIO + "("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY, " + COLUNA_NOME + "TEXT,"
                + COLUNA_EMAIL + " TEXT)";

        db.execSQL(QUERY_COLUNA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int j) {



    }

    public void addUsuario (Usuario usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUNA_NOME,usuario.getNome());
        cv.put(COLUNA_EMAIL, usuario.getEmail());

        db.insert(TABELA_USUARIO,null, cv);
        db.close();
    }

}
