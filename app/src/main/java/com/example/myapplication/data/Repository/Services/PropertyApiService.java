package com.example.myapplication.data.Repository.Services;

import com.example.myapplication.data.Model.Property.Property;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PropertyApiService {
    @GET("property")
    Call<List<Property>> getAllProperties();
}
