package com.example.joaovitor.divulgadoreventos.Fragmentos;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.example.joaovitor.divulgadoreventos.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class telaMaps extends FragmentActivity implements OnMapReadyCallback {
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    // Valor booleano nulo para verificar a permissão.
    private boolean PermissaoLocalizacao;
    private GoogleMap mMap;

    //abre o mapa com um marcador no sesc.
    private void PositionSesc() {
        LatLng SescSjc = new LatLng(-23.200979, -45.892457);
        mMap.addMarker(new MarkerOptions().position(SescSjc).title("Sesc"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SescSjc));
        //zoom no sesc
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(SescSjc, 18);
        mMap.moveCamera(update);
        //tipo de mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        VerificaPermissao();
        UpdatePermissao();
    }

    private void PositionSesi() {
        LatLng SesiSjc = new LatLng(-23.248826, -45.884914);
        mMap.addMarker(new MarkerOptions().position(SesiSjc).title("Teatro Sesi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SesiSjc));
        //zoom no Teatro sesi
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(SesiSjc, 18);
        mMap.moveCamera(update);
        //tipo de mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //Verificar e ativar a permissão do usuário
        VerificaPermissao();
        UpdatePermissao();
    }

    private void PositionSjc() {
        // Adiciona a marca
        LatLng Sjk = new LatLng(-23.215932, -45.895167);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Sjk));
        //zoom no sesc
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(Sjk, 15);
        mMap.moveCamera(update);
        //tipo de mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //controle de zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);
        //Verificar e ativar a permissão do usuário
        VerificaPermissao();
        UpdatePermissao();
    }

    //Função responsável para verificar a permissão, caso não esteja ativa ele requisita a
    // autorização do usuário
    private void VerificaPermissao() {
        //Verifica se a permissao esta ativa.
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            PermissaoLocalizacao = true;
        } else {
            // Caso nao esteja, o sera aberta uma tela para o usuario permitir
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    //função que verifica a permissão de mapa ativa no aplicativo,
    //responsavel para abrir a localização atual.
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_maps);
        // Cria o fragmento de mapa, para executar o map.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Funcao bundle, recebendo o conteudo da intent que esta na tela main,
        // verificando qual botao esta sendo pressionado atraves de um "codigo" em String.
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        PermissaoLocalizacao = false;
        //Switch checando se a permissao ao acesso da localizaçao esta ativo atraves do valor INT da constante.
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // Se a requisiçao for cancelada, os arrays de resultado estarao vazios.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    PermissaoLocalizacao = true;
                }
            }
        }
        // Checar permissao, abrir o botao de verificar posicao atual.
        UpdatePermissao();
    }

}