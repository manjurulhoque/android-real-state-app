package com.example.rumi.realstate.model;

import java.io.Serializable;

public class Realtor implements Serializable {

    private int id;
    private String name;
    private String photo;
    private String description;
    private String phone;
    private String email;
    private boolean is_mvp;

    public Realtor() {
    }

    public Realtor(int id, String name, String photo, String description, String phone, String email, boolean is_mvp) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.is_mvp = is_mvp;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_mvp() {
        return is_mvp;
    }

    public void setIs_mvp(boolean is_mvp) {
        this.is_mvp = is_mvp;
    }
}
