package com.nowansr.api;

import com.nowansr.model.Users;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.QueryMap;

/**
 * Created by Aaron on 4/21/16.
 */
public interface SearchAPI {
    @GET("/list/users")
    void Search(@QueryMap Map<String, String> options, Callback<Users> response);
}
