package com.example.connexioretrofit;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView temperatureTextView;

    private static String BASE_URL= "https://127.0.0.1:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProjecteAPI API = retrofit.create(ProjecteAPI.class);
        Call<response> resCall = API.getResponse();

        resCall.enqueue(new Callback<response>() {
            @Override
            public void onResponse(Call<response> call, Response<response> JSONresponse) {

                if (JSONresponse.isSuccessful()) {
                    response json = JSONresponse.body();
                    if (JSONresponse != null) {
                        List<Preguntes> tot = JSONresponse.body().getLlistaPreguntes();
                    }
                }
            }

            @Override
            public void onFailure(Call<response> call, Throwable t) {

            }
        });

    }
}