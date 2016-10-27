package com.nowansr.authentication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class NowAnsrAuthenticatorService extends Service {

    private NowAnsrAuthenticator nowAnsrAuthenticator;

    @Override
    public void onCreate() {
        nowAnsrAuthenticator = new NowAnsrAuthenticator(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return nowAnsrAuthenticator.getIBinder();
    }
}
