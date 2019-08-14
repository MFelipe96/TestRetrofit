package com.example.testretrofit.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties({"avatar_url",
        "gravatar_id",
        "url",
        "html_url",
        "followers_url",
        "following_url",
        "gists_url",
        "starred_url",
        "subscriptions_url",
        "organizations_url",
        "repos_url",
        "events_url",
        "received_events_url",
        "type",
        "site_admin",
        "node_id",
        "company",
        "blog",
        "location",
        "hireable",
        "bio",
        "public_repos",
        "public_gists",
        "followers",
        "following",
        "created_at",
        "updated_at",
        "address",
        "phone",
        "website"})
public class Usuario {

    private int id;
    private String name;
    private String email;
    private String token;

    @SerializedName("username")
    private String username;

    private String password;


    public Usuario(){}

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Usuario(int id, String name, String email, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nUsername: " + getUsername()
                + "\nEmail: " + getEmail()
                + "\nNome: " + getName();
    }

}
