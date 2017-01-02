package io.github.hugoangeles0810.android.scpc.data.entity.request;

import java.io.Serializable;

/**
 * Created by hugo on 26/12/16.
 */

public class UpdateUserLocationRequest implements Serializable {

    private Double latitude;
    private Double longitude;

    public UpdateUserLocationRequest() {
    }

    public UpdateUserLocationRequest(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
