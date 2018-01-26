package com.sambilan.sambilan.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.presenter.JobPresenter;
import com.sambilan.sambilan.view.adapter.JobPermintaanAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afriandi Haryanto on 1/25/2018.
 */

public class JobPermintaanActivity extends AppCompatActivity implements JobPermintaanAdapter.PermintaanListener{

    private RecyclerView recyclerPermintaan;
    private JobPermintaanAdapter permintaanAdapter;
    private List<Job> jobs;
    private JobPresenter jobPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan);

        jobs = new ArrayList<>(); //biar gak null pointer
        jobPresenter = new JobPresenter();
        jobPresenter.getJobList(jobCallback);

        permintaanAdapter = new JobPermintaanAdapter(JobPermintaanActivity.this, jobs, this);
        recyclerPermintaan = findViewById(R.id.rv_page_permintaan);
        recyclerPermintaan.setLayoutManager(new LinearLayoutManager(JobPermintaanActivity.this));
        recyclerPermintaan.setAdapter(permintaanAdapter);
    }

    // create callback buat presenter
    private JobPresenter.JobResultCallback jobCallback = new JobPresenter.JobResultCallback() {
        @Override
        public void OnSuccessResult(List<Job> jobs) {
            JobPermintaanActivity.this.jobs.addAll(jobs);
            JobPermintaanActivity.this.permintaanAdapter.notifyDataSetChanged();
        }

        @Override
        public void OnFailureResult(String errorMessage) {
            Toast.makeText(JobPermintaanActivity.this, ""+errorMessage, Toast.LENGTH_LONG)
                    .show();
        }
    };

    @Override
    public void onClickPermintaanItem() {
        Toast.makeText(this, "HARUSNYA SIH KE DETAIL JOB, TAPIIIII..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickTerima() {

        Toast.makeText(this, "DITERIMA", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickTolak() {
        Toast.makeText(this, "DITOLAK ? CIAN..", Toast.LENGTH_SHORT).show();
    }
}
