package com.example.joaovitor.divulgadoreventos.Interfaces;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
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
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.joaovitor.divulgadoreventos.Fragmentos.telaMaps;
import com.example.joaovitor.divulgadoreventos.R;
import com.google.android.gms.maps.MapFragment;

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
    private String RecebeNome;
    private TextView Txt_HeadNome;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_main);

        Lay_Draw = (DrawerLayout) findViewById(R.id.Lay_Draw);
        tBar_Tool = (Toolbar) findViewById(R.id.tBar_Tool);
        setSupportActionBar(tBar_Tool);
        Lay_NavView = (NavigationView) findViewById(R.id.Lay_NavView);
        Txt_HeadNome = (TextView) findViewById(R.id.Txt_HeadNome);

        /* FloatingButton para abrir o mapa na cidade de São José dos campos e também
        adiciona os marcadores onde será exibido os eventos culturais, casas de culturas e etc...*/
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
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Ativar o campo de busca da toolbar
        getMenuInflater().inflate(R.menu.tela_main, menu);
        MenuItem CampoDeBusca = menu.findItem(R.id.buscar_CampoDeBusca);
        SearchView sView = (SearchView) MenuItemCompat.getActionView(CampoDeBusca);

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
