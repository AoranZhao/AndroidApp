package com.nowansr.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Aaron on 4/21/16.
 */
public class Pass {
    @Expose
    private String password;

    @Expose
    private String oldPassword;

    public Pass(String password, String oldPassword) {
        this.password = password;
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
