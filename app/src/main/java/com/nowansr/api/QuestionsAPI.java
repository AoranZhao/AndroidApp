package com.nowansr.api;

import com.nowansr.model.Questions;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;

/**
 * Created by Aaron on 4/20/16.
 */
public interface QuestionsAPI {
    @GET("/tasks")
    void getMyQuestions(@Header("Authorization") String auth, Callback<Questions> questions);
}
