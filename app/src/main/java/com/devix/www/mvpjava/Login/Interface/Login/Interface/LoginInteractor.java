package com.devix.www.mvpjava.Login.Interface.Login.Interface;

/**
 * Created by carlosjoseanguiano on 24/05/17.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {

        void onUsernameError();

        void onPasswordError();

        void onSuccess();

    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
