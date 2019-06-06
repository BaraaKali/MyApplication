package com.example.myapplication.network;

import com.example.myapplication.models.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("services")
    Call<List<Service>> getServiceCall();
}
