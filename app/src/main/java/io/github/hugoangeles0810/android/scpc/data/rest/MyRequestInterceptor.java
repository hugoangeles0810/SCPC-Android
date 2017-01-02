package io.github.hugoangeles0810.android.scpc.data.rest;

import io.github.hugoangeles0810.android.scpc.MyApp;
import io.github.hugoangeles0810.android.scpc.data.prefs.UserPrefs;
import retrofit.RequestInterceptor;

/**
 * Created by hugo on 26/12/16.
 */

public class MyRequestInterceptor implements RequestInterceptor {

    private UserPrefs userPrefs;

    public MyRequestInterceptor(UserPrefs userPrefs) {
        this.userPrefs = userPrefs;
    }

    @Override
    public void intercept(RequestFacade request) {

        if (userPrefs != null && userPrefs.isLogged(MyApp.getContext())) {
            request.addHeader("Authorization", "Token " + userPrefs.getToken(MyApp.getContext()));
        }
    }
}
