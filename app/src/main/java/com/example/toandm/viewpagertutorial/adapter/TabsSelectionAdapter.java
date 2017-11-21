package com.example.toandm.viewpagertutorial.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.example.toandm.viewpagertutorial.R;
import com.example.toandm.viewpagertutorial.fragments.HomeFragment;
import com.example.toandm.viewpagertutorial.fragments.LikeFragment;
import com.example.toandm.viewpagertutorial.fragments.FilterFragment;

import java.util.ArrayList;

/**
 * Created by toandm on 11/14/17.
 */

public class TabsSelectionAdapter extends FragmentPagerAdapter {
    private ArrayList<String> listTagOfFragment;
    private int NUM_ITEMS = 5;
    private String[] titleTab = new String[]{"Home","Like","Filter","Search","Setting"};

    public TabsSelectionAdapter(FragmentManager fm) {
        super(fm);
        listTagOfFragment = new ArrayList<>();
    }


    public ArrayList<String> getListTagOfFragment() {
        return listTagOfFragment;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment homeFragment = HomeFragment.newInstance();
                return homeFragment;
            case 1:
                LikeFragment likeFragment = new LikeFragment();
                return likeFragment;
            case 2:
                FilterFragment filterFragment = new FilterFragment();
                return filterFragment;
            case 3:
                FilterFragment searchFragment = new FilterFragment();
                return searchFragment;
            case 4:
                FilterFragment settingFragment = new FilterFragment();
                return settingFragment;
        }
        return null;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment createdFragment = (Fragment) super.instantiateItem(container, position);
        // get the tags set by FragmentPagerAdapter
        switch (position) {
            case 0:
                String firstTag = createdFragment.getTag();
                listTagOfFragment.add(firstTag);
                break;
            case 1:
                String secondTag = createdFragment.getTag();
                listTagOfFragment.add(secondTag);
                break;
            case 2:
                String thirdTag = createdFragment.getTag();
                listTagOfFragment.add(thirdTag);
                break;
            case 3:
                String fouthTag = createdFragment.getTag();
                listTagOfFragment.add(fouthTag);
                break;
            case 4:
                String fivethTag = createdFragment.getTag();
                listTagOfFragment.add(fivethTag);
                break;

        }
        // ... save the tags somewhere so you can reference them later
        return createdFragment;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  titleTab[position];
    }


}
