package com.sambilan.sambilan.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.LandingPageResponse;
import com.sambilan.sambilan.presenter.LandingPagePresenter;
import com.sambilan.sambilan.view.adapter.ListMenungguAdapter;
import com.sambilan.sambilan.view.adapter.ListPermintaanAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListMenungguListener;

public class HalamanMenungguActivity extends AppCompatActivity {

    private RecyclerView recyclerMenunggu;
    private ListMenungguAdapter menungguAdapter;
    private LandingPagePresenter jobPresenter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menunggu);

        jobPresenter = new LandingPagePresenter();
        jobPresenter.getAllResources(jobCallback);

        menungguAdapter = new ListMenungguAdapter(HalamanMenungguActivity.this);
        menungguAdapter.setListener(menungguListener);

        recyclerMenunggu = findViewById(R.id.common_recycler_view);
        recyclerMenunggu.setLayoutManager(new LinearLayoutManager(HalamanMenungguActivity.this));
        recyclerMenunggu.setAdapter(menungguAdapter);

        progressBar = findViewById(R.id.progress_bar);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);
        refreshLayout.setOnRefreshListener(refreshListener);
    }

    private LandingPagePresenter.JobResultCallback<LandingPageResponse, Throwable>
            jobCallback = new LandingPagePresenter.JobResultCallback<LandingPageResponse, Throwable>() {
        @Override
        public void OnSuccessResult(LandingPageResponse first) {
            menungguAdapter.updateModel(first.getData());
            HalamanMenungguActivity.this.refreshLayout.setRefreshing(false);
            HalamanMenungguActivity.this.progressBar.setVisibility(View.GONE);
        }

        @Override
        public void OnFailureResult(Throwable second) {
            Toast.makeText(HalamanMenungguActivity.this, "FAILURE", Toast.LENGTH_SHORT).show();
        }
    };

    private ListMenungguListener menungguListener = new ListMenungguListener() {
        @Override
        public void onClickBatalkan() {
            Toast.makeText(HalamanMenungguActivity.this, "DIBATALKAN", Toast.LENGTH_SHORT).show();
        }
    };

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            jobPresenter.getAllResources(jobCallback);
        }
    };
}
