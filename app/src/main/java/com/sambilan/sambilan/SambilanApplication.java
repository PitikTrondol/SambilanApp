package com.sambilan.sambilan;

import android.app.Application;

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
    private String role = "";

    private boolean isLoggedIn = false;
    private String appToken = "";
    private ConnectionReceiver connectionReceiver;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        connectionReceiver = new ConnectionReceiver();
        connectionReceiver.checkConnection(this);

        String token = CacheManager.getInstance(this).getString(CacheManager.TOKEN_KEY);
        if(null != token && !token.equals("")) {
            appToken = token;
            isLoggedIn = true;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
