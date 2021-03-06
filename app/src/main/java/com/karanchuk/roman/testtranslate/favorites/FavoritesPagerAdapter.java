package com.karanchuk.roman.testtranslate.favorites;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by roman on 9.4.17.
 */

public class FavoritesPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mFragmentTitles;

    public FavoritesPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles){
        super(fm);
        mFragments = fragments;
        mFragmentTitles = titles;
    }
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mFragmentTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }
}
