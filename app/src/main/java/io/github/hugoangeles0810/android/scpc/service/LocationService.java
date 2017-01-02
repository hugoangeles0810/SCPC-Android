package io.github.hugoangeles0810.android.scpc.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import io.github.hugoangeles0810.android.scpc.data.entity.request.UpdateUserLocationRequest;
import io.github.hugoangeles0810.android.scpc.data.entity.response.LocationUpdatedResponse;
import io.github.hugoangeles0810.android.scpc.data.rest.ApiClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by hugo on 26/12/16.
 */

public class LocationService extends Service implements LocationListener {

    public static final String TAG = LocationService.class.getSimpleName();

    public static final Long MIN_TIME_LOCATION_UPDATE = 10000L; // Miliseconds
    public  static final Float MIN_DISTANCE_LOCATION_UPDATE = 0f;

    private LocationManager locationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        try {
            Log.d(TAG, "init location");
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    MIN_TIME_LOCATION_UPDATE,
                    MIN_DISTANCE_LOCATION_UPDATE,
                    this);
        } catch (SecurityException e) {}
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        try {
            locationManager.removeUpdates(this);
            locationManager = null;
        } catch (SecurityException e) {}
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {
        // TODO: Implement send location to backend
        Log.d(TAG, "lat: " + location.getLatitude() + " , lng: " + location.getLongitude());
        UpdateUserLocationRequest request = new UpdateUserLocationRequest(location.getLatitude(),
                                                                        location.getLongitude());
        ApiClient.getMyApiClient().updateLocation(request, new Callback<LocationUpdatedResponse>() {
            @Override
            public void success(LocationUpdatedResponse locationUpdatedResponse, Response response) {
                Log.d(TAG, "Body: " + response.getBody().toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.getMessage());
            }
        });
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
