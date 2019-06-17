package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttFileTex {

    @SerializedName("s")
    @Expose
    private String s;
    @SerializedName("name")
    @Expose
    private String name;
    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}