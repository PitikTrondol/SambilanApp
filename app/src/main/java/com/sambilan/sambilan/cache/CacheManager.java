package com.sambilan.sambilan.cache;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Andhika Putranto on 2/10/2018.
 */

public class CacheManager {

    private Context context;
    private SharedPreferences preferences;
    private String preferenceName;

    public static final String TOKEN_KEY = "token";
    public static final String ROLE_KEY = "role";
    private static CacheManager instance;

    public static CacheManager getInstance(Context context){
        if(instance==null){
            instance=new CacheManager(context);
        }
        return instance;}
    private CacheManager(Context context) {
        this.context = context;
        this.preferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        this.preferenceName = "Preference";
    }

    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key,value);
        editor.apply();
    }
    public void saveInt(String key, Integer value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void saveBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void saveFloat(String key, Float value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public Integer getInt(String key) {
        return preferences.getInt(key, 0);
    }

    public boolean get(String key) {
        return preferences.getBoolean(key, false);
    }

    public Float getFloat(String key) {
        return preferences.getFloat(key, 0);
    }

    public void clear() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

}
