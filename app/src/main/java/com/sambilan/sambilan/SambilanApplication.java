package com.sambilan.sambilan;

import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.sambilan.sambilan.cache.CacheManager;
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
    private String appToken = "e290fc3d29e74e59a7678945b95dbff385813990dcb52eae4441d2910a2a10e7";
    private ConnectionReceiver connectionReceiver;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        connectionReceiver = new ConnectionReceiver();
        connectionReceiver.checkConnection(this);

        String token = CacheManager.getInstance(this).getString(CacheManager.TOKEN_KEY);
        String role = CacheManager.getInstance(this).getString(CacheManager.ROLE_KEY);
        Log.d("APP", "onCreate: ------------------------- "+token+" | "+role+" appToken"+appToken);
        if(null != token && !token.equals("")) {
            this.appToken = token;
            this.isLoggedIn = true;

            if(null != role && !role.equals("")) this.appRole = role;
        }

        Database database = new DaoMaster.DevOpenHelper(this, "SambilanDB").getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();

        DaoMaster.dropAllTables(database, true);
        DaoMaster.createAllTables(database, true);

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
}
