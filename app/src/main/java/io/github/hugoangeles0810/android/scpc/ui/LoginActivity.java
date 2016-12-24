package io.github.hugoangeles0810.android.scpc.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.hugoangeles0810.android.scpc.R;
import io.github.hugoangeles0810.android.scpc.presenter.LoginPresenter;
import io.github.hugoangeles0810.android.scpc.view.LoginView;

public class LoginActivity extends AppCompatActivity
                implements LoginView {

    public static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.edittext_login_username)
    TextInputEditText textInputUsername;

    @BindView(R.id.edittext_login_password)
    TextInputEditText textInputPassword;

    @BindView(R.id.button_login)
    Button buttonLogin;

    @BindView(R.id.progressbar_login)
    ProgressBar progressBar;

    private String username;
    private String password;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter();
        presenter.addView(this);

        if (presenter.isLogged()) {
            goToMain();
        }
    }

    private void enableInputs(Boolean enabled) {
        textInputUsername.setEnabled(enabled);
        textInputPassword.setEnabled(enabled);
        buttonLogin.setEnabled(enabled);
    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void enableInputs() {
        enableInputs(true);
    }

    @Override
    public void disableInputs() {
        enableInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoginSuccess() {
        goToMain();
    }

    @Override
    public void showMessageError(String msg) {
        Toast.makeText(this , msg, Toast.LENGTH_SHORT).show();
    }

    public Boolean validate() {
        username = textInputUsername.getText().toString().trim();
        password = textInputPassword.getText().toString().trim();

        textInputUsername.setError(null);
        textInputPassword.setError(null);

        if (username.isEmpty()) {
            textInputUsername.setError(getString(R.string.all_field_required));
            return false;
        }

        if (password.isEmpty()) {
            textInputPassword.setError(getString(R.string.all_field_required));
            return false;
        }

        return true;
    }

    public String getUsername() {
        return username;
    }

    public  String getPassword() {
        return  password;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @OnClick(R.id.button_login)
    public void handleButtonLoginClick() {
        presenter.login();
    }
}
