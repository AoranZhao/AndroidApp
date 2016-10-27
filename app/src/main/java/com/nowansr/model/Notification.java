package com.nowansr.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Notification {

    @SerializedName("notification")
    @Expose
    private String notification;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;

    /**
     *
     * @return
     * The notification
     */
    public String getNotification() {
        return notification;
    }

    /**
     *
     * @param notification
     * The notification
     */
    public void setNotification(String notification) {
        this.notification = notification;
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
     * The enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     *
     * @param enabled
     * The enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}