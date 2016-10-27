package com.nowansr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserQuestionsActivity extends AppCompatActivity {

    private de.hdodenhof.circleimageview.CircleImageView imageviewuserimagesession;
    private android.widget.EditText etExperianceeditprofile;
    private android.widget.Button btresponduserquestion;
    private android.widget.Button btpaymentuserquestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_questions);
        this.btpaymentuserquestion = (Button) findViewById(R.id.btpayment_userquestion);
        this.btresponduserquestion = (Button) findViewById(R.id.btrespond_userquestion);
        this.etExperianceeditprofile = (EditText) findViewById(R.id.et_Experiance_editprofile);
        this.imageviewuserimagesession = (CircleImageView) findViewById(R.id.imageview_userimage_session);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("User Question");
        setSupportActionBar(toolbar);



        if (getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }



        btpaymentuserquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserQuestionsActivity.this, PaymentActivity.class).setFlags
                        (Intent
                        .FLAG_ACTIVITY_NO_ANIMATION));

            }
        });

        btresponduserquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserQuestionsActivity.this, RespondActivity.class).setFlags
                        (Intent
                                .FLAG_ACTIVITY_NO_ANIMATION));
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

}
