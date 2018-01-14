package com.sambilan.sambilan;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class LandingPageActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(getApplicationContext(),"Beranda", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_add:
                    Toast.makeText(getApplicationContext(),"Tambah",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_category:
                    Toast.makeText(getApplicationContext(),"Kategori",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_me:
                    Toast.makeText(getApplicationContext(),"Saya",Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
