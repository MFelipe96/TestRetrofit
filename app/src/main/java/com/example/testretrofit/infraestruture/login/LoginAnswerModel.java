package com.example.testretrofit.infraestruture.login;

public class LoginAnswerModel {

    private String token = "asdfhfdgSAsxzxsSAS";

    public LoginAnswerModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
