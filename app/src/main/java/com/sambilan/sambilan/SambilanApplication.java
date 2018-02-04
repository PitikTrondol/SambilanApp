package com.sambilan.sambilan;

import android.app.Application;

import com.sambilan.sambilan.utils.ConnectionReceiver;

/**
 * Created by Afriandi Haryanto on 1/13/2018.
 */

public class SambilanApplication extends Application {

    private String role = "";
    private ConnectionReceiver connectionReceiver;
    public SambilanApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        connectionReceiver = new ConnectionReceiver(this);
    }

    public boolean isConnected() {
        return connectionReceiver.isConnected();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
