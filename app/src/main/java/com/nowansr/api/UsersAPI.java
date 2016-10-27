package com.nowansr.api;

import com.nowansr.model.EditProfile;
import com.nowansr.model.User;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Path;

public interface UsersAPI {

    @GET("/users/{username}")
    void getUser(@Path("username") String username, Callback<User> response);

}
