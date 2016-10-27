package com.nowansr.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Dob {

    @SerializedName("year")
    @Expose
    private Object year;
    @SerializedName("month")
    @Expose
    private Object month;
    @SerializedName("day")
    @Expose
    private Object day;

    /**
     *
     * @return
     * The year
     */
    public Object getYear() {
        return year;
    }

    /**
     *
     * @param year
     * The year
     */
    public void setYear(Object year) {
        this.year = year;
    }

    /**
     *
     * @return
     * The month
     */
    public Object getMonth() {
        return month;
    }

    /**
     *
     * @param month
     * The month
     */
    public void setMonth(Object month) {
        this.month = month;
    }

    /**
     *
     * @return
     * The day
     */
    public Object getDay() {
        return day;
    }

    /**
     *
     * @param day
     * The day
     */
    public void setDay(Object day) {
        this.day = day;
    }

}