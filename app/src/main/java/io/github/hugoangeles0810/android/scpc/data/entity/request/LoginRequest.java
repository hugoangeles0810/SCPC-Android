package io.github.hugoangeles0810.android.scpc.data.entity.request;

import java.io.Serializable;

/**
 * Created by hugo on 24/12/16.
 */

public class LoginRequest implements Serializable {

    private String email;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
