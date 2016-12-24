package io.github.hugoangeles0810.android.scpc.model.interactor;

import io.github.hugoangeles0810.android.scpc.MyApp;
import io.github.hugoangeles0810.android.scpc.R;
import io.github.hugoangeles0810.android.scpc.data.entity.request.LoginRequest;
import io.github.hugoangeles0810.android.scpc.data.entity.response.LoginResponse;
import io.github.hugoangeles0810.android.scpc.data.entity.response.Response;
import io.github.hugoangeles0810.android.scpc.data.rest.ApiClient;
import io.github.hugoangeles0810.android.scpc.model.User;
import io.github.hugoangeles0810.android.scpc.model.callback.LoginCallback;
import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by hugo on 24/12/16.
 */

public class LoginInteractor {

    public void login(String username, String password, final LoginCallback callback) {
        LoginRequest request = new LoginRequest(username, password);
        ApiClient.getMyApiClient().login(request, new Callback<Response<LoginResponse>>() {
            @Override
            public void success(Response<LoginResponse> loginResponseResponse, retrofit.client.Response response) {
                if (loginResponseResponse != null) {
                    User user = new User();
                    user.setEmail(loginResponseResponse.getData().getEmail());
                    user.setToken(loginResponseResponse.getData().getToken());
                    callback.onLoginSuccess(user);
                } else {
                    callback.onLoginError(MyApp.getContext().getString(R.string.error_server_connection));
                }
            }

            @Override
            public void failure(RetrofitError error) {
                if (error.getKind() == RetrofitError.Kind.HTTP) {
                    callback.onLoginError(MyApp.getContext().getString(R.string.error_invalid_credentials));
                    return;
                }

                callback.onLoginError(MyApp.getContext().getString(R.string.error_server_connection));
            }
        });
    }

}
