package com.nowansr.api;

import com.nowansr.model.Login;

import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.POST;

public interface LoginAPI {

//    @Header()
    @POST("/login")
    Response login(@Body Login login);

}
