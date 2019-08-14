package com.example.testretrofit.infraestruture.login;

import android.telecom.Call;

import com.example.testretrofit.ContaService;
import com.example.testretrofit.RetrofitConfig;

import okhttp3.ResponseBody;

public class LoginRequest {

    private LoginRequestInterface listener;
    public LoginRequest(LoginRequestInterface listener) {
        this.listener = listener;
    }

    public void submitLogin(LoginRequestModel loginRequestModel){

        Call<> requestLoginn = new RetrofitConfig().getContaService().login(loginRequestModel);


    }

    public interface LoginRequestInterface{

    }


}
