package com.sambilan.sambilan;

import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.sambilan.sambilan.utils.CacheManager;
import com.sambilan.sambilan.model.DaoMaster;
import com.sambilan.sambilan.model.DaoSession;
import com.sambilan.sambilan.utils.ConnectionReceiver;

import org.greenrobot.greendao.database.Database;


/**
 * Created by Afriandi Haryanto on 1/13/2018.
 */

public class SambilanApplication extends Application {

    private boolean needLoadOnline;
    private String appRole = "employee";

    private boolean isLoggedIn = false;
    private String appToken = "c719fa5c27c95a597f22a13d9c0732dae7dd9b60629652bfdbc9858ec92e3e8c";
    private ConnectionReceiver connectionReceiver;
    private DaoSession daoSession;
    private Database database;

    @Override
    public void onCreate() {
        super.onCreate();

        connectionReceiver = new ConnectionReceiver();
        connectionReceiver.checkConnection(this);

        String token = CacheManager.getInstance(this).getString(CacheManager.TOKEN_KEY);
        String role = CacheManager.getInstance(this).getString(CacheManager.ROLE_KEY);

        Log.d("APP", "onCreate: ----------- " + token
                + " | role " + role
                + " | current Token " + appToken);

        if (null != token && !token.equals("")) {
            this.appToken = token;
            if (null != role && !role.equals("")) {
                if(!appRole.equals(role)) appToken = CacheManager.getInstance(this).getString(CacheManager.LAST_TOKEN_KEY);
                this.isLoggedIn = true;
                this.appRole = role;
            }
        }

        database = new DaoMaster.DevOpenHelper(this, "SambilanDB").getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();

        Stetho.initializeWithDefaults(this);
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

    public String getAppRole() {
        return appRole;
    }

    public void setAppRole(String appRole) {
        this.appRole = appRole;
    }

    public void setAppToken(String token) {
        this.appToken = token;
    }

    public String getAppToken() {
        return appToken;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void deleteDB() {
        DaoMaster.dropAllTables(database, true);
        DaoMaster.createAllTables(database, true);
    }
}
