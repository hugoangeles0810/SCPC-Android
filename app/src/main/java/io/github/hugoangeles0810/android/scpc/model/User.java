package io.github.hugoangeles0810.android.scpc.model;

import java.io.Serializable;

/**
 * Created by hugo on 24/12/16.
 */

public class User implements Serializable {

    private String email;
    private String token;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
