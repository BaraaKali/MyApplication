package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Department {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nameA")
    @Expose
    private String nameA;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("numberService")
    @Expose
    private Integer numberService;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNumberService() {
        return numberService;
    }

    public void setNumberService(Integer numberService) {
        this.numberService = numberService;
    }

}