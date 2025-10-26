package com.example.myapplication.data.Repository.Services;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import com.example.myapplication.data.Model.Property.DateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://10.0.2.2:3000/";

    public static Retrofit getClient() {
        if (retrofit == null) {
            // Logging interceptor
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();

            // Gson với DateDeserializer
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateDeserializer())
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}


