package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobPath {
    @SerializedName("sectionID")
    @Expose
    private Integer sectionID;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dOrder")
    @Expose
    private Integer dOrder;
    @SerializedName("sOrder")
    @Expose
    private Integer sOrder;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("importantComment")
    @Expose
    private String importantComment;
    @SerializedName("idMarge")
    @Expose
    private String idMarge;
    @SerializedName("importantCommentFromDataBase")
    @Expose
    private String importantCommentFromDataBase;
    @SerializedName("depId")
    @Expose
    private Integer depId;

    public Integer getSectionID() {
        return sectionID;
    }

    public void setSectionID(Integer sectionID) {
        this.sectionID = sectionID;
    }

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

    public Integer getDOrder() {
        return dOrder;
    }

    public void setDOrder(Integer dOrder) {
        this.dOrder = dOrder;
    }

    public Integer getSOrder() {
        return sOrder;
    }

    public void setSOrder(Integer sOrder) {
        this.sOrder = sOrder;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getImportantComment() {
        return importantComment;
    }

    public void setImportantComment(String importantComment) {
        this.importantComment = importantComment;
    }

    public String getIdMarge() {
        return idMarge;
    }

    public void setIdMarge(String idMarge) {
        this.idMarge = idMarge;
    }

    public String getImportantCommentFromDataBase() {
        return importantCommentFromDataBase;
    }

    public void setImportantCommentFromDataBase(String importantCommentFromDataBase) {
        this.importantCommentFromDataBase = importantCommentFromDataBase;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

}

