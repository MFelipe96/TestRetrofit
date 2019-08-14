package com.example.testretrofit.infraestruture.usuario;

import com.example.testretrofit.domain.entity.Usuario;

import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UsuarioService {

//    @GET("users/{login}") //concatenado com a minha url base
//    Call<Usuario> BuscarUsuario(@Path("login") String login);

    @GET("users") //concatenado com a minha url base
    Call<List<Usuario>> BuscarUsuario(@Query("filter") String username);

    @GET("secretValue")
    Call<ResponseBody> GetToken(@Header("Authorization") String authToken);

    @POST("cadastro")
    Call<Usuario> cadastrarUsuario(@Body Usuario usuario);
}
