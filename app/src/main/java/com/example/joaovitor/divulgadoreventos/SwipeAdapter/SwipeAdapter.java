package com.example.joaovitor.divulgadoreventos.SwipeAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by joaovitor on 04/01/18.
 */

public class SwipeAdapter extends FragmentPagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new pageFragment();
        Bundle bdl = new Bundle();
        bdl.putInt("count", position +1);
        fragment.setArguments(bdl);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
