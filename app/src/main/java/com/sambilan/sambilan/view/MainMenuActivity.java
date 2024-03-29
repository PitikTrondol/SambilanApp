package com.sambilan.sambilan.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.utils.CacheManager;
import com.sambilan.sambilan.view.fragment.AddPageFragment;
import com.sambilan.sambilan.view.fragment.CategoryPageFragment;
import com.sambilan.sambilan.view.fragment.LandingPageFragment;
import com.sambilan.sambilan.view.fragment.MiscelaneousFragment;
import com.sambilan.sambilan.view.fragment.ProfilePageFragment;
import com.sambilan.sambilan.view.helper.BottomNavigationHelper;

/**
 * Created by Andhika Putranto on 2/3/2018.
 */

public class MainMenuActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sambilan);

        if (((SambilanApplication) getApplication()).isConnected())
            loadFragment(new LandingPageFragment());
        else
            loadFragment(MiscelaneousFragment.newInstance(MiscelaneousFragment.OFFLINE_MODE));


        bottomNavigationView = findViewById(R.id.btn_bottomnav);
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bottomNavigationView.setSelectedItemId(R.id.btn_home);

        if(!((SambilanApplication) getApplication()).getAppRole().equals("employer")) {
            bottomNavigationView.getMenu().removeItem(R.id.btn_add);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.btn_home:
                            if (((SambilanApplication) getApplication()).isConnected())
                                loadFragment(new LandingPageFragment());
                            else
                                loadFragment(MiscelaneousFragment.newInstance(MiscelaneousFragment.OFFLINE_MODE));
                            return true;
                        case R.id.btn_add:
                            if (((SambilanApplication) getApplication()).isLoggedIn()
                                    && ((SambilanApplication) getApplication()).getAppRole().equals("employer")) {

                                loadFragment(new AddPageFragment());
                            } else {

                                Toast.makeText(MainMenuActivity.this, "Silakan Login Sebagai Employer",
                                        Toast.LENGTH_SHORT).show();
                            }

                            return true;
                        case R.id.btn_category:
                            loadFragment(new CategoryPageFragment());
                            return true;
                        case R.id.btn_me:
                            if (((SambilanApplication) getApplication()).isLoggedIn())
                                loadFragment(new ProfilePageFragment());
                            else
                                goToNextScreen(MainMenuActivity.this, LoginActivity.class);
                            return true;
                    }
                    return false;
                }
            };

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container, fragment)
                .commit();
    }

    public void goToNextScreen(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        startActivity(intent);
    }

    public void setLogout(Context context) {
        CacheManager.getInstance(context).remove(CacheManager.ROLE_KEY);
        CacheManager.getInstance(context).remove(CacheManager.TOKEN_KEY);

        ((SambilanApplication) getApplication()).setLoggedIn(false);
        ((SambilanApplication) getApplication()).deleteDB();
        ((SambilanApplication) getApplication()).setAppRole("");
        ((SambilanApplication) getApplication()).setAppToken("");

        //set token ""
        CacheManager.getInstance(this).saveString(CacheManager.TOKEN_KEY, ((SambilanApplication) getApplication()).getAppToken());
        CacheManager.getInstance(this).saveString(CacheManager.ROLE_KEY, ((SambilanApplication) getApplication()).getAppRole());

        bottomNavigationView.setSelectedItemId(R.id.btn_home);
        loadFragment(new LandingPageFragment());
    }
}
