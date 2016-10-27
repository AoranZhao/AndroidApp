package com.nowansr;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nowansr.adapter.Recycle_View_Question_ListAdapter;
import com.nowansr.api.Api_Url;
import com.nowansr.authentication.AccountGeneral;
import com.nowansr.model.Question;
import com.nowansr.model.Questions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;

import static com.nowansr.authentication.AccountGeneral.sServerAuthenticate;

public class ViewQuestionsActivity extends AppCompatActivity {

    Recycle_View_Question_ListAdapter rcAdapter;

    LinearLayoutManager linearLayoutManager;
    private static final String TAG = "ViewQuestionsActivity";

    private String token;
    private AccountManager am;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_questions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("My Questions");
        setSupportActionBar(toolbar);

        RecyclerView recyclerviewbrowse = (RecyclerView) findViewById(R.id
                .recycler_view_view_questions);

        if (getSupportActionBar()!=null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        am = AccountManager.get(this);
        Account[] al = am.getAccounts();
        Account a = al[0];
        token = am.peekAuthToken(a, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS);

        Log.i(TAG, "token is " + token);
        //Api to get the questions of a user
        GetQuestion2();

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewbrowse.setLayoutManager(linearLayoutManager);
        rcAdapter = new Recycle_View_Question_ListAdapter(this);
        recyclerviewbrowse.setAdapter(rcAdapter);


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
        }
        return super.onOptionsItemSelected(item);
    }

    void GetQuestion2() {
        RestAdapterFactory.getMyQuestions().getMyQuestions(token, new Callback<Questions>() {
            @Override
            public void success(Questions questions, retrofit.client.Response response) {
                List<Question> qs = questions.getData();
                Log.i(TAG, "peek data successully, length is " + qs.size());
                rcAdapter.setData(qs);
                Log.i(TAG, "add data successfully.");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i(TAG, "Error: " + error.getMessage());
            }
        });
    }

    void GetQuestion() {

        //API for change password
        String question_url= Api_Url.HOST+Api_Url.VIEWQUESTION;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, question_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, "onResponse: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            Log.i(TAG, " >>>>>>>> " + jsonObject.getJSONArray("data").length());
                            int len = jsonObject.getJSONArray("data").length();
                            ArrayList<Question> qs = new ArrayList<Question>();
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            if (jsonArray != null) {
//                                for (int i = 0; i < len; i++) {
//                                    JSONObject jo = jsonArray.getJSONObject(i);
//                                    if (!jo.getBoolean("cancelled") && !jo.getBoolean("completed")) {
//
//                                    }
//                                }
                            }

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

//    protected void onResume() {
//        super.onResume();
//        AccountManager am = AccountManager.get(this);
//        Account[] al = am.getAccountsByType(AccountGeneral.ACCOUNT_TYPE);
//        Log.i("TTTTTTTTTTTTTTT", "Account length is " + al.length);
//        final Account a = al[0];
//        Log.i("TTTTTTTTTTTTTTT", "Account name is " + a.name + ", type is " + a.type);
////        token = am.peekAuthToken(a, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS);
////        try {
////            token = sServerAuthenticate.userSignIn(a.name, am.getPassword(a), AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        Log.i("TTTTTTTTTTTTTTTT", "> token is " + token);
//        Bundle options = new Bundle();
//        am.getAuthToken(a, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS, options, this, new OnTokenAcquired(), null);
//    }
//
//    private class OnTokenAcquired implements AccountManagerCallback<Bundle> {
//
//        @Override
//        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
//            try {
//                Bundle bundle = accountManagerFuture.getResult();
//                token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
//                GetQuestion();
//                Log.i("YYYYYYYYYYYYYYYYYY", "OnTokenAcquired, token is " + bundle.getString(AccountManager.KEY_AUTHTOKEN));
//            } catch (Exception e) {
//                Log.i("YYYYYYYYYYYYYYY", e.getMessage());
//            }
//        }
//    }
}
