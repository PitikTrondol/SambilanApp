package com.sambilan.sambilan.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.utils.CacheManager;
import com.sambilan.sambilan.SambilanApplication;

/**
 * Created by Andhika Putranto on 1/14/2018.
 */

public class SplashScreenActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 4000;
    CacheManager cacheManager;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        cacheManager = CacheManager.getInstance(SplashScreenActivity.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(SplashScreenActivity.this, MainMenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
