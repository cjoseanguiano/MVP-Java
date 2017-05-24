package com.devix.www.mvpjava.Login.Interface.Login;

import android.text.TextUtils;

import com.devix.www.mvpjava.Login.Interface.Login.Interface.LoginInteractor;

import android.os.Handler;

/**
 * Created by carlosjoseanguiano on 24/05/17.
 */


public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    error = true;
                    return;
                }
                if (!error) {
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
