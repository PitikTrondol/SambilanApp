package com.sambilan.sambilan.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.presenter.LandingPagePresenter;
import com.sambilan.sambilan.view.adapter.ListPermintaanAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListPermintaanListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afriandi Haryanto on 1/25/2018.
 */

public class HalamanPermintaanActivity extends AppCompatActivity {

    private RecyclerView recyclerPermintaan;
    private ListPermintaanAdapter permintaanAdapter;
    private List<Job> jobs;
    private LandingPagePresenter jobPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan);

        jobs = new ArrayList<>(); //biar gak null pointer
        jobPresenter = new LandingPagePresenter();
        jobPresenter.getJobList(jobCallback);

        permintaanAdapter = new ListPermintaanAdapter(HalamanPermintaanActivity.this);
        permintaanAdapter.setListener(permintaanListener);
        recyclerPermintaan = findViewById(R.id.rv_page_permintaan);
        recyclerPermintaan.setLayoutManager(new LinearLayoutManager(HalamanPermintaanActivity.this));
        recyclerPermintaan.setAdapter(permintaanAdapter);
    }

    // create callback buat presenter
    private LandingPagePresenter.JobResultCallback jobCallback = new LandingPagePresenter.JobResultCallback() {
        @Override
        public void OnSuccessResult(List<Job> jobs) {
            permintaanAdapter.updateModel(jobs);
        }

        @Override
        public void OnFailureResult(String errorMessage) {
            Toast.makeText(HalamanPermintaanActivity.this, ""+errorMessage, Toast.LENGTH_LONG)
                    .show();
        }
    };

    private ListPermintaanListener permintaanListener = new ListPermintaanListener() {
        @Override
        public void onClickButtonTerima() {
            Toast.makeText(HalamanPermintaanActivity.this, "DITERIMA", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onClickButtonTolak() {
            Toast.makeText(HalamanPermintaanActivity.this, "DITOLAK", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onClickListPermintaan() {
            Toast.makeText(HalamanPermintaanActivity.this, "KE DATAIL JOB", Toast.LENGTH_SHORT).show();
        }
    };
}
