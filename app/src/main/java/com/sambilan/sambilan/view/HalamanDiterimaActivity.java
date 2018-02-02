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
import com.sambilan.sambilan.model.JobListResponse;
import com.sambilan.sambilan.model.LandingPageResponse;
import com.sambilan.sambilan.presenter.LandingPagePresenter;
import com.sambilan.sambilan.presenter.ListJobPresenter;
import com.sambilan.sambilan.view.adapter.ListDiterimaAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListDiterimaListener;

import retrofit2.HttpException;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class HalamanDiterimaActivity extends AppCompatActivity {
    private RecyclerView recyclerDiterima;
    private ListDiterimaAdapter diterimaAdapter;
    private ListJobPresenter jobPresenter;
    private SwipeRefreshLayout refreshLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diterima);
        jobPresenter = new ListJobPresenter();
        jobPresenter.getListJobs(jobCallBack,1);

        diterimaAdapter = new ListDiterimaAdapter(HalamanDiterimaActivity.this);
        diterimaAdapter.setListener(diterimaListener);

        recyclerDiterima = findViewById(R.id.common_recycler_view);
        recyclerDiterima.setLayoutManager(new LinearLayoutManager(HalamanDiterimaActivity.this));
        recyclerDiterima.setAdapter(diterimaAdapter);

        progressBar = findViewById(R.id.progress_bar);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);
        refreshLayout.setOnRefreshListener(refreshListener);
    }
//    private LandingPagePresenter.JobResultCallback<LandingPageResponse, Throwable>
//            jobCallback = new LandingPagePresenter.JobResultCallback<LandingPageResponse, Throwable>() {


        private ListJobPresenter.JobResultCallback<JobListResponse, Throwable> jobCallBack = new ListJobPresenter.JobResultCallback<JobListResponse, Throwable>() {

        @Override
        public void OnSuccessResult(JobListResponse first) {
            diterimaAdapter.updateModel(first.getData());
            HalamanDiterimaActivity.this.refreshLayout.setRefreshing(false);
            HalamanDiterimaActivity.this.progressBar.setVisibility(View.GONE);
        }
        @Override
        public void OnFailureResult(Throwable second) {
            if (second instanceof HttpException) {
                Toast.makeText(HalamanDiterimaActivity.this,
                        "" + ((HttpException) second).code(),
                        Toast.LENGTH_SHORT).show();
            } else if (second instanceof NullPointerException) {
                Toast.makeText(HalamanDiterimaActivity.this,
                        "" + ((NullPointerException) second).getMessage(),
                        Toast.LENGTH_SHORT).show();
            }

        }
    };

    private ListDiterimaListener diterimaListener = new ListDiterimaListener() {
        @Override
        public void onClickDiterima() {
            Toast.makeText(HalamanDiterimaActivity.this,"",Toast.LENGTH_SHORT).show();
        }
    };

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            jobPresenter.getListJobs(jobCallBack,1);
        }
    };

}
