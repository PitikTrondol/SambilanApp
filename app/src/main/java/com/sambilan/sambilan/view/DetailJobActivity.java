package com.sambilan.sambilan.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sambilan.sambilan.R;

public class DetailJobActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_job);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
