package com.nowansr.ui.module.searchresult;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.nowansr.Constants;
import com.nowansr.DrawerActivity;
import com.nowansr.R;
import com.nowansr.authentication.AccountGeneral;

/**
 * Starting point of application.
 *
 * @author Abhinav
 */
public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private AccountManager mAccountManager;

    private BroadcastReceiver signinCancelReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase(Constants.SIGNIN_CANCELLED)) {
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(MainActivity.this, DrawerActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
//        finish();
        registerReceiver(signinCancelReceiver, new IntentFilter(Constants
                .SIGNIN_CANCELLED));

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new ExpertFragment())
                    .commit();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(signinCancelReceiver);
    }

    /**
     * Add new account to the account manager
     * @param accountType
     * @param authTokenType
     */
    private void addNewAccount(String accountType, String authTokenType) {
        final AccountManagerFuture<Bundle> future = mAccountManager.addAccount(accountType, authTokenType, null, null, this, new AccountManagerCallback<Bundle>() {
            @Override
            public void run(AccountManagerFuture<Bundle> future) {
                try {
                    Bundle bnd = future.getResult();

                    /*SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Constants.USERNAME, bnd.getString("authAccount"));
                    editor.apply();*/

                    //Utility.saveUsernameInSharedPref(getApplicationContext(), bnd.getString("authAccount"));

                    showMessage("Signed in");
                    Log.d(LOG_TAG, "AddNewAccount Bundle is " + bnd);

                } catch (Exception e) {
                    Log.w(LOG_TAG, "Sign in cancelled");
                    //showMessage(e.getMessage());
                }
            }
        }, null);
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
    protected void onResume() {
        super.onResume();
        mAccountManager = AccountManager.get(this);
        final Account availableAccounts[] = mAccountManager.getAccountsByType(AccountGeneral.ACCOUNT_TYPE);

        if (availableAccounts.length == 0) {
            //Toast.makeText(this, "No accounts", Toast.LENGTH_SHORT).show();
            addNewAccount(AccountGeneral.ACCOUNT_TYPE, AccountGeneral
                    .AUTHTOKEN_TYPE_FULL_ACCESS);
        }
    }
}
