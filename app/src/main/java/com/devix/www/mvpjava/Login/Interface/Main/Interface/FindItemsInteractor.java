package com.devix.www.mvpjava.Login.Interface.Main.Interface;

import java.util.List;

/**
 * Created by carlosjoseanguiano on 24/05/17.
 */

public interface FindItemsInteractor {
    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findItems(OnFinishedListener listener);
}
