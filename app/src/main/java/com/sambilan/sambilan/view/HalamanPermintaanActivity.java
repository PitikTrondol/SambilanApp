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
import com.sambilan.sambilan.model.JobResponse;
import com.sambilan.sambilan.model.LandingPageResponse;
import com.sambilan.sambilan.presenter.LandingPagePresenter;
import com.sambilan.sambilan.view.adapter.ListPermintaanAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListPermintaanListener;

import java.util.List;

import retrofit2.HttpException;

/**
 * Created by Afriandi Haryanto on 1/25/2018.
 */

public class HalamanPermintaanActivity extends AppCompatActivity {

    private RecyclerView recyclerPermintaan;
    private ListPermintaanAdapter permintaanAdapter;
    private LandingPagePresenter jobPresenter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan);

        jobPresenter = new LandingPagePresenter();
        jobPresenter.getJobList(jobCallback);

        permintaanAdapter = new ListPermintaanAdapter(HalamanPermintaanActivity.this);
        permintaanAdapter.setListener(permintaanListener);

        recyclerPermintaan = findViewById(R.id.common_recycler_view);
        recyclerPermintaan.setLayoutManager(new LinearLayoutManager(HalamanPermintaanActivity.this));
        recyclerPermintaan.setAdapter(permintaanAdapter);

        progressBar = findViewById(R.id.progress_bar);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);
        refreshLayout.setOnRefreshListener(refreshListener);
    }

    // create callback buat presenter
    private LandingPagePresenter.JobResultCallback<LandingPageResponse, Throwable>
            jobCallback = new LandingPagePresenter.JobResultCallback<LandingPageResponse, Throwable>() {

        @Override
        public void OnSuccessResult(LandingPageResponse first) {
            permintaanAdapter.updateModel(first.getData());
            HalamanPermintaanActivity.this.refreshLayout.setRefreshing(false);
            HalamanPermintaanActivity.this.progressBar.setVisibility(View.GONE);
        }

        @Override
        public void OnFailureResult(Throwable second) {
            if (second instanceof HttpException) {
                Toast.makeText(HalamanPermintaanActivity.this,
                        "" + ((HttpException) second).code(),
                        Toast.LENGTH_SHORT).show();
            } else if (second instanceof NullPointerException) {
                Toast.makeText(HalamanPermintaanActivity.this,
                        "" + ((NullPointerException) second).getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
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

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            jobPresenter.getJobList(jobCallback);
        }
    };
}
