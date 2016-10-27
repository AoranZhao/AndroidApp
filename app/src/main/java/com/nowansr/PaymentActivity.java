package com.nowansr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    private android.widget.EditText etnameeditprofile;
    private android.widget.EditText etmonth;
    private android.widget.EditText etyear;
    private android.widget.EditText etcvvcode;
    private android.widget.Button btpayNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        this.btpayNow = (Button) findViewById(R.id.btpayNow);
        this.etcvvcode = (EditText) findViewById(R.id.et_cvvcode);
        this.etyear = (EditText) findViewById(R.id.et_year);
        this.etmonth = (EditText) findViewById(R.id.et_month);
        this.etnameeditprofile = (EditText) findViewById(R.id.et_name_editprofile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Payment");
        setSupportActionBar(toolbar);

        btpayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Payment done successfully");
            }
        });


        if (getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }
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
