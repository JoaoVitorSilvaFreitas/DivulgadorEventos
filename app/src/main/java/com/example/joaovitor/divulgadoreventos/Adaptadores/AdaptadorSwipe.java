package com.example.joaovitor.divulgadoreventos.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.joaovitor.divulgadoreventos.Fragmentos.fragCards;
import com.example.joaovitor.divulgadoreventos.Fragmentos.fragMaps;
import com.example.joaovitor.divulgadoreventos.Fragmentos.pageFragment;

/**
 * Created by joaovitor on 04/01/18.
 */

public class AdaptadorSwipe extends FragmentPagerAdapter {

    Context context;
    Intent intent;

    //Cria a tabela para exibição dos nomes.
    private String tabTitles[] = new String[]{"Tab1", "Tab2", "Mapa"};

    public AdaptadorSwipe(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new pageFragment();
        //Cria o fragmento do fragMaps
        Fragment fragMap = new fragMaps();
        //
        Fragment fragCard = new fragCards();

        //Retorna o texto
        Bundle bdl = new Bundle();
        bdl.putInt("count", position + 1);
        fragment.setArguments(bdl);

        switch (position) {
            case 0:
                return fragCard;
            case 1:
                return fragment;
            case 2:
                return fragMap;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        // Seta a quantidade de tabs no layout.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Seleciona a tab através da posição.
        return tabTitles[position];
    }

}
