package com.nowansr.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

        @SerializedName("_id")
        @Expose
        private String Id;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("visited")
        @Expose
        private String visited;
        @SerializedName("profileSummary")
        @Expose
        private String profileSummary;
        @SerializedName("name")
        @Expose
        private String name;
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
        private List<PaymentsInfo> paymentsInfo = new ArrayList<PaymentsInfo>();
        @SerializedName("ratingSummary")
        @Expose
        private List<RatingSummary> ratingSummary = new ArrayList<RatingSummary>();
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
        private List<Skill> skills = new ArrayList<Skill>();
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
        private List<Object> userGroup = new ArrayList<Object>();
        @SerializedName("educationSummary")
        @Expose
        private String educationSummary;
        @SerializedName("experienceSummary")
        @Expose
        private String experienceSummary;
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("lastName")
        @Expose
        private String lastName;
        @SerializedName("location:city")
        @Expose
        private String locationCity;

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
         * The visited
         */
        public String getVisited() {
            return visited;
        }

        /**
         *
         * @param visited
         * The visited
         */
        public void setVisited(String visited) {
            this.visited = visited;
        }

        /**
         *
         * @return
         * The profileSummary
         */
        public String getProfileSummary() {
            return profileSummary;
        }

        /**
         *
         * @param profileSummary
         * The profileSummary
         */
        public void setProfileSummary(String profileSummary) {
            this.profileSummary = profileSummary;
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
        public List<PaymentsInfo> getPaymentsInfo() {
            return paymentsInfo;
        }

        /**
         *
         * @param paymentsInfo
         * The paymentsInfo
         */
        public void setPaymentsInfo(List<PaymentsInfo> paymentsInfo) {
            this.paymentsInfo = paymentsInfo;
        }

        /**
         *
         * @return
         * The ratingSummary
         */
        public List<RatingSummary> getRatingSummary() {
            return ratingSummary;
        }

        /**
         *
         * @param ratingSummary
         * The ratingSummary
         */
        public void setRatingSummary(List<RatingSummary> ratingSummary) {
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
        public List<Skill> getSkills() {
            return skills;
        }

        /**
         *
         * @param skills
         * The skills
         */
        public void setSkills(List<Skill> skills) {
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
        public List<Object> getUserGroup() {
            return userGroup;
        }

        /**
         *
         * @param userGroup
         * The userGroup
         */
        public void setUserGroup(List<Object> userGroup) {
            this.userGroup = userGroup;
        }

        /**
         *
         * @return
         * The educationSummary
         */
        public String getEducationSummary() {
            return educationSummary;
        }

        /**
         *
         * @param educationSummary
         * The educationSummary
         */
        public void setEducationSummary(String educationSummary) {
            this.educationSummary = educationSummary;
        }

        /**
         *
         * @return
         * The experienceSummary
         */
        public String getExperienceSummary() {
            return experienceSummary;
        }

        /**
         *
         * @param experienceSummary
         * The experienceSummary
         */
        public void setExperienceSummary(String experienceSummary) {
            this.experienceSummary = experienceSummary;
        }

        /**
         *
         * @return
         * The firstName
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         *
         * @param firstName
         * The firstName
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         *
         * @return
         * The lastName
         */
        public String getLastName() {
            return lastName;
        }

        /**
         *
         * @param lastName
         * The lastName
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         *
         * @return
         * The locationCity
         */
        public String getLocationCity() {
            return locationCity;
        }

        /**
         *
         * @param locationCity
         * The location:city
         */
        public void setLocationCity(String locationCity) {
            this.locationCity = locationCity;
        }



//    @SerializedName("_id")
//    @Expose
//    private String Id;
//    @Expose
//    private String username;
//    @Expose
//    private String email;
//    @Expose
//    private String visited;
//    @Expose
//    private String name;
//    @Expose
//    private String summary;
//    @Expose
//    private List<Skill> skills = new ArrayList<>();
//    @Expose
//    private List<String> languages = new ArrayList<>();
//    @Expose
//    private Location location;
//    @Expose
//    private String timezone;
//    @Expose
//    private String locale;
//    @Expose
//    private String avatar;
//
//    /**
//     *
//     * @return
//     * The Id
//     */
//    public String getId() {
//        return Id;
//    }
//
//    /**
//     *
//     * @param Id
//     * The _id
//     */
//    public void setId(String Id) {
//        this.Id = Id;
//    }
//
//    /**
//     *
//     * @return
//     * The username
//     */
//    public String getUsername() {
//        return username;
//    }
//
//    /**
//     *
//     * @param username
//     * The username
//     */
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    /**
//     *
//     * @return
//     * The email
//     */
//    public String getEmail() {
//        return email;
//    }
//
//    /**
//     *
//     * @param email
//     * The email
//     */
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    /**
//     *
//     * @return
//     * The visited
//     */
//    public String getVisited() {
//        return visited;
//    }
//
//    /**
//     *
//     * @param visited
//     * The visited
//     */
//    public void setVisited(String visited) {
//        this.visited = visited;
//    }
//
//    /**
//     *
//     * @return
//     * The name
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     *
//     * @param name
//     * The name
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /**
//     *
//     * @return
//     * The summary
//     */
//    public String getSummary() {
//        return summary;
//    }
//
//    /**
//     *
//     * @param summary
//     * The summary
//     */
//    public void setSummary(String summary) {
//        this.summary = summary;
//    }
//
//    /**
//     *
//     * @return
//     * The skills
//     */
//    public List<Skill> getSkills() {
//        return skills;
//    }
//
//    /**
//     *
//     * @param skills
//     * The skills
//     */
//    public void setSkills(List<Skill> skills) {
//        this.skills = skills;
//    }
//
//    /**
//     *
//     * @return
//     * The languages
//     */
//    public List<String> getLanguages() {
//        return languages;
//    }
//
//    /**
//     *
//     * @param languages
//     * The languages
//     */
//    public void setLanguages(List<String> languages) {
//        this.languages = languages;
//    }
//
//    /**
//     *
//     * @return
//     * The location
//     */
//    public Location getLocation() {
//        return location;
//    }
//
//    /**
//     *
//     * @param location
//     * The location
//     */
//    public void setLocation(Location location) {
//        this.location = location;
//    }
//
//    /**
//     *
//     * @return
//     * The timezone
//     */
//    public String getTimezone() {
//        return timezone;
//    }
//
//    /**
//     *
//     * @param timezone
//     * The timezone
//     */
//    public void setTimezone(String timezone) {
//        this.timezone = timezone;
//    }
//
//    /**
//     *
//     * @return
//     * The locale
//     */
//    public String getLocale() {
//        return locale;
//    }
//
//    /**
//     *
//     * @param locale
//     * The locale
//     */
//    public void setLocale(String locale) {
//        this.locale = locale;
//    }
//
//    /**
//     *
//     * @return
//     * The avatar
//     */
//    public String getAvatar() {
//        return avatar;
//    }
//
//    /**
//     *
//     * @param avatar
//     * The avatar
//     */
//    public void setAvatar(String avatar) {
//        this.avatar = avatar;
//    }

}