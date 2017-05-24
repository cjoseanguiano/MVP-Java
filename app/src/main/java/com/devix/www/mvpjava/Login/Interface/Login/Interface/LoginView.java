package com.devix.www.mvpjava.Login.Interface.Login.Interface;

/**
 * Created by carlosjoseanguiano on 24/05/17.
 */

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
