package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by febrian on 07/02/18.
 */

public class Category {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
