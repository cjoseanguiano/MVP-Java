package com.devix.www.mvpjava.Login.Interface.Main;

import com.devix.www.mvpjava.Login.Interface.Main.Interface.FindItemsInteractor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import android.os.Handler;

/**
 * Created by carlosjoseanguiano on 24/05/17.
 */

public class FindItemsInteractorImpl implements FindItemsInteractor {
    @Override
    public void findItems(final OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(createArrayList());
            }
        },2000);
    }

    private List<String> createArrayList() {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10",
                "Item 11",
                "Item 12",
                "Item 13",
                "Item 14",
                "Item 15",
                "Item 16",
                "Item 17",
                "Item 18"
        );
    }
}
