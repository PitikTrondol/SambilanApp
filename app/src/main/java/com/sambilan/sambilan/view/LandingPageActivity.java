package com.sambilan.sambilan.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;
import android.widget.LinearLayout;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.presenter.JobPresenter;
import com.sambilan.sambilan.view.adapter.ListJobAdapter;
import com.sambilan.sambilan.view.adapter.SliderAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListJobListener;
import com.sambilan.sambilan.view.fragment.SliderFragment;

import java.util.ArrayList;
import java.util.List;

public class LandingPageActivity extends AppCompatActivity {

    private Toolbar topBarMenu;
    private RecyclerView recyclerViewJobOffer;
    private JobPresenter jobPresenter;
    private ListJobAdapter jobAdapter;

    ViewPager pager;
    LinearLayout linearLayout;
    SliderAdapter adapter;
    PageIndicator Indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        pager = findViewById(R.id.pager);
        linearLayout = findViewById(R.id.pagesContainer);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(SliderFragment.newInstance("https://trello-attachments.s3.amazonaws.com/5a54ee3b0dd4ebd39048d99c/5a5a29f1f4bb54c9978613fe/9ca5c580be3b78eab3f2bb2ebf117a89/couresel.png"));
        fragments.add(SliderFragment.newInstance("https://trello-attachments.s3.amazonaws.com/5a54ee3b0dd4ebd39048d99c/5a5a29f1f4bb54c9978613fe/848ff359644146c6f24e797601c437ed/couresel2.png"));
        fragments.add(SliderFragment.newInstance("https://trello-attachments.s3.amazonaws.com/5a54ee3b0dd4ebd39048d99c/5a5a29f1f4bb54c9978613fe/fdad02c8caf4ba33379169bfd74eee45/couresel3.png"));
        adapter = new SliderAdapter(getSupportFragmentManager(), fragments);
        pager.setAdapter(adapter);
        Indicator = new PageIndicator(this, linearLayout, pager, R.drawable.indicator_circle);
        Indicator.setPageCount(fragments.size());
        Indicator.show();


        /**
        * Implementasi untuk topbar, menu dan search button
        */
        topBarMenu = (Toolbar) findViewById(R.id.topBar);
        setSupportActionBar(topBarMenu);

        /**
         * Implementasi untuk recyclerview
         * createJobApi adapter
         * createJobApi recycler
         * setLayoutManager buat menetukan dia type recycler mana
         * (linear vertikal / linear horizontal / grid)
         * setAdapter
         */

        jobPresenter = new JobPresenter();
        jobPresenter.getJobList(jobCallback);
        jobAdapter = new ListJobAdapter(LandingPageActivity.this);
        jobAdapter.setListener(jobListener);

        recyclerViewJobOffer = findViewById(R.id.rv_joblist);
        recyclerViewJobOffer.setLayoutManager(new LinearLayoutManager(LandingPageActivity.this));
        recyclerViewJobOffer.setAdapter(jobAdapter);

        /**
         * Implementasi bottom nav bar
         */
        BottomNavigationView nav =  findViewById(R.id.btn_bottomnav);
        BottomNavigationViewHelper.disableShiftMode(nav);
        nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Indicator.cleanup();
    }

    /**
     * Implementation override for top bar menus (filter and notification)
     * ----------------------------------------------------------------------
     **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_notif) {
            Toast.makeText(LandingPageActivity.this, "Login dulu lah", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_filter) {
            Toast.makeText(LandingPageActivity.this, "Menu Filter", Toast.LENGTH_SHORT).show();
            return true;
        }
        return true;
    }

    /** ------------------------------------------
     *  Implementasi untuk job list
     *  ------------------------------------------
     */
    private ListJobListener jobListener = new ListJobListener() {
        @Override
        public void onClickJob() {
            Toast.makeText(LandingPageActivity.this, "KEPENCEEEET", Toast.LENGTH_SHORT).show();
        }
    };

    // create callback buat presenter
    private JobPresenter.JobResultCallback jobCallback = new JobPresenter.JobResultCallback() {
        @Override
        public void OnSuccessResult(List<Job> jobs) {
            jobAdapter.updateModel(jobs);
        }

        @Override
        public void OnFailureResult(String errorMessage) {
            Toast.makeText(LandingPageActivity.this, ""+errorMessage, Toast.LENGTH_LONG)
                    .show();
        }
    };

    /** ------------------------------------------
     *  Implementasi untuk bottom navigation
     *  ------------------------------------------
     **/
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.btn_home:
//                    bikin crash kalo dipencet pas di landing page
//                    Intent intentHome = new Intent(LandingPageActivity.this,LandingPageActivity.class);
//                    startActivity(intentHome);
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
