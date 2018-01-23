package com.sambilan.sambilan;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.sambilan.sambilan.Adapter.SliderAdapter;
import com.sambilan.sambilan.Fragment.SliderFragment;

import java.util.ArrayList;
import java.util.List;

public class LandingPageActivity extends AppCompatActivity {

    Toolbar topBarMenu;
    SearchView topBarSearch;
    RecyclerView recyclerViewJobOffer;

    ViewPager Pager;
    LinearLayout LinearLayout;
    SliderAdapter Adapter;
    PageIndicator Indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Pager = findViewById(R.id.pager);
        LinearLayout = findViewById(R.id.pagesContainer);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(SliderFragment.newInstance("https://trello-attachments.s3.amazonaws.com/5a54ee3b0dd4ebd39048d99c/5a5a29f1f4bb54c9978613fe/9ca5c580be3b78eab3f2bb2ebf117a89/couresel.png"));
        fragments.add(SliderFragment.newInstance("https://trello-attachments.s3.amazonaws.com/5a54ee3b0dd4ebd39048d99c/5a5a29f1f4bb54c9978613fe/848ff359644146c6f24e797601c437ed/couresel2.png"));
        fragments.add(SliderFragment.newInstance("https://trello-attachments.s3.amazonaws.com/5a54ee3b0dd4ebd39048d99c/5a5a29f1f4bb54c9978613fe/fdad02c8caf4ba33379169bfd74eee45/couresel3.png"));
        Adapter = new SliderAdapter(getSupportFragmentManager(), fragments);
        Pager.setAdapter(Adapter);
        Indicator = new PageIndicator(this, LinearLayout, Pager, R.drawable.indicator_circle);
        Indicator.setPageCount(fragments.size());
        Indicator.show();

        /**
        * Implementasi untuk topbar, menu dan search button
        */
        topBarMenu = (Toolbar) findViewById(R.id.topBar);
        setSupportActionBar(topBarMenu);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Indicator.cleanup();
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
