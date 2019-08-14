package com.example.testretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private static Retrofit retrofit = null;
    private static String urlBase = "dddd";

    public RetrofitConfig() {
    }

    public static synchronized Retrofit getCliente() {

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public ContaService getContaService(){
        return this.retrofit.create(ContaService.class);
    }
}
