package com.nowansr;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.SortedList;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nowansr.api.Api_Url;
import com.nowansr.authentication.AccountGeneral;
import com.nowansr.model.EditProfile;
import com.nowansr.model.Login;
import com.nowansr.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
//import retrofit.client.Response;

public class EditProfileActivity extends AppCompatActivity {

    private android.widget.EditText etnameeditprofile;
    private android.widget.EditText etemaileditprofile;
    private android.widget.EditText etsummaryeditprofile;
    private android.widget.EditText etExperianceeditprofile;
    private android.widget.EditText etEducationeditprofile;
    private android.widget.Button btsaveeditprofile;
    private static final String TAG = "EditProfileActivity";
    private Account userAccount;
    private String token;

    private static final String NAME = "name";
    private static final String PROFILESUMMRY = "profileSummary";
    private static final String experienceSummary = "experienceSummary";
    private static final String educationSummary = "educationSummary";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        this.btsaveeditprofile = (Button) findViewById(R.id.btsave_editprofile);
        this.etEducationeditprofile = (EditText) findViewById(R.id.et_Education_editprofile);
        this.etExperianceeditprofile = (EditText) findViewById(R.id.et_Experiance_editprofile);
        this.etsummaryeditprofile = (EditText) findViewById(R.id.et_summary_editprofile);
        this.etemaileditprofile = (EditText) findViewById(R.id.et_email_editprofile);
        this.etnameeditprofile = (EditText) findViewById(R.id.et_name_editprofile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Edit Profile");
        setSupportActionBar(toolbar);

        if (getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

//        final Login mLogin=new Login();


        getUserName();

        //edit profile button click

        btsaveeditprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                EditProfile(mLogin.getUsername(),etnameeditprofile.getText().toString().trim(),
//                        etsummaryeditprofile.getText().toString().trim(),etExperianceeditprofile
//                                .getText().toString().trim(),etEducationeditprofile.getText()
//                                .toString().trim());

                EditProfile2(userAccount.name,etnameeditprofile.getText().toString().trim(),
                        etsummaryeditprofile.getText().toString().trim(),etExperianceeditprofile
                                .getText().toString().trim(),etEducationeditprofile.getText()
                                .toString().trim());
            }
        });

        GetProfile(userAccount.name);
    }

    private class OnTokenAcquired implements AccountManagerCallback<Bundle> {

        @Override
        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            try {
                Bundle bundle = accountManagerFuture.getResult();
                token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
                Log.i("YYYYYYYYYYYYYYYYYY", "OnTokenAcquired, token is " + bundle.getString(AccountManager.KEY_AUTHTOKEN));
            } catch (Exception e) {
                Log.i("YYYYYYYYYYYYYYY", e.getMessage());
            }
        }
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

//    private void GetProfile2(final String mUserName) {
//        Response response = RestAdapterFactory.users().getUser(mUserName);
//        User user = response.getBody();
//    }

    private void GetProfile(final String mUserName) {

        //API for change password
        String Profile_url= Api_Url.HOST+Api_Url.GETPROFILE+mUserName;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Profile_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, "show onResponse: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.has("username")) {
                                etnameeditprofile.setText(jsonObject.getString("username"));
                            }
                            if (jsonObject.has("email")) {
                                etemaileditprofile.setText(jsonObject.getString("email")); }
                            if (jsonObject.has("educationSummary")) {
                                etEducationeditprofile.setText(jsonObject.getString("educationSummary")); }
                            if (jsonObject.has("experienceSummary")) {
                                etExperianceeditprofile.setText(jsonObject.getString("experienceSummary")); }
                            if (jsonObject.has("profileSummary")) {
                                etsummaryeditprofile.setText(jsonObject.getString("summary")); }
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

    void EditProfile2(final String mUsername, final String mName, final String mProfileSummry,
                     final String mExperienceSummary, final String mEducationSummary) {
        RestAdapterFactory.editProfile().editUser(mUsername,token, new EditProfile(mName, mExperienceSummary, mEducationSummary, mProfileSummry), new Callback<User>() {
            @Override
            public void success(User user, retrofit.client.Response response) {
                showMessage("successful, profile is " + user.getProfileSummary());
                GetProfile(userAccount.name);
            }

            @Override
            public void failure(RetrofitError error) {
                showMessage(error.getMessage());
            }
        });
    }

//    private void refreshProfile() {
//        RestAdapterFactory.users().getUser(userAccount.name, new Callback<User>() {
//            @Override
//            public void success(User user, retrofit.client.Response response) {
//                Log.i(TAG, "refresh onResponse: " + response.getBody().toString());
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//
//            }
//        });
//    }


//    void EditProfile(final String mUsername, final String mName, final String mProfileSummry,
//                     final String mExperienceSummary, final String mEducationSummary) {
//
//        //API for change password
//        String edit_Profile_url= Api_Url.HOST+Api_Url.EDITPROFILE+mUsername;
//        Log.i(TAG, edit_Profile_url);
//
//        StringRequest stringRequest = new StringRequest(Request.Method.PUT, edit_Profile_url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.i(TAG, "onResponse: " + response);
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//
//                            showMessage("Profile edited Successfully");
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        showMessage(error.toString());
//
//                    }
//                }) {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put(NAME, mName);
//                params.put(PROFILESUMMRY, mProfileSummry);
//                params.put(experienceSummary, mExperienceSummary);
//                params.put(educationSummary,mEducationSummary );
//                return params;
//            }
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", token);
//                return params;
//            }
//        };
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }


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


    @Override
    protected void onResume() {
        super.onResume();
        AccountManager am = AccountManager.get(this);
        Account[] al = am.getAccountsByType(AccountGeneral.ACCOUNT_TYPE);
        Log.i("TTTTTTTTTTTTTTT", "Account length is " + al.length);
        final Account a = al[0];
        Log.i("TTTTTTTTTTTTTTT", "Account name is " + a.name + ", type is " + a.type);
        Bundle options = new Bundle();
        am.getAuthToken(a, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS, options, this, new OnTokenAcquired(), null);

        GetProfile(userAccount.name);
    }
}
