package com.jwt.spring.springjwt.datamodels;

public class AuthResponse {
    private String _token;
    private String username;
    private String password;

    public AuthResponse(String _token, String username, String password) {
        this._token = _token;
        this.username = username;
        this.password = password;
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

    public AuthResponse(String _token) {
        this._token = _token;
    }

    public AuthResponse() {
    }

    public String get_token() {
        return _token;
    }

    public void set_token(String _token) {
        this._token = _token;
    }
}
