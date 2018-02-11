package com.sambilan.sambilan.model;

/**
 * Created by Afriandi Haryanto on 1/20/2018.
 */

public class Employer {

    private int id;
    private String name;
    private String img_url;
    private String address;
    private String phoneNumber;
    private String desc;

    public Employer(int id, String name, String img_url, String address, String phoneNumber, String desc) {
        this.id = id;
        this.name = name;
        this.img_url = img_url;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.desc = desc;
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

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}