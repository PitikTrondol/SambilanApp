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
import com.sambilan.sambilan.BottomNavigationViewHelper;
import com.sambilan.sambilan.PageIndicator;
import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.presenter.JobPresenter;
import android.widget.LinearLayout;

import com.sambilan.sambilan.view.adapter.SliderAdapter;
import com.sambilan.sambilan.view.fragment.SliderFragment;
import com.sambilan.sambilan.view.adapter.JobItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class LandingPageActivity extends AppCompatActivity implements JobItemAdapter.JobItemListener {

    private Toolbar topBarMenu;
    private RecyclerView recyclerViewJobOffer;
    private JobItemAdapter jobItemAdapter;
    private List<Job> jobs;
    private JobPresenter jobPresenter;

    ViewPager pager;
    LinearLayout linearLayout;
    SliderAdapter adapter;
    PageIndicator Indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        BottomNavigationView navigation = findViewById(R.id.btn_bottomnav);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

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

        jobs = new ArrayList<>(); //biar gak null pointer
        jobPresenter = new JobPresenter();
        jobPresenter.getJobList(jobCallback);

        jobItemAdapter = new JobItemAdapter(LandingPageActivity.this, jobs, this);
        recyclerViewJobOffer = findViewById(R.id.rv_joblist);
        recyclerViewJobOffer.setLayoutManager(new LinearLayoutManager(LandingPageActivity.this));
        recyclerViewJobOffer.setAdapter(jobItemAdapter);

        /**
         * Implementasi bottom nav bar
         */
        BottomNavigationView nav = (BottomNavigationView) findViewById(R.id.btn_bottomnav);
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
    @Override
    public void onClickJobItem(int position) {
        Toast.makeText(this, "Item number "+(position+1)+" has been clicked", Toast.LENGTH_SHORT).show();
    }

    // create callback buat presenter
    private JobPresenter.JobResultCallback jobCallback = new JobPresenter.JobResultCallback() {
        @Override
        public void OnSuccessResult(List<Job> jobs) {
            LandingPageActivity.this.jobs.addAll(jobs);
            LandingPageActivity.this.jobItemAdapter.notifyDataSetChanged();
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
                case R.id.navigation_home:
                    Toast.makeText(getApplicationContext(), "Beranda", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_add:
                    Toast.makeText(getApplicationContext(), "Tambah", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_category:
                    Toast.makeText(getApplicationContext(), "Kategori", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_me:
<<<<<<< HEAD
<<<<<<< HEAD
                    Intent profileIntent = new Intent(LandingPageActivity.this, ProfilePageActivity.class);
                    startActivity(profileIntent);
=======
                    Intent profile = new Intent(LandingPageActivity.this, ProfilePageActivity.class);
                    startActivity(profile);
>>>>>>> [Afriandi]add new screen
=======
                    Intent profile = new Intent(LandingPageActivity.this, ProfilePageActivity.class);
                    startActivity(profile);
>>>>>>> [Afriandi]add new screen
                    return true;
            }
            return false;
        }
    };
}
