package io.github.hugoangeles0810.android.scpc.data.rest;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import io.github.hugoangeles0810.android.scpc.BuildConfig;
import io.github.hugoangeles0810.android.scpc.MyApp;
import io.github.hugoangeles0810.android.scpc.data.entity.request.LoginRequest;
import io.github.hugoangeles0810.android.scpc.data.entity.request.UpdateUserLocationRequest;
import io.github.hugoangeles0810.android.scpc.data.entity.response.LocationUpdatedResponse;
import io.github.hugoangeles0810.android.scpc.data.entity.response.LoginResponse;
import io.github.hugoangeles0810.android.scpc.data.entity.response.Response;
import io.github.hugoangeles0810.android.scpc.data.prefs.UserPrefs;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by hugo on 24/12/16.
 */

public class ApiClient {

    private static ServicesApiInterface servicesApiInterface;

    public static ServicesApiInterface getMyApiClient() {
        if (servicesApiInterface == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(BuildConfig.HOST)
                    .setClient(new OkClient(getClient()))
                    .setRequestInterceptor(new MyRequestInterceptor(new UserPrefs()))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            servicesApiInterface = restAdapter.create(ServicesApiInterface.class);
        }

        return servicesApiInterface;
    }

    private static OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(2, TimeUnit.MINUTES);
        client.setReadTimeout(2, TimeUnit.MINUTES);
        return client;
    }


    public interface ServicesApiInterface {

        // Auth
        @POST("/api/auth/login-by-email/")
        void login(@Body LoginRequest raw, Callback<Response<LoginResponse>> response);

        // Location
        @POST("/api/location/")
        void updateLocation(@Body UpdateUserLocationRequest raw, Callback<LocationUpdatedResponse> response);
    }
}
