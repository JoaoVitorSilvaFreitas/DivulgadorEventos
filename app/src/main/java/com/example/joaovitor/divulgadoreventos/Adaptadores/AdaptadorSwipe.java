package com.example.joaovitor.divulgadoreventos.Adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.joaovitor.divulgadoreventos.Fragmentos.fragCards;
import com.example.joaovitor.divulgadoreventos.Fragmentos.fragMaps;
import com.example.joaovitor.divulgadoreventos.Fragmentos.pageFragment;

public class AdaptadorSwipe extends FragmentPagerAdapter {
    //Cria a tabela para exibição dos nomes.
    private String tabTitles[] = new String[]{"Eventos", "Mapa"};

    public AdaptadorSwipe(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new pageFragment();
        //Cria o fragmento do fragMaps
        Fragment fragMap = new fragMaps();
        //Cria o fragmento do CardView
        Fragment fragCard = new fragCards();

        // Retorna um fragmento para cada posição do pageFragment.
        switch (position) {
            case 0:
                return fragCard;
            case 1:
                return fragMap;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        // Seta a quantidade de tabs no layout.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Seleciona a tab através da posição.
        return tabTitles[position];
    }
}
