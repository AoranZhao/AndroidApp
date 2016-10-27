package com.nowansr.authentication;

import android.util.Log;

import com.nowansr.RestAdapterFactory;
import com.nowansr.model.Login;
import com.nowansr.model.Register;

import retrofit.client.Header;
import retrofit.client.Response;

public class NowAnsrServerAuthenticate implements ServerAuthenticate {

    private final String LOG_TAG = NowAnsrServerAuthenticate.class.getSimpleName();

    private String authtoken;

    @Override
    public String userSignIn(String user, String pass,
                             String authType) throws Exception {

        Log.d(LOG_TAG, "userSignIn");

        Response response = RestAdapterFactory.login().login(new Login(user, pass));
        for(Header header : response.getHeaders()) {
            if(null == header.getName()) {
                continue;
            }
            if (header.getName().equalsIgnoreCase("Authorization")) {
                authtoken = header.getValue();
                break;
            }
        }

        return authtoken;
    }

    @Override
    public String userSignUp(String username, String email, String password, String authType) throws Exception {
        Log.d(LOG_TAG, "userSignUp");

        Response response = RestAdapterFactory.registration().register(new Register(username, password, email));

        for(Header header : response.getHeaders()) {
            if(null == header.getName()) {
                continue;
            }
            if (header.getName().equalsIgnoreCase("Authorization")) {
                authtoken = header.getValue();
                break;
            }
        }

        return authtoken;
    }
}
