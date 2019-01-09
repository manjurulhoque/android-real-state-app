package com.example.rumi.realstate.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Listing implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("zipCode")
    private String zipCode;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private int price;
    @SerializedName("bedrooms")
    private int bedrooms;
    @SerializedName("bathrooms")
    private int bathrooms;
    @SerializedName("garage")
    private int garage;
    @SerializedName("sqft")
    private int sqrt;
    @SerializedName("photo_main")
    private String photo_main;
    @SerializedName("is_published")
    private boolean is_published;
    @SerializedName("realtor")
    private Realtor realtor;

    public Listing() {
    }

    public Listing(int id, String title, String address, String city, String state, String zipCode, String description, int price, int bedrooms, int bathrooms, int garage, int sqrt, String photo_main, boolean is_published, Realtor realtor) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.description = description;
        this.price = price;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.garage = garage;
        this.sqrt = sqrt;
        this.photo_main = photo_main;
        this.is_published = is_published;
        this.realtor = realtor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Realtor getRealtor() {
        return realtor;
    }

    public void setRealtor(Realtor realtor) {
        this.realtor = realtor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getGarage() {
        return garage;
    }

    public void setGarage(int garage) {
        this.garage = garage;
    }

    public int getSqrt() {
        return sqrt;
    }

    public void setSqrt(int sqrt) {
        this.sqrt = sqrt;
    }

    public String getPhoto_main() {
        return photo_main;
    }

    public void setPhoto_main(String photo_main) {
        this.photo_main = photo_main;
    }

    public boolean isIs_published() {
        return is_published;
    }

    public void setIs_published(boolean is_published) {
        this.is_published = is_published;
    }
}
