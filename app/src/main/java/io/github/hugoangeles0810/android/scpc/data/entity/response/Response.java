package io.github.hugoangeles0810.android.scpc.data.entity.response;

import java.io.Serializable;

/**
 * Created by hugo on 24/12/16.
 */

public class Response<T> implements Serializable {

    private String error;
    private T data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
