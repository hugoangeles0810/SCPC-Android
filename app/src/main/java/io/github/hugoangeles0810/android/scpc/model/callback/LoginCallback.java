package io.github.hugoangeles0810.android.scpc.model.callback;

/**
 * Created by hugo on 24/12/16.
 */

public interface LoginCallback {

    void onLoginSuccess();
    void onLoginError(String error);
}
