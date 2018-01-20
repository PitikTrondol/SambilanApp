package com.sambilan.sambilan;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.sambilan.sambilan.item.JobItemAdapter;

public class LandingPageActivity extends AppCompatActivity implements JobItemAdapter.JobItemListener {

    Toolbar topBarMenu;
    RecyclerView recyclerViewJobOffer;
    JobItemAdapter jobItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        /**
        * Implementasi untuk topbar, menu dan search button
        */
        topBarMenu = (Toolbar) findViewById(R.id.topBar);
        setSupportActionBar(topBarMenu);

        /**
         * Implementasi untuk recyclerview
         * create adapter
         * create recycler
         * setLayoutManager buat menetukan dia type recycler mana
         * (linear vertikal / linear horizontal / grid)
         * setAdapter
         */
        jobItemAdapter = new JobItemAdapter(LandingPageActivity.this, this);
        recyclerViewJobOffer = findViewById(R.id.recycler_jobList);
        recyclerViewJobOffer.setLayoutManager(new LinearLayoutManager(LandingPageActivity.this));
        recyclerViewJobOffer.setAdapter(jobItemAdapter);

        /**
         * Implementasi bottom nav bar
         */
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    /**
     * Implementation override for top bar menus (filter and notification)
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

    /**
     *  Implementasi untuk job list
     */
    @Override
    public void onClickJobItem(int position) {
        Toast.makeText(this, "Item number "+(position+1)+" has been clicked", Toast.LENGTH_SHORT).show();
    }

    /**
     * Implementasi untuk bottom navigation
     * */
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
                    Toast.makeText(getApplicationContext(), "Saya", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };

}
