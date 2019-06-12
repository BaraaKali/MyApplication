package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttachmentArchiveCitizen {
    @SerializedName("nameFile")
    @Expose
    private String nameFile;
    @SerializedName("nameAtt")
    @Expose
    private String nameAtt;
    @SerializedName("form")
    @Expose
    private Object form;
    @SerializedName("outputfinal")
    @Expose
    private String outputfinal;
    @SerializedName("cit_ID")
    @Expose
    private Integer citID;
    @SerializedName("image")
    @Expose
    private Boolean image;
    @SerializedName("pdf")
    @Expose
    private Boolean pdf;
    @SerializedName("atta_ArchiveC_ID")
    @Expose
    private Integer attaArchiveCID;
    @SerializedName("serviceAttachmentName_ID")
    @Expose
    private Integer serviceAttachmentNameID;

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getNameAtt() {
        return nameAtt;
    }

    public void setNameAtt(String nameAtt) {
        this.nameAtt = nameAtt;
    }

    public Object getForm() {
        return form;
    }

    public void setForm(Object form) {
        this.form = form;
    }

    public String getOutputfinal() {
        return outputfinal;
    }

    public void setOutputfinal(String outputfinal) {
        this.outputfinal = outputfinal;
    }

    public Integer getCitID() {
        return citID;
    }

    public void setCitID(Integer citID) {
        this.citID = citID;
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

    public Integer getAttaArchiveCID() {
        return attaArchiveCID;
    }

    public void setAttaArchiveCID(Integer attaArchiveCID) {
        this.attaArchiveCID = attaArchiveCID;
    }

    public Integer getServiceAttachmentNameID() {
        return serviceAttachmentNameID;
    }

    public void setServiceAttachmentNameID(Integer serviceAttachmentNameID) {
        this.serviceAttachmentNameID = serviceAttachmentNameID;
    }

}