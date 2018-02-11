package com.sambilan.sambilan;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.sambilan.sambilan.model.DaoMaster;
import com.sambilan.sambilan.model.DaoSession;
import com.sambilan.sambilan.utils.ConnectionReceiver;

import org.greenrobot.greendao.database.Database;


/**
 * Created by Afriandi Haryanto on 1/13/2018.
 */

public class SambilanApplication extends Application {

    private String role = "";
    private boolean needLoadOnline;

    private String appToken = "912f52f6a72389082d95aa38d065f25a70c46350146abcadf4f87e3d233b0573";
    private ConnectionReceiver connectionReceiver;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        connectionReceiver = new ConnectionReceiver();
        connectionReceiver.checkConnection(this);

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

    public void setAppToken(String TOKEN) {
        this.appToken = TOKEN;
    }

    public String getAppToken() {
        return appToken;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
