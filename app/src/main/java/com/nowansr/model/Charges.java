package com.nowansr.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Charges {

    @SerializedName("fixedCharges")
    @Expose
    private Integer fixedCharges;
    @SerializedName("percentage")
    @Expose
    private Integer percentage;

    /**
     *
     * @return
     * The fixedCharges
     */
    public Integer getFixedCharges() {
        return fixedCharges;
    }

    /**
     *
     * @param fixedCharges
     * The fixedCharges
     */
    public void setFixedCharges(Integer fixedCharges) {
        this.fixedCharges = fixedCharges;
    }

    /**
     *
     * @return
     * The percentage
     */
    public Integer getPercentage() {
        return percentage;
    }

    /**
     *
     * @param percentage
     * The percentage
     */
    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

}