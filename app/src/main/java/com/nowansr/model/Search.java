package com.nowansr.model;

/**
 * Created by Karan on 4/5/2016.
 */
public class Search {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRating_name() {
        return rating_name;
    }

    public void setRating_name(String rating_name) {
        this.rating_name = rating_name;
    }

    public boolean isOnline_status() {
        return online_status;
    }

    public void setOnline_status(boolean online_status) {
        this.online_status = online_status;
    }

    public int getRating_value() {
        return rating_value;
    }

    public void setRating_value(int rating_value) {
        this.rating_value = rating_value;
    }

    String name;
    String email;
    String rating_name;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    String image;
    boolean online_status;
    int rating_value;

}
