package com.nowansr;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.nowansr.adapter.Recycle_Search_ListAdapter;
import com.nowansr.model.Search;
import com.nowansr.model.User;
import com.nowansr.model.Users;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;

public class SearchActivity extends AppCompatActivity {

    private android.widget.Spinner spinnersearch;
    private android.widget.EditText valuesearch;
    private android.widget.Button btsearch;
    private static final String TAG = "SearchActivity";

//    private List<Search> search_data;

    Recycle_Search_ListAdapter rcAdapter;

    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerviewtotalquestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        this.btsearch = (Button) findViewById(R.id.btsearch);
        this.valuesearch = (EditText) findViewById(R.id.value_search);
        this.spinnersearch = (Spinner) findViewById(R.id.spinner_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Search ");
        setSupportActionBar(toolbar);

        recyclerviewtotalquestion = (RecyclerView) findViewById(R.id
                .recycler_view_total_question);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewtotalquestion.setLayoutManager(linearLayoutManager);
        rcAdapter = new Recycle_Search_ListAdapter(this);
        recyclerviewtotalquestion.setAdapter(rcAdapter);
        rcAdapter.setOnItemClickListener(new Recycle_Search_ListAdapter.MyClickListener() {
            @Override
            public void onItemClick(String name, View v) {
                Log.i(TAG, "name is " + name);
                Intent i = new Intent(SearchActivity.this, ExpertProActivity.class);
                i.putExtra(Constants.EXPERTNAME_LABEL, name);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });

        if (getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

        //Initializing our superheroes list
//        search_data = new ArrayList<>();

        btsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = "";
                String text = spinnersearch.getSelectedItem().toString();
                if (text.equals("Skill name")){
                    value="skill";
                }else if(text.equals("User name")){

                    value="name";

                }else if(text.equals("Minimum Price")){
                    value="priceMin";

                }else if(text.equals("Maximum Price")){

                    value="priceMax";
                }else if(text.equals("Minimum Ratings")){

                    value="rateMin";

                }else if(text.equals("Maximum Ratings")){
                    value="rateMax";
                }

                if (value!=null&&!value.equals("")){

                    getData2(value);

                }

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getData2(String url_value) {
        Map<String, String> options = new HashMap<String, String>();
        options.put(url_value, valuesearch.getText().toString().trim());
        RestAdapterFactory.Search().Search(options, new Callback<Users>() {
            @Override
            public void success(Users users, retrofit.client.Response response) {
                List<User> lu = users.getData();
                rcAdapter.setData(lu);
                for (int i = 0;i < lu.size(); i++) {
                    Log.i(TAG, i + "/" + lu.size() + " user is " + lu.get(i).getUsername());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i(TAG, error.getMessage());
            }
        });
    }

    //This method will get data from the web api
//    private void getData(String url_value){
//        //Showing a progress dialog
//        final ProgressDialog loading = ProgressDialog.show(this,"Loading Data", "Please wait...",false,false);
//
//        //Creating a json array request
//        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
//                Constants.SEARCH+url_value+"="+valuesearch.getText().toString().trim(), null,
//                new Response
//                        .Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, response.toString());
//
//                        try {
//                            //Dismissing progress dialog
//                            loading.dismiss();
//                            // response will be a json object
//                            // Parsing json array response
//                            Search search_data_list = new Search();
//                            JSONArray data = response.getJSONArray("data");
//
//                            Log.d(TAG, "onResponse: success:- "+data);
//                            //calling method to parse json array
//                            for(int i = 0; i<data.length(); i++) {
//                                JSONObject json = null;
//                                try {
//                                    json = data.getJSONObject(i);
//
//                                    String name = json.getString("username");
//                                    String email = json.getString("email");
//                                    String avatar = json.getString("avatar");
//                                    boolean online = json.getBoolean("online");
//                                    String image = "https://dev.nowansr.com/uploads/"+avatar;
//
//                                    search_data_list.setName(name);
//                                    search_data_list.setEmail(email);
//                                    search_data_list.setOnline_status(online);
//                                    search_data_list.setImage(image);
//                                    Log.e(TAG, "onResponse: "+name+" "+email+" "+online+" "+avatar );
//                                    JSONArray rating =json.getJSONArray("ratingSummary");
//                                    for (int j = 0; j < rating.length(); j++) {
//                                        JSONObject ratingobj= null;
//
//                                        ratingobj = rating.getJSONObject(j);
//                                        JSONObject rating_temple= ratingobj.getJSONObject("ratingTemplate");
//                                        String rating_name= rating_temple.getString("name");
//                                        int rating_value= rating_temple.getInt("scale");
//
//                                        search_data_list.setRating_name(rating_name);
//                                        search_data_list.setRating_value(rating_value);
//                                        Log.e(TAG, "onResponse: "+rating_name+" "+rating_value );
//                                    }
//
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//
//                                search_data.add(search_data_list);
//                            }
//
//                            //Finally initializing our adapter
//                            rcAdapter = new Recycle_Search_ListAdapter(search_data,SearchActivity.this);
//
//                            //Adding adapter to recyclerview
//                            recyclerviewtotalquestion.setAdapter(rcAdapter);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            loading.dismiss();
//
//                        }
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                loading.dismiss();
//
//            }
//        });
//
//        //Creating request queue
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        //Adding request to the queue
//        requestQueue.add(jsonObjectRequest);
//    }

}
