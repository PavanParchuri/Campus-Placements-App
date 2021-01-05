package com.example.campusplacementsapp.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.campusplacementsapp.CHome;
import com.example.campusplacementsapp.CMaterials;
import com.example.campusplacementsapp.CTests;
import com.example.campusplacementsapp.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        /*if (position == 0) {
            return new CHome();
        } else if (position == 1) {
            return new CMaterials();
        } else  {
            return new CTests();
        }*/
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        /*if (position == 0) {
            return mContext.getString(R.string.fragment_c_home);
        } else if (position == 1) {
            return mContext.getString(R.string.fragment_c_materials);
        } else  {
            return mContext.getString(R.string.fragment_c_tests);
        }*/
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
        //return 3;
    }
}