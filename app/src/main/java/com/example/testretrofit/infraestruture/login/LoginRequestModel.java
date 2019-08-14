package com.example.testretrofit.infraestruture.login;

public class LoginRequestModel {

    public String email;
    public String senha;

    public LoginRequestModel() {}

    public LoginRequestModel(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
