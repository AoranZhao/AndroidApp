package com.nowansr.model;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class SubedQues {

    @SerializedName("expirationAt")
    @Expose
    private String expirationAt;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("applications")
    @Expose
    private List<Object> applications = new ArrayList<Object>();
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("cancelled")
    @Expose
    private Boolean cancelled;
    @SerializedName("completed")
    @Expose
    private Boolean completed;

    /**
     *
     * @return
     * The expirationAt
     */
    public String getExpirationAt() {
        return expirationAt;
    }

    /**
     *
     * @param expirationAt
     * The expirationAt
     */
    public void setExpirationAt(String expirationAt) {
        this.expirationAt = expirationAt;
    }

    /**
     *
     * @return
     * The category
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     * The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return
     * The question
     */
    public String getQuestion() {
        return question;
    }

    /**
     *
     * @param question
     * The question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     *
     * @return
     * The user
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(String user) {
        this.user = user;
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
     * The applications
     */
    public List<Object> getApplications() {
        return applications;
    }

    /**
     *
     * @param applications
     * The applications
     */
    public void setApplications(List<Object> applications) {
        this.applications = applications;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The createdAt
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The cancelled
     */
    public Boolean getCancelled() {
        return cancelled;
    }

    /**
     *
     * @param cancelled
     * The cancelled
     */
    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     *
     * @return
     * The completed
     */
    public Boolean getCompleted() {
        return completed;
    }

    /**
     *
     * @param completed
     * The completed
     */
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}