package com.nowansr;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
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
import com.nowansr.model.Login;
import com.nowansr.model.Pass;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;

public class ChangePasswordActivity extends AppCompatActivity {

    private android.widget.EditText tvcurrentpass;
    private android.widget.EditText tvnewpass;
    private android.widget.EditText tvconfrmpass;
    private android.widget.Button btresetpass;
    private static final String TAG = "ChangePasswordActivity";
    private static final String PASSWORD = "password";
    private static final String OLDPASS = "oldPassword";

    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        this.btresetpass = (Button) findViewById(R.id.btreset_pass);
        this.tvconfrmpass = (EditText) findViewById(R.id.tv_confrm_pass);
        this.tvnewpass = (EditText) findViewById(R.id.tv_new_pass);
        this.tvcurrentpass = (EditText) findViewById(R.id.tv_current_pass);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Change Password");
        setSupportActionBar(toolbar);

//        final Login mLogin=new Login();

        if (getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }






        AccountManager am = AccountManager.get(this);
        Account[] al = am.getAccountsByType(AccountGeneral.ACCOUNT_TYPE);
        Log.i("TTTTTTTTTTTTTTT", "Account length is " + al.length);
        final Account a = al[0];
        Log.i("TTTTTTTTTTTTTTT", "Account name is " + a.name + ", type is " + a.type);
        Bundle options = new Bundle();
        am.getAuthToken(a, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS, options, this, new OnTokenAcquired(), null);

        //btn click to change password

      btresetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangePassword2(a.name,tvcurrentpass.getText().toString().trim(),tvnewpass
                        .getText().toString().trim());
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

    void ChangePassword2(String mUsername, String mOldpassword, final String mPassword) {
        RestAdapterFactory.changePass().ChangePass(mUsername, token, new Pass(mPassword, mOldpassword), new Callback<Object>() {
            @Override
            public void success(Object o, retrofit.client.Response response) {
                Log.i(TAG, "change password successfully.");
                Toast.makeText(getBaseContext(), "Change Password Successfully.", Toast.LENGTH_SHORT);
                tvconfrmpass.setText("");
                tvcurrentpass.setText("");
                tvnewpass.setText("");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i(TAG, error.getMessage());
            }
        });
    }

    void ChangePassword(final String mUsername, final String mOldpassword, final String mPassword) {

        //API for change password
        String change_pass_url=Api_Url.HOST+Api_Url.CHANGEPASS+mUsername+"/password";

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, change_pass_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, "onResponse: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            showMessage("Password change Successfully");


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
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(PASSWORD, mPassword);
                params.put(OLDPASS, mOldpassword);
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = super.getHeaders();
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", token);
                return params;
            }
        };

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


}
