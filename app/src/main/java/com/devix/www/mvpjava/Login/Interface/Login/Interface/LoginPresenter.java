package com.devix.www.mvpjava.Login.Interface.Login.Interface;

/**
 * Created by carlosjoseanguiano on 24/05/17.
 */

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
