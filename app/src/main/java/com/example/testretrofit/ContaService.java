package com.example.testretrofit;

import com.example.testretrofit.infraestruture.login.LoginAnswerModel;
import com.example.testretrofit.infraestruture.login.LoginRequest;
import com.example.testretrofit.infraestruture.login.LoginRequestModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ContaService {

    @POST("cadastro")
    Call<Void> login(@Body LoginRequestModel loginRequestModel);


}
