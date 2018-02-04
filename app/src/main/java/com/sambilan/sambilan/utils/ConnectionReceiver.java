package com.sambilan.sambilan.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.sambilan.sambilan.SambilanApplication;

/**
 * Created by Afriandi Haryanto on 2/4/2018.
 */

public class ConnectionReceiver extends BroadcastReceiver {

    private boolean isConnectedMobile;
    private boolean isConnectedWifi;
    private ConnectivityManager connectivityManager;
    private NetworkInfo activeNetInfo;

    public ConnectionReceiver(Context context) {
        checkConnection(context);
    }

    @Override
    public void onReceive(Context context, Intent intent) {

//        if(null != context)
//            checkConnection(context);
    }

    public void checkConnection(Context context) {
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE );

        activeNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        isConnectedMobile = activeNetInfo != null && activeNetInfo.isConnectedOrConnecting();

        activeNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        isConnectedWifi = activeNetInfo != null && activeNetInfo.isConnectedOrConnecting();
    }

    public boolean isConnectedMobile() {
        return isConnectedMobile;
    }

    public boolean isConnectedWifi() {
        return isConnectedWifi;
    }

    public boolean isConnected() {
        return (isConnectedMobile || isConnectedWifi);
    }
}

