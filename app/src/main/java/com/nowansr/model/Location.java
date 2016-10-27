package com.nowansr.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("addressLine2")
    @Expose
    private Object addressLine2;
    @SerializedName("addressLine1")
    @Expose
    private Object addressLine1;
    @SerializedName("postalCode")
    @Expose
    private Object postalCode;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("state")
    @Expose
    private Object state;

    /**
     * @return The city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return The country
     */
    public Object getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    public void setCountry(Object country) {
        this.country = country;
    }

    /**
     * @return The state
     */
    public Object getState() {
        return state;
    }

    /**
     * @param state The state
     */
    public void setState(Object state) {
        this.state = state;
    }

    public Object getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(Object addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Object getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(Object addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }
}