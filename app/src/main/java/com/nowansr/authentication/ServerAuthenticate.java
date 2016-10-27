package com.nowansr.authentication;

public interface ServerAuthenticate {
    public String userSignIn(final String user, final String pass, String authType) throws Exception;
    public String userSignUp(final String username, final String email, final String password, String authType) throws Exception;
}
