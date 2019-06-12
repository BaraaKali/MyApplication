package com.example.myapplication.models;

import android.content.Context;

import java.util.List;

import com.example.myapplication.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DecisionsDepartment {

    @SerializedName("depId")
    @Expose
    private Integer depId;
    @SerializedName("depOrder")
    @Expose
    private Integer depOrder;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("cost")
    @Expose
    private Double cost;
    @SerializedName("internalMessage")
    @Expose
    private String internalMessage;
    @SerializedName("externalMessage")
    @Expose
    private String externalMessage;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("depName")
    @Expose
    private String depName;
    @SerializedName("decision")
    @Expose
    private String decision;
    @SerializedName("section")
    @Expose
    private List<Section> section = null;
    @SerializedName("totalDepCost")
    @Expose
    private Double totalDepCost;
    @SerializedName("services_Provided_ID")
    @Expose
    private Integer servicesProvidedID;
    @SerializedName("cit_ID")
    @Expose
    private Integer citID;
    @SerializedName("service_Citizen_ID")
    @Expose
    private Integer serviceCitizenID;

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getDepOrder() {
        return depOrder;
    }

    public void setDepOrder(Integer depOrder) {
        this.depOrder = depOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getInternalMessage() {
        return internalMessage;
    }

    public void setInternalMessage(String internalMessage) {
        this.internalMessage = internalMessage;
    }

    public String getExternalMessage() {
        return externalMessage;
    }

    public void setExternalMessage(String externalMessage) {
        this.externalMessage = externalMessage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }

    public Double getTotalDepCost() {
        return totalDepCost;
    }

    public void setTotalDepCost(Double totalDepCost) {
        this.totalDepCost = totalDepCost;
    }

    public Integer getServicesProvidedID() {
        return servicesProvidedID;
    }

    public void setServicesProvidedID(Integer servicesProvidedID) {
        this.servicesProvidedID = servicesProvidedID;
    }

    public Integer getCitID() {
        return citID;
    }

    public void setCitID(Integer citID) {
        this.citID = citID;
    }

    public Integer getServiceCitizenID() {
        return serviceCitizenID;
    }

    public void setServiceCitizenID(Integer serviceCitizenID) {
        this.serviceCitizenID = serviceCitizenID;
    }


    public int nameStatus() {
        if ("done".equals(status)) {

            return R.string.ser_cas_done;
        }
        return  R.string.ser_cas_else;
    }

    public int nameDecision() {
        if ("accept".equals(decision)) {
            return R.string.ser_des_yes;
        } else if ("reject".equals(decision)) {
            return R.string.ser_des_no;
        }
        return R.string.ser_des_else;
    }


}