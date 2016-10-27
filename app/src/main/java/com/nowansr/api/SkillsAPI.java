package com.nowansr.api;

import com.nowansr.model.Skill;
import com.nowansr.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface SkillsAPI {
    @GET("/skills")
//    @GET("/list/users")
//    void getSkills(Callback<List<User>> response);
    void getSkills(Callback<List<Skill>> response);
}
