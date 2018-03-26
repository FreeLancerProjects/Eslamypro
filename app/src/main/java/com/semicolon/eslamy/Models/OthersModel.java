package com.semicolon.eslamy.Models;

import java.io.Serializable;

/**
 * Created by Delta on 26/03/2018.
 */

public class OthersModel implements Serializable {
    private int id;
    private String link;
    private String lang;
    private String address;
    private String created_at;
    private String updated_at;

    public OthersModel() {
    }

    public OthersModel(int id, String link, String lang, String address, String created_at, String updated_at) {
        this.id = id;
        this.link = link;
        this.lang = lang;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
