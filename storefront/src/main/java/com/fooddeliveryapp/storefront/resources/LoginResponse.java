package com.fooddeliveryapp.storefront.resources;

public class LoginResponse {
    boolean Success;
    String token;
    String msg;

    public LoginResponse(boolean success, String token, String msg) {
        Success = success;
        this.token = token;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
