package com.nowansr.api;

import com.nowansr.model.EditProfile;
import com.nowansr.model.User;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by Aaron on 4/20/16.
 */
public interface EditProfileAPI {

    @PUT("/users/{username}")
    void editUser(@Path("username") String username, @Header("Authorization") String auth, @Body EditProfile ep, Callback<User> response);

}
