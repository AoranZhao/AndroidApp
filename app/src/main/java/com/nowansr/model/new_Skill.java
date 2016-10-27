package com.nowansr.model;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class new_Skill {

    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("approved")
    @Expose
    private Boolean approved;
    @SerializedName("notifications")
    @Expose
    private List<Notification> notifications = new ArrayList<Notification>();
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("unit")
    @Expose
    private Integer unit;
    @SerializedName("currency")
    @Expose
    private String currency;

    /**
     *
     * @return
     * The category
     */
    public Category getCategory() {
        return category;
    }

    /**
     *
     * @param category
     * The category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     *
     * @return
     * The price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @param displayName
     * The displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The approved
     */
    public Boolean getApproved() {
        return approved;
    }

    /**
     *
     * @param approved
     * The approved
     */
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    /**
     *
     * @return
     * The notifications
     */
    public List<Notification> getNotifications() {
        return notifications;
    }

    /**
     *
     * @param notifications
     * The notifications
     */
    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    /**
     *
     * @return
     * The status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The unit
     */
    public Integer getUnit() {
        return unit;
    }

    /**
     *
     * @param unit
     * The unit
     */
    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    /**
     *
     * @return
     * The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency
     * The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

}