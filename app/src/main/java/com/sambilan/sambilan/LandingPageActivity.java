package com.sambilan.sambilan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class LandingPageActivity extends AppCompatActivity {

    Toolbar topToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        topToolBar = (Toolbar) findViewById(R.id.topBar);
        setSupportActionBar(topToolBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menu_notif){
            Toast.makeText(LandingPageActivity.this, "Menu notifikasi", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.menu_filter){
            Toast.makeText(LandingPageActivity.this, "Menu Filter", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id == R.id.menu_search){
            Toast.makeText(LandingPageActivity.this, "Menu Search", Toast.LENGTH_SHORT).show();
            return true;
        }
        return true;
    }

}
