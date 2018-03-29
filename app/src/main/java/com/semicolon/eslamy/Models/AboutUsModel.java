package com.semicolon.eslamy.Models;

/**
 * Created by Elashry on 30/03/2018.
 */

public class AboutUsModel {

    private String id;
    private String tw_id;
    private String instagram_id;
    private String address;
    private String title;
    private String phone;

    public AboutUsModel(String id, String tw_id, String instagram_id, String address, String title, String phone) {
        this.id = id;
        this.tw_id = tw_id;
        this.instagram_id = instagram_id;
        this.address = address;
        this.title = title;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTw_id() {
        return tw_id;
    }

    public void setTw_id(String tw_id) {
        this.tw_id = tw_id;
    }

    public String getInstagram_id() {
        return instagram_id;
    }

    public void setInstagram_id(String instagram_id) {
        this.instagram_id = instagram_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
