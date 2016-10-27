package com.nowansr.api;

import com.nowansr.model.Task;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

public interface TaskAPI {

    @POST("/tasks")
    void create(@Body Task task, Callback<Object> object);

}
