package com.jwt.spring.springjwt.datamodels;

public class AuthResponse {
    private String _token;

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
