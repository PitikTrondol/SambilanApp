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
import com.sambilan.sambilan.model.response.InvitationResponse;
import com.sambilan.sambilan.model.response.JobResponse;
import com.sambilan.sambilan.presenter.InvitationPagePresenter;
import com.sambilan.sambilan.presenter.ResponseResultCallback;
import com.sambilan.sambilan.view.adapter.ListPermintaanAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListPermintaanListener;

/**
 * Created by Afriandi Haryanto on 1/25/2018.
 */

public class HalamanPermintaanActivity extends AppCompatActivity {

    private RecyclerView recyclerPermintaan;
    private ListPermintaanAdapter permintaanAdapter;
    private InvitationPagePresenter invitationPresenter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan);

        invitationPresenter = new InvitationPagePresenter();
        invitationPresenter.getJobInvitation(permintaanCallback, 1);

        permintaanAdapter = new ListPermintaanAdapter(HalamanPermintaanActivity.this);
        permintaanAdapter.setListener(permintaanListener);

        recyclerPermintaan = findViewById(R.id.common_recycler_view);
        recyclerPermintaan.setLayoutManager(new LinearLayoutManager(HalamanPermintaanActivity.this));
        recyclerPermintaan.setAdapter(permintaanAdapter);

        progressBar = findViewById(R.id.progress_bar);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);
        refreshLayout.setOnRefreshListener(refreshListener);
    }

    private ResponseResultCallback<InvitationResponse, Throwable> permintaanCallback =
            new ResponseResultCallback<InvitationResponse, Throwable>() {
                @Override
                public void OnSuccessResult(InvitationResponse first) {
                    permintaanAdapter.setModel(first.getData());
                    clearLoading();
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(HalamanPermintaanActivity.this, "Halaman Permintaan Error",
                            Toast.LENGTH_SHORT).show();
                    clearLoading();
                }
            };

    private ListPermintaanListener permintaanListener =
            new ListPermintaanListener() {
                @Override
                public void onClickButtonTerima(int jobID) {
                    postAndUpdate();
                }

                @Override
                public void onClickButtonTolak(int jobID) {
                    postAndUpdate();
                }

                @Override
                public void onClickListPermintaan(int jobID) {
                    Toast.makeText(HalamanPermintaanActivity.this, "KE DETAIL JOB", Toast.LENGTH_SHORT).show();
                }
            };

    private SwipeRefreshLayout.OnRefreshListener refreshListener =
            new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    invitationPresenter.getJobInvitation(permintaanCallback, 1);
                }
            };

    private ResponseResultCallback<String, Throwable> actionCallback =
            new ResponseResultCallback<String, Throwable>() {
                @Override
                public void OnSuccessResult(String first) {
                    Toast.makeText(HalamanPermintaanActivity.this, ""+first, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(HalamanPermintaanActivity.this, ""+second.getMessage(), Toast.LENGTH_SHORT).show();
                }
            };

    private void postAndUpdate () {
        invitationPresenter.postInvitAction(actionCallback, 1 , 1, "agree");
        invitationPresenter.getJobInvitation(permintaanCallback, 1);
    }

    private void clearLoading() {
        progressBar.setVisibility(View.GONE);
        refreshLayout.setRefreshing(false);
    }

}
