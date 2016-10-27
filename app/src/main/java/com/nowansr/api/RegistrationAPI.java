package com.nowansr.api;

import com.nowansr.model.Register;

import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by aaron on 02/03/16.
 */
public interface RegistrationAPI {
    @POST("/register")
    Response register(@Body Register register);
}
