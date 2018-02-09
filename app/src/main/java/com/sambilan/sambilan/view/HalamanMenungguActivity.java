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
import com.sambilan.sambilan.model.response.WaitingPageResponse;
import com.sambilan.sambilan.presenter.ResponseResultCallback;
import com.sambilan.sambilan.presenter.WaitingPagePresenter;
import com.sambilan.sambilan.view.adapter.ListMenungguAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListMenungguListener;

public class HalamanMenungguActivity extends AppCompatActivity {

    private RecyclerView recyclerMenunggu;
    private ListMenungguAdapter menungguAdapter;
    private WaitingPagePresenter waitingPagePresenter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout refreshLayout;

    private int userId = 1;
    private final String SET_BATAL = "CANCEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menunggu);

        recyclerMenunggu = findViewById(R.id.common_recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);

        waitingPagePresenter = new WaitingPagePresenter();
        waitingPagePresenter.getAllWaitingList(waitingPageCallback, userId);

        menungguAdapter = new ListMenungguAdapter(HalamanMenungguActivity.this);
        menungguAdapter.setListener(menungguListener);

        recyclerMenunggu.setLayoutManager(new LinearLayoutManager(HalamanMenungguActivity.this));
        recyclerMenunggu.setAdapter(menungguAdapter);

        refreshLayout.setOnRefreshListener(refreshListener);
    }

    private ResponseResultCallback<WaitingPageResponse, Throwable> waitingPageCallback =
            new ResponseResultCallback<WaitingPageResponse, Throwable>() {
                @Override
                public void OnSuccessResult(WaitingPageResponse first) {
                    menungguAdapter.setModel(first.getData());
                    clearLoading();
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(HalamanMenungguActivity.this,
                            "FAILURE", Toast.LENGTH_SHORT).show();
                }
            };

    private ResponseResultCallback<String, Throwable> cancelCallback =
            new ResponseResultCallback<String, Throwable>() {
                @Override
                public void OnSuccessResult(String first) {
                    Toast.makeText(HalamanMenungguActivity.this,
                            ""+first, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(HalamanMenungguActivity.this,
                            ""+second.getMessage(), Toast.LENGTH_SHORT).show();
                }
            };

    private ListMenungguListener menungguListener =
            new ListMenungguListener() {
                @Override
                public void onClickBatalkan(int jobID) {
                    Toast.makeText(HalamanMenungguActivity.this, "BATALKAN JOB "+jobID,
                            Toast.LENGTH_SHORT).show();
                    postAndUpdate(jobID, SET_BATAL);
                }
            };

    private SwipeRefreshLayout.OnRefreshListener refreshListener =
            new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    waitingPagePresenter.getAllWaitingList(waitingPageCallback, userId);
                }
            };

    private void clearLoading() {
        progressBar.setVisibility(View.GONE);
        refreshLayout.setRefreshing(false);
    }

    private void postAndUpdate(int jobID, String cancel) {
        waitingPagePresenter.postCancelWaitingJob(cancelCallback, userId, jobID, cancel);
        waitingPagePresenter.getAllWaitingList(waitingPageCallback, userId);
    }
}
