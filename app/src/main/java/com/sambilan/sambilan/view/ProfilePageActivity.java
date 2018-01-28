package com.sambilan.sambilan.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.view.helper.BottomNavigationHelper;

/**
 * Created by Afriandi Haryanto on 1/22/2018.
 */

public class ProfilePageActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll_profileFungsi;
//    private ImageView iv_permintaan;
//    private ImageView iv_menunggu;
//    private ImageView iv_diterima;
//    private ImageView iv_selesai;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        ll_profileFungsi = findViewById(R.id.ll_profile_fungsi);
        for (int i = 0; i < ll_profileFungsi.getChildCount(); i++) {
            ll_profileFungsi.getChildAt(i).setOnClickListener(ProfilePageActivity.this);
        }

        BottomNavigationView nav = findViewById(R.id.btn_bottomnav_profile);
        BottomNavigationHelper.disableShiftMode(nav);
        nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_permintaan: {
                GoToNextScreen(ProfilePageActivity.this, JobPermintaanActivity.class);
            }
            break;

            case R.id.iv_menunggu: {
                Toast.makeText(this, "Menunggu", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.iv_diterima: {
                Toast.makeText(this, "Diterima", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.iv_selesai: {
                GoToNextScreen(ProfilePageActivity.this, JobSelesaiActivity.class);
            }
            break;
        }
    }

    private void GoToNextScreen(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        startActivity(intent);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.btn_home:
                    Intent intentHome = new Intent(ProfilePageActivity.this, LandingPageActivity.class);
                    startActivity(intentHome);
                    return true;
                case R.id.btn_add:
                    Toast.makeText(getApplicationContext(), "Tambah", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.btn_category:
                    Toast.makeText(getApplicationContext(), "Kategori", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.btn_me:
                    Intent profileIntent = new Intent(ProfilePageActivity.this, ProfilePageActivity.class);
                    startActivity(profileIntent);
                    return true;
            }
            return false;
        }
    };
}
