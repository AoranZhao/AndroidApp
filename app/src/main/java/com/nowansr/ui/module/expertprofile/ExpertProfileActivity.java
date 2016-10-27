package com.nowansr.ui.module.expertprofile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nowansr.R;


public class ExpertProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_profile);

        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new ExpertProfileFragment())
                    .commit();
        }
    }
}
