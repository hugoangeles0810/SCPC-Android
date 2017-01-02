package io.github.hugoangeles0810.android.scpc.data.prefs;

import android.content.Context;

import io.github.hugoangeles0810.android.scpc.config.Const;
import io.github.hugoangeles0810.android.scpc.model.User;
import io.github.hugoangeles0810.android.scpc.util.SharedPrefsUtils;

/**
 * Created by hugo on 24/12/16.
 */

public class UserPrefs {

    public void setUserLogged(Context context, User user) {
        SharedPrefsUtils.setBooleanPreference(context, Const.KEYS.IS_LOGGED, true);
        SharedPrefsUtils.setStringPreference(context, Const.KEYS.TOKEN, user.getToken());
    }

    public Boolean isLogged(Context context) {
        return SharedPrefsUtils.getBooleanPreference(context, Const.KEYS.IS_LOGGED, false);
    }

    public void logout(Context context) {
        SharedPrefsUtils.setStringPreference(context, Const.KEYS.TOKEN, "");
        SharedPrefsUtils.setBooleanPreference(context, Const.KEYS.IS_LOGGED, false);
    }

    public String getToken(Context context) {
        return SharedPrefsUtils.getStringPreference(context, Const.KEYS.TOKEN);
    }
}
