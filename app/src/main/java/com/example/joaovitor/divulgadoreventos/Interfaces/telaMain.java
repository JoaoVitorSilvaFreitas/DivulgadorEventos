package com.example.joaovitor.divulgadoreventos.Interfaces;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.joaovitor.divulgadoreventos.Adaptadores.AdaptadorSwipe;
import com.example.joaovitor.divulgadoreventos.R;

public class telaMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //Função para mostrar as mensagens
    private void InformacoesAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setIcon(R.drawable.ic_information);
        dialog.setTitle("Informaçoes do app");
        dialog.setMessage("\nApp em desenvolvimento por: João Vitor."  +
                "\n\nA finalidade do projeto é fazer a divulgação de " +
                "eventos culturais na cidade de São José dos campos");
        dialog.setCancelable(false);

        dialog.setNeutralButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    //intent para startar a tela de configurações
    private void Configs() {
        Intent itconfig = new Intent(this, telaConfiguracoes.class);
        startActivity(itconfig);
    }

    //intent para retornar a tela de login
    private void RetornoLogin(){
        Intent itlogin = new Intent(this,telaLogin.class);
        startActivity(itlogin);
    }

    private Toolbar tBar_Tool;
    private DrawerLayout Lay_Draw;
    private NavigationView Lay_NavView;
    private String RecebeNome;
    private TextView Txt_HeadNome;
    private String nome;
    private ViewPager Vp_ViewPager;
    private TabLayout tab_Layout;
    private ImageView Img_Fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_main);

        Lay_Draw = (DrawerLayout) findViewById(R.id.Lay_Draw);
        tBar_Tool = (Toolbar) findViewById(R.id.tBar_Tool);
        setSupportActionBar(tBar_Tool);
        Lay_NavView = (NavigationView) findViewById(R.id.Lay_NavView);
        Txt_HeadNome = (TextView) findViewById(R.id.Txt_HeadNome);
        Vp_ViewPager = (ViewPager) findViewById(R.id.Vp_ViewPager);
        tab_Layout = (TabLayout) findViewById(R.id.tab_Layout);
        Img_Fotos = (ImageView) findViewById(R.id.Img_Fotos);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.pref_nomeExibicao), Context.MODE_PRIVATE);
        String valorString = sharedPreferences.getString("key_nomeExibicao", "valor padrão");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.pref_nomeExibicao),"");
        editor.apply();

        /*ViewPager do swipe adapter e o tablayout
        para fazer as telas interagirem através de slide */
        AdaptadorSwipe swipeAdapter = new AdaptadorSwipe(getSupportFragmentManager());
        Vp_ViewPager.setAdapter(swipeAdapter);
        tab_Layout.setupWithViewPager(Vp_ViewPager);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, Lay_Draw, tBar_Tool, R.string.nDraw_Open, R.string.nDraw_Close);
        //Layout do navigationDrawer
        Lay_Draw.addDrawerListener(toggle);
        toggle.syncState();
        Lay_NavView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (Lay_Draw.isDrawerOpen(GravityCompat.START)) {
            Lay_Draw.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            RetornoLogin();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu da toolbar
        getMenuInflater().inflate(R.menu.tela_main, menu);
        // Cria um item do menu
        MenuItem CampoDeBusca = menu.findItem(R.id.buscar_CampoDeBusca);
        SearchView sView = (SearchView) MenuItemCompat.getActionView(CampoDeBusca);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_config:
                Configs();
                break;
            case R.id.nav_info:
                InformacoesAlert();
                break;
            case R.id.nav_sair:
                RetornoLogin();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.Lay_Draw);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
