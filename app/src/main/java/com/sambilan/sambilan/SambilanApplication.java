package com.sambilan.sambilan;

import android.app.Application;
import android.provider.ContactsContract;

import com.facebook.stetho.Stetho;
import com.sambilan.sambilan.model.DaoMaster;
import com.sambilan.sambilan.model.DaoSession;
import com.sambilan.sambilan.utils.ConnectionReceiver;

import org.greenrobot.greendao.database.Database;


/**
 * Created by Afriandi Haryanto on 1/13/2018.
 */

public class SambilanApplication extends Application {

    private final String dbName = "SambilanDB";
    private String role = "";
    private boolean needLoadOnline;

    private String appToken = "0471a982aa30c988b33ad4e3c0d3fe36e90f19ff4af7b7fd394eb36fa8534356";
    private ConnectionReceiver connectionReceiver;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private Database database;

    @Override
    public void onCreate() {
        super.onCreate();

        connectionReceiver = new ConnectionReceiver();
        connectionReceiver.checkConnection(this);

        database = new DaoMaster.DevOpenHelper(this, dbName).getWritableDb();
        daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();

        daoMaster.dropAllTables(database, true);
        daoMaster.createAllTables(database, true);

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
