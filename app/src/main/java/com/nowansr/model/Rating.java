package com.nowansr.model;

import com.google.gson.annotations.Expose;

public class Rating {

    @Expose
    private Integer tech;
    @Expose
    private Integer help;

    /**
     *
     * @return
     * The tech
     */
    public Integer getTech() {
        return tech;
    }

    /**
     *
     * @param tech
     * The tech
     */
    public void setTech(Integer tech) {
        this.tech = tech;
    }

    /**
     *
     * @return
     * The help
     */
    public Integer getHelp() {
        return help;
    }

    /**
     *
     * @param help
     * The help
     */
    public void setHelp(Integer help) {
        this.help = help;
    }

}