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
import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.model.response.EmployeeFlowResponse;
import com.sambilan.sambilan.presenter.EmployeeFlowPresenter;
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
    private EmployeeFlowPresenter employeeFlowPresenter;

    private int userId = 1;
    private String appToken;
    private final String SET_STATUS = "done";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan);
        appToken = ((SambilanApplication) getApplication()).getAppToken();

        progressBar = findViewById(R.id.progress_bar);
        recyclerSelesai = findViewById(R.id.common_recycler_view);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);

        employeeFlowPresenter = new EmployeeFlowPresenter();
        employeeFlowPresenter.getJobByStatus(finishedCallback, appToken, SET_STATUS);

        selesaiAdapter = new ListSelesaiAdapter(HalamanSelesaiActivity.this);
        selesaiAdapter.setListener(listener);
        recyclerSelesai.setLayoutManager(new LinearLayoutManager(HalamanSelesaiActivity.this));
        recyclerSelesai.setAdapter(selesaiAdapter);

        refreshLayout.setOnRefreshListener(refreshListener);
    }

    // create callback buat presenter
    private ResponseResultCallback<EmployeeFlowResponse, Throwable> finishedCallback =
            new ResponseResultCallback<EmployeeFlowResponse, Throwable>() {
                @Override
                public void OnSuccessResult(EmployeeFlowResponse first) {
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
            postAndUpdateScreen(jobID, SET_STATUS);
        }

        @Override
        public void onClickJob(int jobID) {
            Toast.makeText(HalamanSelesaiActivity.this, "Harusnya ke detail job id "+jobID,
                    Toast.LENGTH_SHORT).show();
        }
    };

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            employeeFlowPresenter.getJobByStatus(finishedCallback, appToken, SET_STATUS);
        }
    };

    private void postAndUpdateScreen(int jobID, String rating) {
//        employeeFlowPresenter.postBeriPenilaian(penilaianCallback, userId, jobID, rating);
        Toast.makeText(this, "Halaman Rating Belum Jadi", Toast.LENGTH_SHORT).show();
        employeeFlowPresenter.getJobByStatus(finishedCallback, appToken, SET_STATUS);
    }
}
