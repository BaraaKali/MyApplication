package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ServiceCitizen {
    @SerializedName("idMaxSC")
    @Expose
    private Integer idMaxSC;
    @SerializedName("androidLine")
    @Expose
    private Integer androidLine;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("attachment")
    @Expose
    private List<Object> attachment = null;
    @SerializedName("attwhithFile")
    @Expose
    private List<Object> attwhithFile = null;
    @SerializedName("allFileEmployee")
    @Expose
    private List<Object> allFileEmployee = null;
    @SerializedName("service")
    @Expose
    private Service service;
    @SerializedName("decisionsJob")
    @Expose
    private DecisionsJob decisionsJob;
    @SerializedName("service_Job")
    @Expose
    private Object serviceJob;
    @SerializedName("citizen")
    @Expose
    private Object citizen;
    @SerializedName("department")
    @Expose
    private Object department;
    @SerializedName("decisionsDepartment")
    @Expose
    private DecisionsDepartment decisionsDepartment;
    @SerializedName("attachmentServiceCitizens")
    @Expose
    private List<Object> attachmentServiceCitizens = null;
    @SerializedName("attachmentServiceEmployees")
    @Expose
    private List<Object> attachmentServiceEmployees = null;
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

    public Integer getIdMaxSC() {
        return idMaxSC;
    }

    public Integer getAndroidLine() {
        return androidLine;
    }

    public void setAndroidLine(Integer androidLine) {
        this.androidLine = androidLine;
    }

    public void setIdMaxSC(Integer idMaxSC) {
        this.idMaxSC = idMaxSC;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Object> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Object> attachment) {
        this.attachment = attachment;
    }

    public List<Object> getAttwhithFile() {
        return attwhithFile;
    }

    public void setAttwhithFile(List<Object> attwhithFile) {
        this.attwhithFile = attwhithFile;
    }

    public List<Object> getAllFileEmployee() {
        return allFileEmployee;
    }

    public void setAllFileEmployee(List<Object> allFileEmployee) {
        this.allFileEmployee = allFileEmployee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public DecisionsJob getDecisionsJob() {
        return decisionsJob;
    }

    public void setDecisionsJob(DecisionsJob decisionsJob) {
        this.decisionsJob = decisionsJob;
    }

    public Object getServiceJob() {
        return serviceJob;
    }

    public void setServiceJob(Object serviceJob) {
        this.serviceJob = serviceJob;
    }

    public Object getCitizen() {
        return citizen;
    }

    public void setCitizen(Object citizen) {
        this.citizen = citizen;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(Object department) {
        this.department = department;
    }

    public DecisionsDepartment getDecisionsDepartment() {
        return decisionsDepartment;
    }

    public void setDecisionsDepartment(DecisionsDepartment decisionsDepartment) {
        this.decisionsDepartment = decisionsDepartment;
    }

    public List<Object> getAttachmentServiceCitizens() {
        return attachmentServiceCitizens;
    }

    public void setAttachmentServiceCitizens(List<Object> attachmentServiceCitizens) {
        this.attachmentServiceCitizens = attachmentServiceCitizens;
    }

    public List<Object> getAttachmentServiceEmployees() {
        return attachmentServiceEmployees;
    }

    public void setAttachmentServiceEmployees(List<Object> attachmentServiceEmployees) {
        this.attachmentServiceEmployees = attachmentServiceEmployees;
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

}
