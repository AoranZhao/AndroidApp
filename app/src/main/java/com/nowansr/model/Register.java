package com.nowansr.model;

import com.google.gson.annotations.Expose;

/**
 * Created by aaron on 02/03/16.
 */
public class Register {
    @Expose
    private String username;

    @Expose
    private String password;

    @Expose
    private String email;

    public Register(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
