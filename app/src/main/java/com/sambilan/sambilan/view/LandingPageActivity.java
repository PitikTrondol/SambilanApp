package com.sambilan.sambilan.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.LinearLayout;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.JobResponse;
import com.sambilan.sambilan.model.LandingPageResponse;
import com.sambilan.sambilan.presenter.LandingPagePresenter;
import com.sambilan.sambilan.view.adapter.ListPekerjaanAdapter;
import com.sambilan.sambilan.view.adapter.SliderAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListJobListener;
import com.sambilan.sambilan.view.fragment.SliderFragment;
import com.sambilan.sambilan.view.helper.BottomNavigationHelper;
import com.sambilan.sambilan.view.helper.PageIndicatorHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.HttpException;

public class LandingPageActivity extends AppCompatActivity {

    private Toolbar topToolbar;
    private RecyclerView listJobRecyclerView;
    private LandingPagePresenter listJobPresenter;
    private ListPekerjaanAdapter listJobAdapter;

    private ViewPager carouselViewPager;
    private LinearLayout carouselLinearLayout;
    private SliderAdapter carouselSliderAdapter;
    private PageIndicatorHelper carouselPageIndicator;

    private BottomNavigationView bottomNavigationView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout recyclerRefresher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        // Implementasi untuk topbar, menu dan search button
        topToolbar = findViewById(R.id.topBar);
        setSupportActionBar(topToolbar);

        // Implementasi carousel
        carouselViewPager = findViewById(R.id.carousel_pager);
        carouselLinearLayout = findViewById(R.id.pagesContainer);

        carouselSliderAdapter = new SliderAdapter(getSupportFragmentManager(), getCarouselFragment());
        carouselViewPager.setAdapter(carouselSliderAdapter);
        carouselPageIndicator = new PageIndicatorHelper(this, carouselLinearLayout,
                carouselViewPager, R.drawable.indicator_circle);
        carouselPageIndicator.setPageCount(getCarouselFragment().size());
        carouselPageIndicator.show();

        // Implementasi untuk recyclerview
        listJobPresenter = new LandingPagePresenter();
        listJobPresenter.getJobList(jobCallback);

        listJobAdapter = new ListPekerjaanAdapter(LandingPageActivity.this);
        listJobAdapter.setListener(jobListener);

        listJobRecyclerView = findViewById(R.id.common_recycler_view);
        listJobRecyclerView.setLayoutManager(new LinearLayoutManager(LandingPageActivity.this));
        listJobRecyclerView.setAdapter(listJobAdapter);

        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        recyclerRefresher = findViewById(R.id.swipe_refresh_layout);
        recyclerRefresher.setOnRefreshListener(refreshListener);

        // Implementasi bottom nav bar
        bottomNavigationView = findViewById(R.id.btn_bottomnav);
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        carouselPageIndicator.cleanup();
    }

    /**
     * -------------------------------------------------------------------
     * Implementation override for top bar menus (filter and notification)
     * -------------------------------------------------------------------
     **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_notif:
                Toast.makeText(LandingPageActivity.this, "Login dulu lah", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_filter:
                Toast.makeText(LandingPageActivity.this, "Menu Filter", Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }

    /**
     * ---------------------------
     * Implementasi untuk carousel
     * ---------------------------
     */

    private List<Fragment> getCarouselFragment() {
        List<Fragment> fragments = new ArrayList<>();
        String baseUrl = "https://trello-attachments.s3.amazonaws.com/5a54ee3b0dd4ebd39048d99c/5a5a29f1f4bb54c9978613fe/";

        fragments.add(SliderFragment.newInstance(baseUrl + "9ca5c580be3b78eab3f2bb2ebf117a89/couresel.png"));
        fragments.add(SliderFragment.newInstance(baseUrl + "848ff359644146c6f24e797601c437ed/couresel2.png"));
        fragments.add(SliderFragment.newInstance(baseUrl + "fdad02c8caf4ba33379169bfd74eee45/couresel3.png"));

        return fragments;
    }

    /**
     * ---------------------------
     * Implementasi untuk job list
     * ---------------------------
     */
    private ListJobListener jobListener = new ListJobListener() {
        @Override
        public void onClickJob() {
            Intent profileIntent = new Intent(LandingPageActivity.this, DetailJobActivity.class);
            startActivity(profileIntent);
        }
    };

    // create callback buat presenter
    private LandingPagePresenter.JobResultCallback<LandingPageResponse, Throwable>
            jobCallback = new LandingPagePresenter.JobResultCallback<LandingPageResponse, Throwable>() {

        @Override
        public void OnSuccessResult(LandingPageResponse first) {
            listJobAdapter.updateModel(first.getData());
            LandingPageActivity.this.progressBar.setVisibility(View.GONE);
            LandingPageActivity.this.recyclerRefresher.setRefreshing(false);
        }

        @Override
        public void OnFailureResult(Throwable second) {

            if (second instanceof HttpException) {
                Toast.makeText(LandingPageActivity.this,
                        "JEMBUT " + ((HttpException) second).code(),
                        Toast.LENGTH_SHORT).show();
            } else if (second instanceof NullPointerException) {
                Toast.makeText(LandingPageActivity.this,
                        "TELEK " + ((NullPointerException) second).getMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LandingPageActivity.this,
                        "TELEK " + second.getMessage(),
                        Toast.LENGTH_SHORT).show();

                System.out.println("TELEK "+second.getMessage());
            }

            LandingPageActivity.this.progressBar.setVisibility(View.GONE);
            LandingPageActivity.this.recyclerRefresher.setRefreshing(false);
        }
    };

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            listJobPresenter.getJobList(jobCallback);
        }
    };

    /**
     * ------------------------------------
     * Implementasi untuk bottom navigation
     * ------------------------------------
     **/
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.btn_home:
                    return true;
                case R.id.btn_add:
                    Toast.makeText(getApplicationContext(), "Tambah", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.btn_category:
                    Toast.makeText(getApplicationContext(), "Kategori", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.btn_me:
                    Intent profileIntent = new Intent(LandingPageActivity.this, ProfilePageActivity.class);
                    startActivity(profileIntent);
                    return true;
            }
            return false;
        }
    };
}
