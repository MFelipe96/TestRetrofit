package com.example.testretrofit.infraestruture.usuario;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class UsuarioInfoRequest {

    private final Retrofit retrofit;
    public static final String urlBase = "https://api.github.com/";
    public static final String urlBaseTeste = "https://5d53fec8da4ffa0014a0f95b.mockapi.io/users/";

    public UsuarioInfoRequest() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlBaseTeste)
                .addConverterFactory(JacksonConverterFactory.create()) //converter do formato JSON para String
                .build();
    }

    //começando a utilizar o serviço
    public UsuarioService getUsuarioService(){
        return this.retrofit.create(UsuarioService.class);
    }
}
