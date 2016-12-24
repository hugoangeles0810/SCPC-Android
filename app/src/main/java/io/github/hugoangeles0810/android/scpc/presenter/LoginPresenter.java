package io.github.hugoangeles0810.android.scpc.presenter;

import io.github.hugoangeles0810.android.scpc.data.prefs.UserPrefs;
import io.github.hugoangeles0810.android.scpc.model.User;
import io.github.hugoangeles0810.android.scpc.model.callback.LoginCallback;
import io.github.hugoangeles0810.android.scpc.model.interactor.LoginInteractor;
import io.github.hugoangeles0810.android.scpc.view.LoginView;

/**
 * Created by hugo on 24/12/16.
 */

public class LoginPresenter implements Presenter<LoginView>, LoginCallback {

    public static final String TAG = LoginPresenter.class.getSimpleName();

    private LoginView view;
    private LoginInteractor loginInteractor;

    public void login() {
        if (!view.validate()) return;

        String username = view.getUsername();
        String password = view.getPassword();
        view.showProgress();
        view.disableInputs();
        loginInteractor.login(username, password, this);
    }

    public Boolean isLogged() {
        return new UserPrefs().isLogged(view.getContext());
    }

    @Override
    public void addView(LoginView view) {
        this.view = view;
        this.loginInteractor = new LoginInteractor();
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void onLoginSuccess(User user) {
        view.enableInputs();
        view.hideProgress();
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setUserLogged(view.getContext(), user);
        view.onLoginSuccess();
    }

    @Override
    public void onLoginError(String error) {
        view.enableInputs();
        view.hideProgress();
        view.showMessageError(error);
    }
}
