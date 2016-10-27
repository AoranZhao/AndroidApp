package com.nowansr;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
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

import com.nowansr.adapter.Recycle_Expert_List_Adapter;
import com.nowansr.model.User;
import com.nowansr.model.Users;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ExpertsActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private Recycle_Expert_List_Adapter rcAdapter;

    private static final String TAG = "ExpertsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Experts");
        setSupportActionBar(toolbar);

        RecyclerView recyclerviewbrowse = (RecyclerView) findViewById(R.id.recycler_view_experts);

        if (getSupportActionBar()!= null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        GetExperts();

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewbrowse.setLayoutManager(linearLayoutManager);
        rcAdapter = new Recycle_Expert_List_Adapter(this);
        recyclerviewbrowse.setAdapter(rcAdapter);
        rcAdapter.setOnItemClickListener(new Recycle_Expert_List_Adapter.MyClickListener() {
            @Override
            public void onItemClick(String name, View v) {
                Log.i(TAG, "name is " + name);
                Intent i = new Intent(ExpertsActivity.this, ExpertProActivity.class);
                i.putExtra(Constants.EXPERTNAME_LABEL, name);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
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

    private void GetExperts() {
        RestAdapterFactory.allusers().getAllUsers(new Callback<Users>() {
            @Override
            public void success(Users users, Response response) {
                List<User> lu = users.getData();
                rcAdapter.setData(lu);
                Log.i(TAG, "add users");
            }

            @Override
            public void failure(RetrofitError error) {
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

}
