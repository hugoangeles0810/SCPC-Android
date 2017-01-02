package io.github.hugoangeles0810.android.scpc.data.entity.response;

import java.io.Serializable;

/**
 * Created by hugo on 26/12/16.
 */

public class LocationUpdatedResponse implements Serializable {

    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
