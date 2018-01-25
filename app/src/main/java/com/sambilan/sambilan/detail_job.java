package com.sambilan.sambilan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class detail_job extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_job);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
