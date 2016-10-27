package com.nowansr.api;

import com.nowansr.model.Pass;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by Aaron on 4/21/16.
 */
public interface PassAPI {
    @PUT("/users/{username}/password")
    void ChangePass(@Path("username") String username, @Header("Authorization") String auth, @Body Pass pa, Callback<Object> response);
}
