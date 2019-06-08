package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DecisionsJob {

    @SerializedName("job")
    @Expose
    private JobPath job;
    @SerializedName("idEmployee")
    @Expose
    private Integer idEmployee;
    @SerializedName("employee")
    @Expose
    private Employee employee;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("runing")
    @Expose
    private String runing;
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

    public JobPath getJob() {
        return job;
    }

    public void setJob(JobPath job) {
        this.job = job;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRuning() {
        return runing;
    }

    public void setRuning(String runing) {
        this.runing = runing;
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