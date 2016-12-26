package io.github.hugoangeles0810.android.scpc.presenter;

import io.github.hugoangeles0810.android.scpc.data.prefs.UserPrefs;
import io.github.hugoangeles0810.android.scpc.view.MainView;

/**
 * Created by hugo on 24/12/16.
 */

public class MainPresenter implements Presenter<MainView> {

    private MainView view;

    public void logout() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.logout(view.getContext());
        view.goToLogin();
    }

    @Override
    public void addView(MainView view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }
}
