package com.sambilan.sambilan;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Afriandi Haryanto on 1/13/2018.
 */

public class SambilanApplication extends Application {

    private static ConnectivityManager cm;
    private String role = "";
    public SambilanApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public boolean isConnected() {
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
