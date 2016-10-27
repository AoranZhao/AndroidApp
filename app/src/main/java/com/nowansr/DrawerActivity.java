package com.nowansr;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nowansr.api.Api_Url;
import com.nowansr.authentication.AccountGeneral;
import com.nowansr.authentication.AuthenticatorActivity;
import com.nowansr.model.Category;
import com.nowansr.model.EditProfile;
import com.nowansr.model.SubQues;
import com.nowansr.model.SubedQues;
import com.nowansr.ui.module.searchresult.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "DrawerActivity";
    private static final String QUESTION = "question";
    private static final String CATID = "categoryId";

    private EditText question;
    private Spinner cat;
    private Category[] cs;
    private ArrayAdapter<String> adp;
    private String catId;

    private AccountManager am;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Now Answer");
        setSupportActionBar(toolbar);

        am = AccountManager.get(this);
        try {
            token = am.peekAuthToken(am.getAccountsByType(AccountGeneral.ACCOUNT_TYPE)[0], AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Button send = (Button)findViewById(R.id.btsend);
        question = (EditText)findViewById(R.id.et_question_home);
        cat = (Spinner)findViewById(R.id.cat_spinner);
        cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (cs != null) {
                    catId = cs[i].getId();
                    Log.i(TAG, " > select " + cs[i].getDisplayName().getEnUS() + ", id: " + cs[i].getId());
                } else {
                    catId = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                catId = cs[0].getId();
            }
        });

        //send question button click

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SubmitQuestion(cat.getSelectedItem().toString(),question.getText().toString().trim
//                        ());
                SubmitQuestion2(question.getText().toString().trim(), catId);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            startActivity(new Intent(DrawerActivity.this,SearchActivity.class).setFlags(Intent
                    .FLAG_ACTIVITY_NO_ANIMATION));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            startActivity(new Intent(DrawerActivity.this, DrawerActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));

        } else if (id == R.id.nav_profile) {

            startActivity(new Intent(DrawerActivity.this, ProfileActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));


        } else if (id == R.id.nav_editprofile) {
            startActivity(new Intent(DrawerActivity.this, EditProfileActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));


        } else if (id == R.id.nav_experts) {

            startActivity(new Intent(DrawerActivity.this, ExpertsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));

        } else if (id == R.id.nav_changepass) {

            startActivity(new Intent(DrawerActivity.this,ChangePasswordActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));

        } else if (id == R.id.nav_video) {
            startActivity(new Intent(DrawerActivity.this, VideoActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
        }
        else if (id == R.id.nav_userquestion) {

            startActivity(new Intent(DrawerActivity.this, UserQuestionsActivity.class).setFlags(Intent
                    .FLAG_ACTIVITY_NO_ANIMATION));

        } else if (id == R.id.nav_logout) {

            Toast.makeText(this,"Logout Successfully",Toast.LENGTH_LONG).show();
//            finish();
            Intent intent = new Intent(DrawerActivity.this, AuthenticatorActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }else if(id == R.id.nav_myquestion){


            startActivity(new Intent(DrawerActivity.this,ViewQuestionsActivity.class).setFlags(Intent
                    .FLAG_ACTIVITY_NO_ANIMATION));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    void SubmitQuestion(final String mQuestion, final String mCategoryId) {

        //API for change password
        String submit_url= Api_Url.HOST+Api_Url.POSTQUESTION;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, submit_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, "onResponse: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            showMessage("Question submitted Successfully");


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
                params.put(QUESTION, mQuestion);
                params.put(CATID, mCategoryId);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    void SubmitQuestion2(final String ques, final String categoryId) {
        Log.i(TAG, " > prepare to submit, question is " + ques + ", catid is " + categoryId);
        RestAdapterFactory.submitQuestion().SubmitQues(token, new SubQues(categoryId, ques), new Callback<SubedQues>() {
            @Override
            public void success(SubedQues subedQues, retrofit.client.Response response) {
                showMessage("Submit question successfully");
                Log.i(TAG, "Submit is done");
                cat.setSelection(0);
                question.setText("");
            }

            @Override
            public void failure(RetrofitError error) {
                showMessage("Submit failure.");
                Log.i(TAG, error.getMessage());
            }
        });
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

    private void fillCategories() {
        RestAdapterFactory.getCategories().getAllCategories(new Callback<List<Category>>() {
            @Override
            public void success(List<Category> categories, retrofit.client.Response response) {
                Log.i(TAG, categories.toArray().length + " categories.");
                cs = new Category[categories.toArray().length];
                categories.toArray(cs);
                String[] arr = new String[cs.length];
                for(int i = 0; i < cs.length; i++) {
                    arr[i] = cs[i].getDisplayName().getEnUS();
                }
                adp = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, arr);
                cat.setAdapter(adp);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i(TAG, error.getMessage());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fillCategories();
        token = am.peekAuthToken(am.getAccountsByType(AccountGeneral.ACCOUNT_TYPE)[0], AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS);
    }
}
