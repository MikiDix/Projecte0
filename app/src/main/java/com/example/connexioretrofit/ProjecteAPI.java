package com.example.connexioretrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ProjecteAPI {
    @GET("preguntes")
    Call<response> getResponse();
}
