package com.example.joaovitor.divulgadoreventos.Fragmentos;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.joaovitor.divulgadoreventos.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class telaMaps extends FragmentActivity implements OnMapReadyCallback {
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    // Valor booleano nulo para verificar a permissão.
    private boolean PermissaoLocalizacao;
    private GoogleMap mMap;
    private LatLng SesiSjc = new LatLng(-23.248826, -45.884914);
    private LatLng SescSjc = new LatLng(-23.200979, -45.892457);
    private LatLng Sjk = new LatLng(-23.215932, -45.895167);
    private LatLng ParqueCity = new LatLng(-23.170061, -45.889969);
    private LatLng VicentinaA = new LatLng(-23.197856, -45.896316);
    private LatLng ParqueSantosD = new LatLng(-23.199851, -45.891093);
    private LatLng CcFlavioC = new LatLng(-23.273900, -45.891711);

    /* Função responsável para verificar a permissão, caso não esteja ativa ele requisita a
     autorização do usuário */
    private void VerificaPermissao() {
        //Verifica se a permissao esta ativa.
        if (ContextCompat.checkSelfPermission
                (this.getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            PermissaoLocalizacao = true;
        } else {
            // Caso nao esteja, o sera aberta uma tela para o usuario permitir
            ActivityCompat.requestPermissions
                    (this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                            PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    /* Função que verifica a permissão de mapa ativa no aplicativo, responsavel para abrir a
     localização atual do usuário */
    private void UpdatePermissao() {
        if (mMap == null) {
            return;
        }
        try {
            //caso a permissao esteja ativa, abrir os botoes de localizacao.
            if (PermissaoLocalizacao) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                // caso nao esteja ativa, o usuario tera que permitir o acesso ao GPS,
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
                VerificaPermissao();
            }
        } catch (SecurityException e) {
            Log.e("Exception: %s", e.getMessage());
        }
    }

    //Configurações gerais do mapa
    private void MapConfig() {
        //tipo de mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //controle de zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);
        //Controle de preferencias de zoom: Minimo e máximo
        mMap.setMinZoomPreference(12);
        mMap.setMaxZoomPreference(20);
        //Libera todas os gestos de mapa do app. (Inclinação, rotação, rolagem, zoom.
        mMap.getUiSettings().setAllGesturesEnabled(true);
        /* Controle de direção (Bússola), apenas quando o usuário estiver com uma rota traçada
        e olhando para outro lado do mapa */
        mMap.getUiSettings().setCompassEnabled(true);
        //Verificar e ativar a permissão do usuário
        VerificaPermissao();
        UpdatePermissao();
    }

    //Configurações dos marcadores no mapa
    private void Marcadores(){
        mMap.addMarker(new MarkerOptions().position(SesiSjc).title("Teatro Sesi")
                .snippet("Feiras culturais, Apresentações"));
        mMap.addMarker(new MarkerOptions().position(SescSjc).title("Sesc"))
                .setSnippet("Eventos Culturais, esportes , entre outros.");
        mMap.addMarker(new MarkerOptions().position(ParqueCity).title("Parque da Cidade")
                .snippet("Eventos diversos, Museu do folclore"));
        mMap.addMarker(new MarkerOptions().position(VicentinaA).title("Parque Vicentina Aranha")
                .snippet("Atividades Culturais, ecologicas e esportivas"));
        mMap.addMarker(new MarkerOptions().position(ParqueSantosD).title("Parque Santos Dumont")
                .snippet("Parque com lago e equipamentos de ginástica"));
        mMap.addMarker(new MarkerOptions().position(CcFlavioC)
                .title("Casa de Cultura Flávio Craveiro")
                .snippet("Eventos culturais, Shows entre outros."));
    }

    //abre o mapa com um marcador no sesc.
    private void PositionSesc() {
        //Setando para onde o mapa irá mover e o zoom
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(SescSjc, 18);
        //Adiciona um marcador no mapa, iniciando no sesc.
        mMap.addMarker(new MarkerOptions().position(SescSjc).title("Sesc"))
                .setSnippet("Eventos Culturais, esportes , entre outros.");
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SescSjc));
        //zoom no sesc
        mMap.moveCamera(update);
        MapConfig();
    }

    //Abre o mapa com um marcador no sesi.
    private void PositionSesi() {
        //Setando para onde o mapa irá mover e o zoom
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(SesiSjc, 18);
        //Adiciona um marcador no mapa, iniciando no sesc
        mMap.addMarker(new MarkerOptions().position(SesiSjc).title("Teatro Sesi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SesiSjc));
        //zoom no Teatro sesi
        mMap.moveCamera(update);
        MapConfig();
    }

    //Abre o mapa com uma posição inicial localizada em São José dos Campos
    private void PositionSjc() {
        // Adiciona a marca
        Marcadores();
        //zoom no sesc
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(Sjk, 12);
        mMap.moveCamera(update);
        MapConfig();
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_maps);
        // Cria o fragmento de mapa, para executar o map.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        /*Funcao bundle, recebendo o conteudo da intent que esta na tela main,
        verificando qual botao esta sendo pressionado atraves de um "codigo" em String.*/
        Bundle bundle = getIntent().getExtras();
        if (bundle.containsKey("FloatingButton")) {
            PositionSjc();
        } else if (bundle.containsKey("Sesc")) {
            PositionSesc();
        } else if (bundle.containsKey("Sesi")) {
            PositionSesi();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        PermissaoLocalizacao = false;
        /*Switch checando se a permissao ao acesso da localizaçao esta ativo atraves
        do valor INT da constante*/
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // Se a requisiçao for cancelada, os arrays de resultado estarao vazios.
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    PermissaoLocalizacao = true;
                }
            }
        }
        // Checar permissao, abrir o botao de verificar posicao atual.
        UpdatePermissao();
    }

}