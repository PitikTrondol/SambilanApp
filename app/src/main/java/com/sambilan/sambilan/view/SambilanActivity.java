package com.sambilan.sambilan.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.view.fragment.LandingPageFragment;
import com.sambilan.sambilan.view.fragment.ProfilePageFragment;
import com.sambilan.sambilan.view.helper.BottomNavigationHelper;

/**
 * Created by Andhika Putranto on 2/3/2018.
 */

public class SambilanActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sambilan);
        loadFragment(new LandingPageFragment());

        bottomNavigationView = findViewById(R.id.btn_bottomnav);
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()){
                case R.id.btn_home:
                    fragment = new LandingPageFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.btn_add:
//                    fragment = new AddPageFragment();
//                    loadFragment(fragment);
                    Toast.makeText(getApplicationContext(), "Tambah", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.btn_category:
//                    fragment = new CategoryPageFragment();
//                    loadFragment(fragment);
                    Toast.makeText(getApplicationContext(), "Kategori", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.btn_me:
                    fragment = new ProfilePageFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(android.support.v4.app.Fragment fragment){
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
