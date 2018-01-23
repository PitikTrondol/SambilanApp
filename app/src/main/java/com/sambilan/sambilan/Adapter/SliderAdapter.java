package com.sambilan.sambilan.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andhika Putranto on 1/18/2018.
 */

public class SliderAdapter extends FragmentStatePagerAdapter {

    List<Fragment> frags = new ArrayList<>();

    public SliderAdapter(FragmentManager fm, List<Fragment> Frags) {
        super(fm);
        this.frags = Frags;
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
//        int index = position % frags.size();
//        return frags.get(index);
    }

    @Override
    public int getCount() {
        return frags.size();
//        return Integer.MAX_VALUE;
    }

}