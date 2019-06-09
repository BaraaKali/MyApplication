package com.example.myapplication.network;

import android.support.annotation.GuardedBy;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.Citizen;
import com.example.myapplication.models.MunInfo;
import com.example.myapplication.models.Service;
import com.example.myapplication.models.ServiceCitizen;
import com.example.myapplication.models.StepsAndDecsions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {


    @GET("services")
    Call<List<Service>> getServiceCall();

    @GET("doneCitizenServices")
    Call<List<ServiceCitizen>> getDoneServiceCitizenCall(@Query("idCitizen") int idCitizen);

    @GET("notDoneCitizenServices")
    Call<List<ServiceCitizen>> getNotDoneServiceCitizenCall(@Query("idCitizen") int idCitizen);

    @GET("MunicipalityInformation")
    Call<MunInfo> getMunicipalityInformationeCall();

    @GET("Profile")
    Call<Citizen> getProfileCall(@Query("username") String username , @Query("passWord") String passWord);

    @GET("StepsAndDesion?idcitizen=7&idSerCit=1&idService=1")
    Call<List<StepsAndDecsions>> getStepsAndDesionCall(@Query("idCitizen") int idCitizen,@Query("idSerCit") int idSerCit,@Query("idService") int idService);

}
