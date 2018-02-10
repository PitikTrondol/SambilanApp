package com.sambilan.sambilan;

import android.app.Application;

import com.sambilan.sambilan.utils.ConnectionReceiver;


/**
 * Created by Afriandi Haryanto on 1/13/2018.
 */

public class SambilanApplication extends Application {

    private String role = "";
    private boolean needLoadOnline;

    private String appToken = "2a04133d078354a0d882e6ebccb620dfc231939e11b1a742f7471361f1201ebc";
    private ConnectionReceiver connectionReceiver;

    public SambilanApplication() {
        connectionReceiver = new ConnectionReceiver();
    }


    @Override
    public void onCreate() {
        super.onCreate();

        connectionReceiver.checkConnection(this);
    }

    public boolean isConnected() {
        return connectionReceiver.isConnected();
    }

    public boolean isNeedLoadOnline() {
        return needLoadOnline;
    }

    public void setNeedLoadOnline(boolean needLoadOnline) {
        this.needLoadOnline = needLoadOnline;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAppToken(String TOKEN) {
        this.appToken = TOKEN;
    }

    public String getAppToken() {
        return appToken;
    }

}
