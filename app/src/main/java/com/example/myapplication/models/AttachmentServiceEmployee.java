package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttachmentServiceEmployee {

    @SerializedName("inputForData")
    @Expose
    private Object inputForData;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("si")
    @Expose
    private Integer si;
    @SerializedName("jobID")
    @Expose
    private Integer jobID;
    @SerializedName("emp_ID")
    @Expose
    private Integer empID;
    @SerializedName("cit_ID")
    @Expose
    private Integer citID;
    @SerializedName("services_Provided_ID")
    @Expose
    private Integer servicesProvidedID;
    @SerializedName("image")
    @Expose
    private Boolean image;
    @SerializedName("pdf")
    @Expose
    private Boolean pdf;
    @SerializedName("service_Citizen_ID")
    @Expose
    private Integer serviceCitizenID;
    @SerializedName("attachment_Service_Employee_ID")
    @Expose
    private Integer attachmentServiceEmployeeID;

    public Object getInputForData() {
        return inputForData;
    }

    public void setInputForData(Object inputForData) {
        this.inputForData = inputForData;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getSi() {
        return si;
    }

    public void setSi(Integer si) {
        this.si = si;
    }

    public Integer getJobID() {
        return jobID;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }

    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public Integer getCitID() {
        return citID;
    }

    public void setCitID(Integer citID) {
        this.citID = citID;
    }

    public Integer getServicesProvidedID() {
        return servicesProvidedID;
    }

    public void setServicesProvidedID(Integer servicesProvidedID) {
        this.servicesProvidedID = servicesProvidedID;
    }

    public Boolean getImage() {
        return image;
    }

    public void setImage(Boolean image) {
        this.image = image;
    }

    public Boolean getPdf() {
        return pdf;
    }

    public void setPdf(Boolean pdf) {
        this.pdf = pdf;
    }

    public Integer getServiceCitizenID() {
        return serviceCitizenID;
    }

    public void setServiceCitizenID(Integer serviceCitizenID) {
        this.serviceCitizenID = serviceCitizenID;
    }

    public Integer getAttachmentServiceEmployeeID() {
        return attachmentServiceEmployeeID;
    }

    public void setAttachmentServiceEmployeeID(Integer attachmentServiceEmployeeID) {
        this.attachmentServiceEmployeeID = attachmentServiceEmployeeID;
    }

}
