package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Service {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cost")
    @Expose
    private Double cost;
    @SerializedName("days")
    @Expose
    private Integer days;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("department")
    @Expose
    private Department department;
    @SerializedName("section")
    @Expose
    private Section section;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("path")
    @Expose
    private Object path;
    @SerializedName("haveServiceAttachments")
    @Expose
    private List<Object> haveServiceAttachments = null;
    @SerializedName("attachment")
    @Expose
    private List<Attachment> attachment = null;
    @SerializedName("attwhithFile")
    @Expose
    private List<AttwhithFile> attwhithFile = null;

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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Object getPath() {
        return path;
    }

    public void setPath(Object path) {
        this.path = path;
    }

    public List<Object> getHaveServiceAttachments() {
        return haveServiceAttachments;
    }

    public void setHaveServiceAttachments(List<Object> haveServiceAttachments) {
        this.haveServiceAttachments = haveServiceAttachments;
    }

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }

    public List<AttwhithFile> getAttwhithFile() {
        return attwhithFile;
    }

    public void setAttwhithFile(List<AttwhithFile> attwhithFile) {
        this.attwhithFile = attwhithFile;
    }

}