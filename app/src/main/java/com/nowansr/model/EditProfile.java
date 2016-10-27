package com.nowansr.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Aaron on 4/20/16.
 */
public class EditProfile {

    @Expose
    private String name;

    @Expose
    private String exprience;

    @Expose
    private String education;

    @Expose
    private String summary;

    public EditProfile(String name, String exprience, String education, String summary) {
        this.name = name;
        this.exprience = exprience;
        this.education = education;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExprience() {
        return exprience;
    }

    public void setExprience(String exprience) {
        this.exprience = exprience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
