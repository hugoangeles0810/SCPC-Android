package io.github.hugoangeles0810.android.scpc.view;

/**
 * Created by hugo on 24/12/16.
 */

public interface LoginView extends BaseView {

    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();
    void onLoginSuccess();
    void showMessageError(String msg);
    Boolean validate();
    String getUsername();
    String getPassword();

}
