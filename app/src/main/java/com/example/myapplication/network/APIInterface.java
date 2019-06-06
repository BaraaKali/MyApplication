package com.example.myapplication.network;

import com.example.myapplication.models.MunInfo;
import com.example.myapplication.models.Service;
import com.example.myapplication.models.ServiceCitizen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("services")
    Call<List<Service>> getServiceCall();

    @GET("doneCitizenServices?idCitizen=7")
    Call<List<ServiceCitizen>> getDoneServiceCitizenCall();

    @GET("notDoneCitizenServices?idCitizen=7")
    Call<List<ServiceCitizen>> getNotDoneServiceCitizenCall();

    @GET("MunicipalityInformation")
    Call<MunInfo> getMunicipalityInformationeCall();

}
