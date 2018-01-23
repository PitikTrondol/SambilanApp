package com.sambilan.sambilan.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

        View layout = (View) findViewById(R.id.ll_buttons);
        layout.setOnClickListener(ProfilePageActivity.this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_permintaan:{
                Toast.makeText(this, "ASU", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.btn_menunggu:{
                Toast.makeText(this, "GENJIK", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.btn_diterima:{
                Toast.makeText(this, "CELENG", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.btn_selesai:{
                Toast.makeText(this, "JINGAN", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }
}
