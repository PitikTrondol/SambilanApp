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
import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.model.response.EmployeeFlowResponse;
import com.sambilan.sambilan.presenter.EmployeeFlowPresenter;
import com.sambilan.sambilan.presenter.ResponseResultCallback;
import com.sambilan.sambilan.view.adapter.employee.ListMenungguAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListMenungguListener;

public class HalamanMenungguActivity extends AppCompatActivity {

    private RecyclerView recyclerMenunggu;
    private ListMenungguAdapter menungguAdapter;
    private EmployeeFlowPresenter employeeFlowPresenter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout refreshLayout;

    private final String SET_STATUS = "waiting";
    private String appToken;

    private int userId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menunggu);
        appToken = ((SambilanApplication) getApplication()).getAppToken();

        recyclerMenunggu = findViewById(R.id.common_recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);

        employeeFlowPresenter = new EmployeeFlowPresenter();
        employeeFlowPresenter.getJobByStatus(waitingPageCallback, appToken, SET_STATUS);

        menungguAdapter = new ListMenungguAdapter(HalamanMenungguActivity.this);
        menungguAdapter.setListener(menungguListener);

        recyclerMenunggu.setLayoutManager(new LinearLayoutManager(HalamanMenungguActivity.this));
        recyclerMenunggu.setAdapter(menungguAdapter);

        refreshLayout.setOnRefreshListener(refreshListener);
    }

    private ResponseResultCallback<EmployeeFlowResponse, Throwable> waitingPageCallback =
            new ResponseResultCallback<EmployeeFlowResponse, Throwable>() {
                @Override
                public void OnSuccessResult(EmployeeFlowResponse first) {
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
                            "Cancel Pekerjaan Berhasil", Toast.LENGTH_SHORT).show();

                    employeeFlowPresenter.getJobByStatus(waitingPageCallback, appToken, SET_STATUS);
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
                    postAndUpdate(jobID);
                }

                @Override
                public void onClickJob(int id) {
                    Toast.makeText(HalamanMenungguActivity.this, "Harusnya ke detail job "+id,
                            Toast.LENGTH_SHORT).show();
                }
            };

    private SwipeRefreshLayout.OnRefreshListener refreshListener =
            new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    employeeFlowPresenter.getJobByStatus(waitingPageCallback, appToken, SET_STATUS);
                }
            };

    private void clearLoading() {
        progressBar.setVisibility(View.GONE);
        refreshLayout.setRefreshing(false);
    }

    private void postAndUpdate(int jobID) {
        employeeFlowPresenter.cancelWaitingJob(cancelCallback, appToken, jobID);
        employeeFlowPresenter.getJobByStatus(waitingPageCallback, appToken, SET_STATUS);
    }
}
