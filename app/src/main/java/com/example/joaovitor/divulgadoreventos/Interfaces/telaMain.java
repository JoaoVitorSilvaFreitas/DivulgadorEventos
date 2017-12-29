package com.example.joaovitor.divulgadoreventos.Interfaces;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.joaovitor.divulgadoreventos.Fragmentos.telaMaps;
import com.example.joaovitor.divulgadoreventos.R;

public class telaMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //intent para abrir a posiçao do sesi
    public void SesiIntent() {
        Intent itsesi = new Intent(telaMain.this, telaMaps.class);
        itsesi.putExtra("Sesi", 2);
        startActivity(itsesi);
    }
    //intent para abrir a posição do sesc
    public void SescIntent() {
        Intent itsesc = new Intent(telaMain.this, telaMaps.class);
        itsesc.putExtra("Sesc", 1);
        startActivity(itsesc);
    }
    //Intent que mostra uma mensagem.
    private void InformacoesAlert(){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setIcon(R.drawable.ic_menu_manage);
        dialog.setTitle("Informaçoes do app");
        dialog.setMessage("App em desenvolvimento por: Joao Vitor," +
                " com a finalidade de divulgar eventos culturais na cidade de São josé dos campos");
        dialog.setCancelable(false);

        dialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }
    //intent para startar a tela de configurações
    private void Configs(){
        Intent itconfig = new Intent(telaMain.this,telaConfiguracoes.class);
        startActivity(itconfig);
    }


    private FloatingActionButton Fab_Map;
    private Toolbar tBar_Tool;
    private DrawerLayout Lay_Draw;
    private NavigationView Lay_NavView;
    private TabItem iTab_Culturais;
    private TabItem iTab_Gerais;
    //private Spinner Spn_Cidade;
    //Array para ser inserido dentro do Spinner de cidades.
    private String[] cidadesAdap = new String[]{"São José dos Campos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_main);

        Lay_Draw = (DrawerLayout) findViewById(R.id.Lay_Draw);
        tBar_Tool = (Toolbar) findViewById(R.id.tBar_Tool);
        setSupportActionBar(tBar_Tool);
        iTab_Culturais = (TabItem) findViewById(R.id.iTab_Culturais);
        iTab_Gerais = (TabItem) findViewById(R.id.iTab_Gerais);
        Lay_NavView = (NavigationView) findViewById(R.id.Lay_NavView);
        //Spn_Cidade = (Spinner) findViewById(R.id.Spn_Cidade);

        /* FloatingButton para abrir na cidade com possibilidades de zoom e
        posicionamento atual.*/
        Fab_Map = (FloatingActionButton) findViewById(R.id.Fab_Map);
        Fab_Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == Fab_Map) {
                    Intent intent = new Intent(telaMain.this, telaMaps.class);
                    intent.putExtra("FloatingButton", 0);
                    startActivity(intent);
                }
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, Lay_Draw, tBar_Tool, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //Layout do navigationDrawer
        Lay_Draw.addDrawerListener(toggle);
        toggle.syncState();
        Lay_NavView.setNavigationItemSelectedListener(this);

        /*ArrayAdapter<String> CityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, cidadesAdap);
        Spn_Cidade.setAdapter(CityAdapter);
        Spn_Cidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); */

    }

    @Override
    public void onBackPressed() {

        if (Lay_Draw.isDrawerOpen(GravityCompat.START)) {
            Lay_Draw.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.nav_sesc:
                SescIntent();
                break;
            case R.id.nav_sesi:
                SesiIntent();
                break;
            case R.id.nav_config:
                Configs();
                break;
            case R.id.nav_info:
                InformacoesAlert();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.Lay_Draw);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
