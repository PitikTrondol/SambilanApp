package com.sambilan.sambilan.view;

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

/**
 * Created by Afriandi Haryanto on 1/22/2018.
 */

public class ProfilePageActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        BottomNavigationView nav =  findViewById(R.id.btn_bottomnav_profile);
        nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_permintaan:{
                Toast.makeText(this, "Permintaan", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.btn_menunggu:{
                Toast.makeText(this, "Menunggu", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.btn_diterima:{
                Toast.makeText(this, "Diterima", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.btn_selesai:{
                Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.btn_home:
                    Intent intentHome = new Intent(ProfilePageActivity.this,LandingPageActivity.class);
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
