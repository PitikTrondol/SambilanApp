package com.sambilan.sambilan.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sambilan.sambilan.R;

/**
<<<<<<< HEAD
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
=======
 * Created by Afriandi Haryanto on 1/23/2018.
 */

public class ProfilePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        LinearLayout layout = (LinearLayout) findViewById(R.id.ll_buttons);

        for (int i = 0; i < layout.getChildCount();i++) {

            layout.getChildAt(i).setOnClickListener(listener);
        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.btn_permintaan : {
                    Toast.makeText(ProfilePageActivity.this, "MINTA", Toast.LENGTH_SHORT).show();
                }
                break;

                case R.id.btn_menunggu : {
                    Toast.makeText(ProfilePageActivity.this, "NUNGGU", Toast.LENGTH_SHORT).show();
                }
                break;

                case R.id.btn_diterima : {
                    Toast.makeText(ProfilePageActivity.this, "TERIMA", Toast.LENGTH_SHORT).show();
                }
                break;

                case R.id.btn_selesai : {
                    Toast.makeText(ProfilePageActivity.this, "SELESAI", Toast.LENGTH_SHORT).show();
                }
                break;

                default:
                    Toast.makeText(ProfilePageActivity.this, "JINGAN"+v.getId(), Toast.LENGTH_SHORT).show();
            }
        }
    };
>>>>>>> [Afriandi]add new screen
}
