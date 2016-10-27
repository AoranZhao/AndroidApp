package com.nowansr.model;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Registration {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("children")
    @Expose
    private List<Object> children = new ArrayList<Object>();
    @SerializedName("parent")
    @Expose
    private Object parent;
    @SerializedName("online")
    @Expose
    private Boolean online;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("paymentsInfo")
    @Expose
    private List<Object> paymentsInfo = new ArrayList<Object>();
    @SerializedName("ratingSummary")
    @Expose
    private List<Object> ratingSummary = new ArrayList<Object>();
    @SerializedName("joined")
    @Expose
    private String joined;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("expert")
    @Expose
    private Boolean expert;
    @SerializedName("skills")
    @Expose
    private List<Object> skills = new ArrayList<Object>();
    @SerializedName("languages")
    @Expose
    private List<Object> languages = new ArrayList<Object>();
    @SerializedName("dob")
    @Expose
    private Dob dob;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("userGroup")
    @Expose
    private List<UserGroup> userGroup = new ArrayList<UserGroup>();

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
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
     * The children
     */
    public List<Object> getChildren() {
        return children;
    }

    /**
     *
     * @param children
     * The children
     */
    public void setChildren(List<Object> children) {
        this.children = children;
    }

    /**
     *
     * @return
     * The parent
     */
    public Object getParent() {
        return parent;
    }

    /**
     *
     * @param parent
     * The parent
     */
    public void setParent(Object parent) {
        this.parent = parent;
    }

    /**
     *
     * @return
     * The online
     */
    public Boolean getOnline() {
        return online;
    }

    /**
     *
     * @param online
     * The online
     */
    public void setOnline(Boolean online) {
        this.online = online;
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
     * The paymentsInfo
     */
    public List<Object> getPaymentsInfo() {
        return paymentsInfo;
    }

    /**
     *
     * @param paymentsInfo
     * The paymentsInfo
     */
    public void setPaymentsInfo(List<Object> paymentsInfo) {
        this.paymentsInfo = paymentsInfo;
    }

    /**
     *
     * @return
     * The ratingSummary
     */
    public List<Object> getRatingSummary() {
        return ratingSummary;
    }

    /**
     *
     * @param ratingSummary
     * The ratingSummary
     */
    public void setRatingSummary(List<Object> ratingSummary) {
        this.ratingSummary = ratingSummary;
    }

    /**
     *
     * @return
     * The joined
     */
    public String getJoined() {
        return joined;
    }

    /**
     *
     * @param joined
     * The joined
     */
    public void setJoined(String joined) {
        this.joined = joined;
    }

    /**
     *
     * @return
     * The rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     * The rating
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     * The expert
     */
    public Boolean getExpert() {
        return expert;
    }

    /**
     *
     * @param expert
     * The expert
     */
    public void setExpert(Boolean expert) {
        this.expert = expert;
    }

    /**
     *
     * @return
     * The skills
     */
    public List<Object> getSkills() {
        return skills;
    }

    /**
     *
     * @param skills
     * The skills
     */
    public void setSkills(List<Object> skills) {
        this.skills = skills;
    }

    /**
     *
     * @return
     * The languages
     */
    public List<Object> getLanguages() {
        return languages;
    }

    /**
     *
     * @param languages
     * The languages
     */
    public void setLanguages(List<Object> languages) {
        this.languages = languages;
    }

    /**
     *
     * @return
     * The dob
     */
    public Dob getDob() {
        return dob;
    }

    /**
     *
     * @param dob
     * The dob
     */
    public void setDob(Dob dob) {
        this.dob = dob;
    }

    /**
     *
     * @return
     * The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     *
     * @param avatar
     * The avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     *
     * @return
     * The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     *
     * @param timezone
     * The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     *
     * @return
     * The locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     *
     * @param locale
     * The locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     *
     * @return
     * The userGroup
     */
    public List<UserGroup> getUserGroup() {
        return userGroup;
    }

    /**
     *
     * @param userGroup
     * The userGroup
     */
    public void setUserGroup(List<UserGroup> userGroup) {
        this.userGroup = userGroup;
    }

}