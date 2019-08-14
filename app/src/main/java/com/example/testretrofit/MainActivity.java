package com.example.testretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testretrofit.domain.entity.Usuario;
import com.example.testretrofit.infraestruture.usuario.UsuarioInfoRequest;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText editText_login;
    private EditText editText_password;
    private Button button;
    private Button allSeguidores;
    private Button cadastroUsuario;
    private Button getToken;
    private TextView textView_resposta;
    public String token;
    public String username;
    public static String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_login = findViewById(R.id.editText);
        editText_password = findViewById(R.id.editText2);
        textView_resposta = findViewById(R.id.textview);
        button = findViewById(R.id.button);
        allSeguidores = findViewById(R.id.button2);
        cadastroUsuario = findViewById(R.id.button3);

        username = editText_login.getText().toString();
        password = editText_password.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Call<List<Usuario>> call = new UsuarioInfoRequest().getUsuarioService().BuscarUsuario(editText_login.getText().toString());
                call.enqueue(new Callback<List<Usuario>>() {
                    @Override
                    public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                        if (response.isSuccessful()) {
                            List<Usuario> listUsuario = response.body();
                            for(Usuario usuario: listUsuario){
                                textView_resposta.setText(usuario.toString());
                                Log.d("Lista", "onResponse: " + usuario.toString());
                            }
                        }else{
                            Log.i("Cod", "Erro: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Usuario>> call, Throwable t) {

                    }
                });

            }
        });

//        allSeguidores.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Call <List<Usuario>> listCall = new UsuarioInfoRequest().getUsuarioService().BuscarAllSeguidores(editText_login.getText().toString());
//                listCall.enqueue(new Callback<List<Usuario>>() {
//                    @Override
//                    public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
//                        List<Usuario> usuarioList = response.body();
//                        for(Usuario usuario: usuarioList){
//                            Log.d("login", "onResponse: " + usuario.toString());
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Usuario>> call, Throwable t) {
//                        Log.e("UsuarioService", "Erro ao tentar listar todos os seguidores: " + t.getMessage());
//                    }
//                });
//            }
//        });

        cadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Usuario usuario = new Usuario(editText_login.getText().toString(), "teste245");
                Call <Usuario> call = new UsuarioInfoRequest().getUsuarioService().cadastrarUsuario(usuario);
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, response.body().getToken(), Toast.LENGTH_LONG).show();
                            token = response.body().getToken();
                        }else{
                            Toast.makeText(MainActivity.this, "login errado", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Log.e("UsuarioService", "Erro" + t.getMessage());
                    }
                });
            }
        });

        allSeguidores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<ResponseBody> call = new UsuarioInfoRequest().getUsuarioService().GetToken(token);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()){
                            try {
                                Toast.makeText(MainActivity.this, response.body().string(), Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Token errado", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("UsuarioService", "erro: " + t.getMessage());
                    }
                });
            }
        });
    }
}
