package com.nowansr.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Aaron on 4/20/16.
 */
public class SubQues {
    @Expose
    private String categoryId;

    @Expose
    private String question;

    public SubQues(String categoryId, String question) {
        this.categoryId = categoryId;
        this.question = question;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
