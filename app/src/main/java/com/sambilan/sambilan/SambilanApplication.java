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

    private boolean isLoggedIn = false;
    private String appRole = "";
    private String appToken = "";

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

        Log.d("APP", "onCreate: ----------- \n token " + token
                + "\n | role " + role
                + "\n | current Token " + appToken);

        if (null != token && !token.equals("")) {
            this.appToken = token;
            if (null != role && !role.equals("")) {
                if (!appRole.equals(role))
                    appToken = CacheManager.getInstance(this).getString(CacheManager.LAST_TOKEN_KEY);
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
        connectionReceiver.checkConnection(this);
        return connectionReceiver.isConnected();
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

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void deleteDB() {
        DaoMaster.dropAllTables(database, true);
        DaoMaster.createAllTables(database, true);
    }
}
