package com.sambilan.sambilan.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.sambilan.sambilan.R;
//import com.sambilan.sambilan.model.LandingPageResponse;
import com.sambilan.sambilan.presenter.LandingPagePresenter;
import com.sambilan.sambilan.view.adapter.ListSelesaiAdapter;

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

//        jobPresenter = new LandingPagePresenter();
//        jobPresenter.getHomeJobList(jobCallback, 3,5);
//
//        selesaiAdapter = new ListSelesaiAdapter(HalamanSelesaiActivity.this);
//        selesaiAdapter.setListener(listener);
//        recyclerSelesai = findViewById(R.id.common_recycler_view);
//        recyclerSelesai.setLayoutManager(new LinearLayoutManager(HalamanSelesaiActivity.this));
//        recyclerSelesai.setAdapter(selesaiAdapter);
//
//        progressBar = findViewById(R.id.progress_bar);
//        refreshLayout = findViewById(R.id.swipe_refresh_layout);
//        refreshLayout.setOnRefreshListener(refreshListener);
    }

    // create callback buat presenter
//    private LandingPagePresenter.JobResultCallback<JobResponse, Throwable>
//            jobCallback = new LandingPagePresenter.JobResultCallback<JobResponse, Throwable>() {
//
//        @Override
//        public void OnSuccessResult(JobResponse first) {
//            selesaiAdapter.setModel(first.getData());
//            progressBar.setVisibility(View.GONE);
//            refreshLayout.setRefreshing(false);
//        }
//
//        @Override
//        public void OnFailureResult(Throwable second) {
//            if (second instanceof HttpException) {
//                Toast.makeText(HalamanSelesaiActivity.this,
//                        "" + ((HttpException) second).code(),
//                        Toast.LENGTH_SHORT).show();
//            } else if (second instanceof NullPointerException) {
//                Toast.makeText(HalamanSelesaiActivity.this,
//                        "" + ((NullPointerException) second).getMessage(),
//                        Toast.LENGTH_SHORT).show();
//            }
//        }
//    };
//
//    private ListSelesaiListener listener = new ListSelesaiListener() {
//        @Override
//        public void onClickBeriPenilaian() {
//            Toast.makeText(HalamanSelesaiActivity.this, "LEMPAR BATA..!!", Toast.LENGTH_SHORT).show();
//        }
//    };
//
//    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
//        @Override
//        public void onRefresh() {
//            jobPresenter.getHomeJobList(jobCallback,3,5);
//        }
//    };
}
