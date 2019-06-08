package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DecisionSection {

    @SerializedName("section")
    @Expose
    private SectionPath section;
    @SerializedName("job")
    @Expose
    private List<StepsAndDecsionsJob> job = null;
    @SerializedName("jobs")
    @Expose
    private List<Object> jobs = null;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("cit_ID")
    @Expose
    private Integer citID;
    @SerializedName("service_Citizen_ID")
    @Expose
    private Integer serviceCitizenID;
    @SerializedName("services_Provided_ID")
    @Expose
    private Integer servicesProvidedID;

    public SectionPath getSection() {
        return section;
    }

    public void setSection(SectionPath section) {
        this.section = section;
    }

    public List<StepsAndDecsionsJob> getJob() {
        return job;
    }

    public void setJob(List<StepsAndDecsionsJob> job) {
        this.job = job;
    }

    public List<Object> getJobs() {
        return jobs;
    }

    public void setJobs(List<Object> jobs) {
        this.jobs = jobs;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
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

    public Integer getServicesProvidedID() {
        return servicesProvidedID;
    }

    public void setServicesProvidedID(Integer servicesProvidedID) {
        this.servicesProvidedID = servicesProvidedID;
    }

}
