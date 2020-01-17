package com.example.bricohouse.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.bricohouse.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class accueil extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private CategoriesFragment categoriesFragment;
    private ActivitiesFragment activitiesFragment;
    private ProfileFragment profileFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        mMainFrame=(FrameLayout)findViewById(R.id.main_frame);
        mMainNav=(BottomNavigationView) findViewById(R.id.main_nav);
        categoriesFragment= new CategoriesFragment();
        activitiesFragment= new ActivitiesFragment();
        profileFragment= new ProfileFragment();
        setFragment(categoriesFragment);
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_cat:
                        setFragment(categoriesFragment);
                        return true;
                    case R.id.nav_act:
                        setFragment(activitiesFragment);
                        return true;
                    case R.id.nav_prof:
                        setFragment(profileFragment);
                        return true;
                default:
                return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
}
