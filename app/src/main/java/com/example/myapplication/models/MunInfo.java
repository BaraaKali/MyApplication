package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MunInfo {
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("munName")
    @Expose
    private String munName;
    @SerializedName("munCity")
    @Expose
    private String munCity;
    @SerializedName("munZone")
    @Expose
    private String munZone;
    @SerializedName("munStreet")
    @Expose
    private String munStreet;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMunName() {
        return munName;
    }

    public void setMunName(String munName) {
        this.munName = munName;
    }

    public String getMunCity() {
        return munCity;
    }

    public void setMunCity(String munCity) {
        this.munCity = munCity;
    }

    public String getMunZone() {
        return munZone;
    }

    public void setMunZone(String munZone) {
        this.munZone = munZone;
    }

    public String getMunStreet() {
        return munStreet;
    }

    public void setMunStreet(String munStreet) {
        this.munStreet = munStreet;
    }

}