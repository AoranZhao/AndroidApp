package com.nowansr.api;

import com.nowansr.model.SubQues;
import com.nowansr.model.SubedQues;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by Aaron on 4/20/16.
 */
public interface SubQuesAPI {
    @POST("/tasks")
    void SubmitQues(@Header("Authorization") String auth, @Body SubQues sq, Callback<SubedQues> response);
}
