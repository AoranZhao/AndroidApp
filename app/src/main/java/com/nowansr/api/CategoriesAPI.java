package com.nowansr.api;

import com.nowansr.model.Category;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Aaron on 4/20/16.
 */
public interface CategoriesAPI {
    @GET("/categories")
    void getAllCategories(Callback<List<Category>> response);
}
