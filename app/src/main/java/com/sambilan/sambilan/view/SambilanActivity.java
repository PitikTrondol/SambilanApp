package com.sambilan.sambilan.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.view.fragment.AddPageFragment;
import com.sambilan.sambilan.view.fragment.CategoryPageFragment;
import com.sambilan.sambilan.view.fragment.LandingPageFragment;
import com.sambilan.sambilan.view.fragment.MiscelaneousFragment;
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

        if(((SambilanApplication) getApplication()).isConnected())
            loadFragment(new LandingPageFragment());
        else
            loadFragment(MiscelaneousFragment.newInstance("Anda Sedang Offline"));


        bottomNavigationView = findViewById(R.id.btn_bottomnav);
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    protected void onResume() {
        super.onResume();
//        if(((SambilanApplication) getApplication()).isConnected()) {
//            loadFragment(new LandingPageFragment());
//        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.btn_home:
                    if(((SambilanApplication) getApplication()).isConnected())
                        loadFragment(new LandingPageFragment());
                    else
                        loadFragment(MiscelaneousFragment.newInstance("Anda Sedang Offline"));
                    return true;
                case R.id.btn_add:
                    loadFragment(new AddPageFragment());
                    return true;
                case R.id.btn_category:
                    loadFragment(new CategoryPageFragment());
                    return true;
                case R.id.btn_me:
                    loadFragment(new ProfilePageFragment());
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(android.support.v4.app.Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container,fragment)
                .addToBackStack(null)
                .commit();
    }
}
