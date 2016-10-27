package com.nowansr;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nowansr.api.Api_Url;
import com.nowansr.model.Login;
import com.nowansr.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;

public class ProfileActivity extends AppCompatActivity {

    private android.widget.EditText etnameprofile;
    private android.widget.EditText etemailprofile;
    private android.widget.EditText etsummaryprofile;
    private android.widget.EditText etExperianceprofile;
    private android.widget.EditText etEducationprofile;
    private static final String TAG = "ProfileActivity";
    private Account userAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.etEducationprofile = (EditText) findViewById(R.id.et_Education_profile);
        this.etExperianceprofile = (EditText) findViewById(R.id.et_Experiance_profile);
        this.etsummaryprofile = (EditText) findViewById(R.id.et_summary_profile);
        this.etemailprofile = (EditText) findViewById(R.id.et_email_profile);
        this.etnameprofile = (EditText) findViewById(R.id.et_name_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Profile");
        setSupportActionBar(toolbar);

        if (getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }
//                final Login mLogin=new Login();

        //Getdetail of user
//        GetProfile(mLogin.getUsername());
        getUserName();
        GetProfile(userAccount.name);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getUserName() {
        AccountManager accountManager = AccountManager.get(this);
        Account[] accounts = accountManager.getAccounts();
        userAccount = null;
        for (Account account:accounts) {
            if (account.type.equals("nowansr.com")) {
                userAccount = account;
            }
        }
    }


    void GetProfile(final String mUserName) {

        //API for change password
        String Profile_url= Api_Url.HOST+Api_Url.GETPROFILE+mUserName;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Profile_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, "onResponse: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            if (jsonObject.has("username")) {
                                etnameprofile.setText(jsonObject.getString("username"));
                            }
                            if (jsonObject.has("email")) {
                                etemailprofile.setText(jsonObject.getString("email")); }
                            if (jsonObject.has("educationSummary")) {
                                etEducationprofile.setText(jsonObject.getString("educationSummary")); }
                            if (jsonObject.has("experienceSummary")) {
                                etExperianceprofile.setText(jsonObject.getString("experienceSummary")); }
                            if (jsonObject.has("profileSummary")) {
                                etsummaryprofile.setText(jsonObject.getString("summary")); }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        showMessage(error.toString());

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showMessage(final String msg) {
        if (TextUtils.isEmpty(msg))
            return;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void refreshProfile() {
//        RestAdapterFactory.users().getUser(userAccount.name, new Callback<User>() {
//            @Override
//            public void success(User user, retrofit.client.Response response) {
//                Log.i(TAG, "refresh onResponse: " + response.getBody());
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//
//            }
//        });
//    }

    @Override
    protected void onResume() {
        super.onResume();
//        refreshProfile();
        GetProfile(userAccount.name);
    }
}
