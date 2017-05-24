package com.devix.www.mvpjava.Login.Interface.Main.Interface;

import java.util.List;

/**
 * Created by carlosjoseanguiano on 24/05/17.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);
}
