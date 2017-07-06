package com.example.shit.opentoktest.presenter;

import com.example.shit.opentoktest.ui.MainActivity;
import com.example.shit.opentoktest.ui.ViewContract;

/**
 * Created by 1 on 06.07.2017.
 */

public interface Presenter {
    void inject(ViewContract viewContract);
    void fetchData();

    void requestPermissions();
}
