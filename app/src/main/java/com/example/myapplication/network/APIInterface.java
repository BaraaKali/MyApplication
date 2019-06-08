package com.example.myapplication.network;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.Citizen;
import com.example.myapplication.models.MunInfo;
import com.example.myapplication.models.Service;
import com.example.myapplication.models.ServiceCitizen;
import com.example.myapplication.models.StepsAndDecsions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

     String idCitizen = GetFromDB.getIdCitizen();

    @GET("services")
    Call<List<Service>> getServiceCall();

    String url1 = "doneCitizenServices?idCitizen=7";
    @GET(url1)
    Call<List<ServiceCitizen>> getDoneServiceCitizenCall();

    @GET("notDoneCitizenServices?idCitizen=7")
    Call<List<ServiceCitizen>> getNotDoneServiceCitizenCall();

    @GET("MunicipalityInformation")
    Call<MunInfo> getMunicipalityInformationeCall();

    @GET("Profile?username=baraa&passWord=baraa")
    Call<Citizen> getProfileCall();

    @GET("StepsAndDesion?idcitizen=7&idSerCit=1&idService=1")
    Call<List<StepsAndDecsions>> getStepsAndDesionCall();

}
