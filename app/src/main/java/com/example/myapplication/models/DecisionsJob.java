package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DecisionsJob {

    @SerializedName("job")
    @Expose
    private Object job;
    @SerializedName("idEmployee")
    @Expose
    private Integer idEmployee;
    @SerializedName("employee")
    @Expose
    private Object employee;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("runing")
    @Expose
    private Object runing;
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
    @SerializedName("services_Provided_ID")
    @Expose
    private Integer servicesProvidedID;
    @SerializedName("cit_ID")
    @Expose
    private Integer citID;
    @SerializedName("service_Citizen_ID")
    @Expose
    private Integer serviceCitizenID;
    @SerializedName("run")
    @Expose
    private Boolean run;

    public Object getJob() {
        return job;
    }

    public void setJob(Object job) {
        this.job = job;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Object getEmployee() {
        return employee;
    }

    public void setEmployee(Object employee) {
        this.employee = employee;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getRuning() {
        return runing;
    }

    public void setRuning(Object runing) {
        this.runing = runing;
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

    public Boolean getRun() {
        return run;
    }

    public void setRun(Boolean run) {
        this.run = run;
    }

}