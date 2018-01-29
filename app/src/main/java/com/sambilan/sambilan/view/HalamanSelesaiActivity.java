package com.sambilan.sambilan.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.presenter.LandingPagePresenter;
import com.sambilan.sambilan.view.adapter.ListSelesaiAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListSelesaiListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afriandi Haryanto on 1/26/2018.
 */

public class HalamanSelesaiActivity extends AppCompatActivity{

    private ProgressBar progressBar;
    private RecyclerView recyclerSelesai;
    private SwipeRefreshLayout refreshLayout;
    private LandingPagePresenter jobPresenter;
    private ListSelesaiAdapter selesaiAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan);

        jobPresenter = new LandingPagePresenter();
        jobPresenter.getJobList(jobCallback);

        selesaiAdapter = new ListSelesaiAdapter(HalamanSelesaiActivity.this);
        selesaiAdapter.setListener(listener);
        recyclerSelesai = findViewById(R.id.common_recycler_view);
        recyclerSelesai.setLayoutManager(new LinearLayoutManager(HalamanSelesaiActivity.this));
        recyclerSelesai.setAdapter(selesaiAdapter);

        progressBar = findViewById(R.id.progress_bar);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);
        refreshLayout.setOnRefreshListener(refreshListener);
    }

    // create callback buat presenter
    private LandingPagePresenter.JobResultCallback jobCallback = new LandingPagePresenter.JobResultCallback() {
        @Override
        public void OnSuccessResult(List<Job> jobs) {
            selesaiAdapter.updateModel(jobs);
            progressBar.setVisibility(View.GONE);
            refreshLayout.setRefreshing(false);
        }

        @Override
        public void OnFailureResult(String errorMessage) {
            Toast.makeText(HalamanSelesaiActivity.this, ""+errorMessage, Toast.LENGTH_LONG)
                    .show();
        }
    };

    private ListSelesaiListener listener = new ListSelesaiListener() {
        @Override
        public void onClickBeriPenilaian() {
            Toast.makeText(HalamanSelesaiActivity.this, "LEMPAR BATA..!!", Toast.LENGTH_SHORT).show();
        }
    };

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            jobPresenter.getJobList(jobCallback);
        }
    };
}
