package com.nowansr.authentication;

import android.accounts.AccountManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nowansr.R;

import static com.nowansr.authentication.AccountGeneral.sServerAuthenticate;

public class RegistrationActivity extends AppCompatActivity {

    private static final String LOG_TAG = RegistrationActivity.class.getSimpleName();

    public final static String ARG_AUTH_TYPE = "AUTH_TYPE";
    public final static String ARG_ACCOUNT_NAME = "ACCOUNT_NAME";

    private AccountManager mAccountManager;
    private String mAuthTokenType;

    private ServerAuthenticate rServerAuthenticate = new ServerAuthenticate() {
        @Override
        public String userSignIn(String user, String pass, String authType) throws Exception {
            return null;
        }

        @Override
        public String userSignUp(String username, String email, String password, String authType) throws Exception {
            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAccountManager = AccountManager.get(getBaseContext());

        String accountName = getIntent().getStringExtra(ARG_ACCOUNT_NAME);
        mAuthTokenType = getIntent().getStringExtra(ARG_AUTH_TYPE);

        Log.e(LOG_TAG, "onCreate: "+mAuthTokenType+"  "+accountName );

        if (mAuthTokenType == null)
            mAuthTokenType = AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS;

        if (accountName != null) {
            ((TextView) findViewById(R.id.accountName)).setText(accountName);
        }

        findViewById(R.id.submit_SignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void register() {

        final String username = ((TextView)findViewById(R.id.RegisterName)).getText().toString();
        final String email = ((TextView)findViewById(R.id.RegisterEmail)).getText().toString();
        final String password = ((TextView)findViewById(R.id.RegisterPassword)).getText().toString();
        final String passwordConfirm = ((TextView)findViewById(R.id.RegisterPasswordConfirm)).getText().toString();

        if (password.equals(passwordConfirm)) {
            if (username.isEmpty()) { Toast.makeText(RegistrationActivity.this, "username can't be empty", Toast.LENGTH_LONG).show(); }
            else if (email.isEmpty()) { Toast.makeText(RegistrationActivity.this, "email can't be empty", Toast.LENGTH_LONG).show(); }
            else if (password.isEmpty() || passwordConfirm.isEmpty()) { Toast.makeText(RegistrationActivity.this, "password can't be empty", Toast.LENGTH_LONG).show(); }
            else {
                new AsyncTask<String, Void, Intent>() {

                    String authToken;

                    @Override
                    protected Intent doInBackground(String... params) {
                        try {
                            Log.i(LOG_TAG, "Sign Up processing....");
                            authToken = sServerAuthenticate.userSignUp(username, email, password, mAuthTokenType);
                            Log.i(LOG_TAG, "Sign Up successful");
                        } catch (Exception e) {
                            Log.i(LOG_TAG, e.getMessage());
                        }
                        return new Intent();
                    }
                }.execute();
            }
        } else {
            Toast.makeText(RegistrationActivity.this, "input same password", Toast.LENGTH_LONG).show();
        }
    }

}
