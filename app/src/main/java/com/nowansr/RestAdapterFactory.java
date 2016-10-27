package com.nowansr;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.ConstructorConstructor;
import com.nowansr.api.AllUsersAPI;
import com.nowansr.api.CategoriesAPI;
import com.nowansr.api.EditProfileAPI;
import com.nowansr.api.LoginAPI;
import com.nowansr.api.PassAPI;
import com.nowansr.api.QuestionsAPI;
import com.nowansr.api.RegistrationAPI;
import com.nowansr.api.SearchAPI;
import com.nowansr.api.SkillsAPI;
import com.nowansr.api.SubQuesAPI;
import com.nowansr.api.TaskAPI;
import com.nowansr.api.UsersAPI;
import com.nowansr.authentication.AccountGeneral;
import com.nowansr.gson.SkillLocationExclusions;
import com.nowansr.model.EditProfile;

import java.io.IOException;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class RestAdapterFactory {

    public static RequestInterceptor requestInterceptor(final String token) {
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Authorization", token);
            }
        };
    }

    public static TaskAPI task(Context context) throws AuthenticatorException, OperationCanceledException, IOException {
        AccountManager accountManager = AccountManager.get(context);
        final Account availableAccounts[] = accountManager.getAccountsByType(AccountGeneral.ACCOUNT_TYPE);
        String token = null;

        //there should be only one ERT account
        if(availableAccounts.length > 0) {
            Account account = availableAccounts[0];
            AccountManagerFuture<Bundle> future = accountManager.getAuthToken(account, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS, null, null, null, null);
                Bundle bundle = future.getResult();
                token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
        }

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.API_ENDPOINT)
                .setRequestInterceptor(requestInterceptor(token))
                .build();

        return restAdapter.create(TaskAPI.class);
    }


    public static LoginAPI login() {
        Gson excludeSkillLocationGson = new GsonBuilder()
                .setExclusionStrategies(new SkillLocationExclusions())
                .create();

        retrofit.RestAdapter loginRestAdapter = new retrofit.RestAdapter.Builder()
                .setEndpoint(Constants.API_ENDPOINT)
                .setConverter(new GsonConverter(excludeSkillLocationGson))
                .build();

        return loginRestAdapter.create(LoginAPI.class);
    }

    public static SkillsAPI skills() {
        Gson skillGson = new GsonBuilder()
                .setExclusionStrategies(new SkillLocationExclusions())
                .create();

        RestAdapter skillRestAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.API_ENDPOINT)
                .setConverter(new GsonConverter(skillGson))
                .build();

        return skillRestAdapter.create(SkillsAPI.class);
    }

    public static UsersAPI users() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.API_ENDPOINT)
                .build();

        return restAdapter.create(UsersAPI.class);
    }

    public static EditProfileAPI editProfile() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.API_ENDPOINT)
                .build();

        return restAdapter.create(EditProfileAPI.class);
    }

    public static RegistrationAPI registration() {
        Gson excludeSkillLocationGson = new GsonBuilder()
                .setExclusionStrategies(new SkillLocationExclusions())
                .create();

        RestAdapter registerRestAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.API_ENDPOINT)
                .setConverter(new GsonConverter(excludeSkillLocationGson))
                .build();
        return registerRestAdapter.create(RegistrationAPI.class);
    }

    public static AllUsersAPI allusers() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.API_ENDPOINT).build();
        return restAdapter.create(AllUsersAPI.class);
    }

    public static QuestionsAPI getMyQuestions() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.API_ENDPOINT).build();
        return restAdapter.create(QuestionsAPI.class);
    }

    public static CategoriesAPI getCategories() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.API_ENDPOINT).build();
        return restAdapter.create(CategoriesAPI.class);
    }

    public static SubQuesAPI submitQuestion() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.API_ENDPOINT).build();
        return restAdapter.create(SubQuesAPI.class);
    }

    public static PassAPI changePass() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.API_ENDPOINT).build();
        return restAdapter.create(PassAPI.class);
    }

    public static SearchAPI Search() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.API_ENDPOINT).build();
        return restAdapter.create(SearchAPI.class);
    }
}
