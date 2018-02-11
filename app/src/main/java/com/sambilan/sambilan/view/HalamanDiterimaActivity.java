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
import com.sambilan.sambilan.view.adapter.ListDiterimaAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListDiterimaListener;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class HalamanDiterimaActivity extends AppCompatActivity {
    private RecyclerView recyclerDiterima;
    private ListDiterimaAdapter diterimaAdapter;
    private SwipeRefreshLayout refreshLayout;
    private ProgressBar progressBar;
    private EmployeeFlowPresenter employeeFlowPresenter;

    private int userId = 1;
    private String appToken;
    private final String SET_STATUS = "accepted";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diterima);
        appToken = ((SambilanApplication) getApplication()).getAppToken();

        recyclerDiterima = findViewById(R.id.common_recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);

        employeeFlowPresenter = new EmployeeFlowPresenter();
        employeeFlowPresenter.getJobByStatus(acceptedCallBack, appToken, SET_STATUS);

        diterimaAdapter = new ListDiterimaAdapter(HalamanDiterimaActivity.this);
        diterimaAdapter.setListener(diterimaListener);

        recyclerDiterima.setLayoutManager(new LinearLayoutManager(HalamanDiterimaActivity.this));
        recyclerDiterima.setAdapter(diterimaAdapter);

        refreshLayout.setOnRefreshListener(refreshListener);
    }

    private ResponseResultCallback<EmployeeFlowResponse, Throwable> acceptedCallBack =
            new ResponseResultCallback<EmployeeFlowResponse, Throwable>() {

                @Override
                public void OnSuccessResult(EmployeeFlowResponse first) {
                    diterimaAdapter.setModel(first.getData());
                    clearLoading();
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(HalamanDiterimaActivity.this,
                            "" + ((NullPointerException) second).getMessage(),
                            Toast.LENGTH_SHORT).show();
                    clearLoading();
                }
            };

    private ListDiterimaListener diterimaListener = new ListDiterimaListener() {
        @Override
        public void onClickDiterima(int jobID) {
            Toast.makeText(HalamanDiterimaActivity.this, "Harusnya masuk detail job ID : " + jobID,
                    Toast.LENGTH_SHORT).show();
        }
    };

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            employeeFlowPresenter.getJobByStatus(acceptedCallBack, appToken, SET_STATUS);
        }
    };

    private void clearLoading() {
        progressBar.setVisibility(View.GONE);
        refreshLayout.setRefreshing(false);
    }
}
