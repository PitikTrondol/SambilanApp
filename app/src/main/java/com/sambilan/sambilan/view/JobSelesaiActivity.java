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
import com.sambilan.sambilan.view.adapter.JobSelesaiAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afriandi Haryanto on 1/26/2018.
 */

public class JobSelesaiActivity extends AppCompatActivity implements JobSelesaiAdapter.SelesaiListener{

    private RecyclerView recyclerSelesai;
    private JobSelesaiAdapter jobSelesaiAdapter;
    private List<Job> jobs;
    private LandingPagePresenter jobPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan);

        jobs = new ArrayList<>(); //biar gak null pointer
        jobPresenter = new LandingPagePresenter();
        jobPresenter.getJobList(jobCallback);

        jobSelesaiAdapter = new JobSelesaiAdapter(JobSelesaiActivity.this, jobs, this);
        recyclerSelesai = findViewById(R.id.rv_page_permintaan);
        recyclerSelesai.setLayoutManager(new LinearLayoutManager(JobSelesaiActivity.this));
        recyclerSelesai.setAdapter(jobSelesaiAdapter);
    }

    // create callback buat presenter
    private LandingPagePresenter.JobResultCallback jobCallback = new LandingPagePresenter.JobResultCallback() {
        @Override
        public void OnSuccessResult(List<Job> jobs) {
            JobSelesaiActivity.this.jobs.addAll(jobs);
            JobSelesaiActivity.this.jobSelesaiAdapter.notifyDataSetChanged();
        }

        @Override
        public void OnFailureResult(String errorMessage) {
            Toast.makeText(JobSelesaiActivity.this, ""+errorMessage, Toast.LENGTH_LONG)
                    .show();
        }
    };

    @Override
    public void onClickBeriPenilaian() {
        Toast.makeText(this, "LEMPAR BATA..!!", Toast.LENGTH_SHORT).show();
    }
}
