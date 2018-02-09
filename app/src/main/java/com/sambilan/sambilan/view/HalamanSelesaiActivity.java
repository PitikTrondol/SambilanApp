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
//import com.sambilan.sambilan.model.LandingPageResponse;
import com.sambilan.sambilan.model.response.FinishedResponse;
import com.sambilan.sambilan.presenter.FinishedPagePresenter;
import com.sambilan.sambilan.presenter.LandingPagePresenter;
import com.sambilan.sambilan.presenter.ResponseResultCallback;
import com.sambilan.sambilan.view.adapter.ListSelesaiAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListSelesaiListener;

/**
 * Created by Afriandi Haryanto on 1/26/2018.
 */

public class HalamanSelesaiActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView recyclerSelesai;
    private SwipeRefreshLayout refreshLayout;
    private ListSelesaiAdapter selesaiAdapter;
    private FinishedPagePresenter finishedPresenter;

    private int userId = 1;
    private final String SET_NILAI = "RATING";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan);
        progressBar = findViewById(R.id.progress_bar);
        recyclerSelesai = findViewById(R.id.common_recycler_view);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);

        finishedPresenter = new FinishedPagePresenter();
        finishedPresenter.getAllFinishedJobs(finishedCallback, userId);

        selesaiAdapter = new ListSelesaiAdapter(HalamanSelesaiActivity.this);
        selesaiAdapter.setListener(listener);
        recyclerSelesai.setLayoutManager(new LinearLayoutManager(HalamanSelesaiActivity.this));
        recyclerSelesai.setAdapter(selesaiAdapter);

        refreshLayout.setOnRefreshListener(refreshListener);
    }

    // create callback buat presenter
    private ResponseResultCallback<FinishedResponse, Throwable> finishedCallback =
            new ResponseResultCallback<FinishedResponse, Throwable>() {
                @Override
                public void OnSuccessResult(FinishedResponse first) {
                    selesaiAdapter.setModel(first.getData());
                    progressBar.setVisibility(View.GONE);
                    refreshLayout.setRefreshing(false);
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(HalamanSelesaiActivity.this,
                            "" + ((NullPointerException) second).getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            };

    private ResponseResultCallback<String, Throwable> penilaianCallback =
            new ResponseResultCallback<String, Throwable>() {
                @Override
                public void OnSuccessResult(String first) {
                    Toast.makeText(HalamanSelesaiActivity.this, "" + first,
                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(HalamanSelesaiActivity.this, "" + second.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            };

    private ListSelesaiListener listener = new ListSelesaiListener() {
        @Override
        public void onClickBeriPenilaian(int jobID) {
            postAndUpdateScreen(jobID, SET_NILAI);
        }
    };

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            finishedPresenter.getAllFinishedJobs(finishedCallback, userId);
        }
    };

    private void postAndUpdateScreen(int jobID, String rating) {
        finishedPresenter.postBeriPenilaian(penilaianCallback, userId, jobID, rating);
        finishedPresenter.getAllFinishedJobs(finishedCallback, userId);
    }
}
