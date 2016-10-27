package com.nowansr.api;

import com.nowansr.model.Users;

import java.util.List;

import retrofit.http.GET;
import retrofit.Callback;
/**
 * Created by aaron on 08/03/16.
 */
public interface AllUsersAPI {
    @GET("/list/users")
    void getAllUsers(Callback<Users> users);
}
