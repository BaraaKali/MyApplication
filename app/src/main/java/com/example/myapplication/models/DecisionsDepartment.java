package com.example.myapplication.models;

import java.util.List;
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
    private Object status;
    @SerializedName("cost")
    @Expose
    private Double cost;
    @SerializedName("internalMessage")
    @Expose
    private Object internalMessage;
    @SerializedName("externalMessage")
    @Expose
    private Object externalMessage;
    @SerializedName("date")
    @Expose
    private Object date;
    @SerializedName("depName")
    @Expose
    private Object depName;
    @SerializedName("decision")
    @Expose
    private Object decision;
    @SerializedName("section")
    @Expose
    private List<Object> section = null;
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

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Object getInternalMessage() {
        return internalMessage;
    }

    public void setInternalMessage(Object internalMessage) {
        this.internalMessage = internalMessage;
    }

    public Object getExternalMessage() {
        return externalMessage;
    }

    public void setExternalMessage(Object externalMessage) {
        this.externalMessage = externalMessage;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public Object getDepName() {
        return depName;
    }

    public void setDepName(Object depName) {
        this.depName = depName;
    }

    public Object getDecision() {
        return decision;
    }

    public void setDecision(Object decision) {
        this.decision = decision;
    }

    public List<Object> getSection() {
        return section;
    }

    public void setSection(List<Object> section) {
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

}