package com.example.myapplication.network;

import android.support.annotation.GuardedBy;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.AttachmentArchiveCitizen;
import com.example.myapplication.models.Citizen;
import com.example.myapplication.models.CitizenRequest;
import com.example.myapplication.models.MunInfo;
import com.example.myapplication.models.Service;
import com.example.myapplication.models.ServiceCitizen;
import com.example.myapplication.models.StepsAndDecsions;

import java.util.List;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    @GET("StepsAndDesion")
    Call<List<StepsAndDecsions>> getStepsAndDesionCall(@Query("idcitizen") int idCitizen,@Query("idSerCit") int idSerCit,@Query("idService") int idService);

    @POST("AddCitizenRequest")
    Call<String> AddCitizenRequest(@Body CitizenRequest requestCitizen);

    @PUT("UpdateCitizen")
    Call<String> updateCitizen(@Body Citizen Citizen);

    @GET("CitizenAtt")
    Call<List<AttachmentArchiveCitizen>> getAttachmentArchiveCitizen(@Query("idCitizen") int idCitizen);

    @GET("fileAtt")
    Call<String> getFileAtt(@Query("idAtt") int idAtt);


    @POST("test")
    Call<String> test(@Body String s);


}
