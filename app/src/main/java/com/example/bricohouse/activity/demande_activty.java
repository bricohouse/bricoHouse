package com.example.bricohouse.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;

import com.example.bricohouse.R;
import com.example.bricohouse.activity.PageAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class demande_activty extends AppCompatActivity {
    private TabItem tab1, tab2, tab3, tab4;
    private ViewPager viewPager;
    private TabLayout tab;
    private PagerAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demande_activty);

        tab1 = (TabItem) findViewById(R.id.item1);
        tab2 = (TabItem) findViewById(R.id.item2);
        tab3 = (TabItem) findViewById(R.id.item3);
        tab4 = (TabItem) findViewById(R.id.item4);
        tab = (TabLayout) findViewById(R.id.tabl1);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        pageAdapter = new PageAdapter(getSupportFragmentManager(), tab.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    }
                } else if (tab.getPosition() == 2) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    }
                }
                else if (tab.getPosition() == 3) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    }
                }

                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    }
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));



    }
    public void selectfragment(int position)
    {
        viewPager.setCurrentItem(position, true);
    }


     /*   tab.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    pageAdapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 2) {
                    pageAdapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 3) {
                    pageAdapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 4) {
                    pageAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

    } */
}

