package io.github.hugoangeles0810.android.scpc.model.callback;

import io.github.hugoangeles0810.android.scpc.data.entity.response.LoginResponse;
import io.github.hugoangeles0810.android.scpc.model.User;

/**
 * Created by hugo on 24/12/16.
 */

public interface LoginCallback {

    void onLoginSuccess(User user);
    void onLoginError(String error);
}
