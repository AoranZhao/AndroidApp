package com.nowansr.model;

import com.google.gson.annotations.Expose;

public class Task {

    @Expose
    private String name;
    @Expose
    private String expertId;
    @Expose
    private String skillId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }
}
