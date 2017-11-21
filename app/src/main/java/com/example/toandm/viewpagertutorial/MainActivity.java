package com.example.toandm.viewpagertutorial;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.toandm.viewpagertutorial.adapter.TabsSelectionAdapter;
import com.example.toandm.viewpagertutorial.fragments.HomeFragment;
import com.example.toandm.viewpagertutorial.fragments.LikeFragment;
import com.example.toandm.viewpagertutorial.impl.OnClickLikeTabs;
import com.example.toandm.viewpagertutorial.impl.OnItemClickedListener;
import com.example.toandm.viewpagertutorial.models.ShopItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements HomeFragment.OnManagerData{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    LikeFragment likeFragment;
    private OnClickLikeTabs onSendListToLikeFragment;
    List<ShopItem> likeList = new ArrayList<ShopItem>();
    private TabsSelectionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        adapter = new TabsSelectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                if (tab == tabLayout.getTabAt(1)){
////                    onSendListToLikeFragment.sendListData(likeList);
//                    viewPager.setCurrentItem(1);
//
//                }
                tab.getIcon().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }
        });


    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(Database.TAB_ICONS[0]);
        tabLayout.getTabAt(1).setIcon(Database.TAB_ICONS[1]);
        tabLayout.getTabAt(2).setIcon(Database.TAB_ICONS[2]);
        tabLayout.getTabAt(3).setIcon(Database.TAB_ICONS[3]);
        tabLayout.getTabAt(4).setIcon(Database.TAB_ICONS[4]);

        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(4).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);

    }


    @Override
    public void sendData(ShopItem item) {
        likeList.add(item);
        LikeFragment likeFragment = (LikeFragment) getSupportFragmentManager()
                .findFragmentByTag(adapter.getListTagOfFragment().get(1));
        likeFragment.sendListData(likeList);
        Toast.makeText(getApplicationContext(),likeList.get(0).getNameProduct(),Toast.LENGTH_SHORT).show();
    }
}