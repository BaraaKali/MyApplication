package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attachment {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("nameFile")
    @Expose
    private Object nameFile;
    @SerializedName("haveFile")
    @Expose
    private String haveFile;
    @SerializedName("form")
    @Expose
    private String form;
    @SerializedName("formArchevCitizen")
    @Expose
    private Boolean formArchevCitizen;
    @SerializedName("idAttachmentArcheveCitisen")
    @Expose
    private Integer idAttachmentArcheveCitisen;
    @SerializedName("outputfinal")
    @Expose
    private Object outputfinal;
    @SerializedName("image")
    @Expose
    private Boolean image;
    @SerializedName("pdf")
    @Expose
    private Boolean pdf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Object getNameFile() {
        return nameFile;
    }

    public void setNameFile(Object nameFile) {
        this.nameFile = nameFile;
    }

    public String getHaveFile() {
        return haveFile;
    }

    public void setHaveFile(String haveFile) {
        this.haveFile = haveFile;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Boolean getFormArchevCitizen() {
        return formArchevCitizen;
    }

    public void setFormArchevCitizen(Boolean formArchevCitizen) {
        this.formArchevCitizen = formArchevCitizen;
    }

    public Integer getIdAttachmentArcheveCitisen() {
        return idAttachmentArcheveCitisen;
    }

    public void setIdAttachmentArcheveCitisen(Integer idAttachmentArcheveCitisen) {
        this.idAttachmentArcheveCitisen = idAttachmentArcheveCitisen;
    }

    public Object getOutputfinal() {
        return outputfinal;
    }

    public void setOutputfinal(Object outputfinal) {
        this.outputfinal = outputfinal;
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

}
