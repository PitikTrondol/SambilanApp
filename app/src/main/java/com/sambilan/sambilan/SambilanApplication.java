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

    private final String DB_NAME = "Sambilan_db";
    private String role = "";
    private boolean needLoadOnline;

    private ConnectionReceiver connectionReceiver;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private Database localDb;

    public SambilanApplication() {
        connectionReceiver = new ConnectionReceiver();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        connectionReceiver.checkConnection(this);

        localDb = new DaoMaster.DevOpenHelper(this, DB_NAME).getWritableDb();
        daoMaster = new DaoMaster(localDb);
        daoSession = daoMaster.newSession();

        deleteDatabase();

        Stetho.initializeWithDefaults(this);
    }

    public boolean isConnected() {
        return connectionReceiver.isConnected();
    }

    public DaoSession getDaoSession() {
        return this.daoSession;
    }

    public boolean isNeedLoadOnline() {
        return needLoadOnline;
    }

    public void setNeedLoadOnline(boolean needLoadOnline) {
        this.needLoadOnline = needLoadOnline;
    }

    public void deleteDatabase() {
        daoMaster.dropAllTables(localDb, true);
        daoMaster.createAllTables(localDb, true);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
