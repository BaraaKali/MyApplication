package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SectionPath {

    @SerializedName("departmentId")
    @Expose
    private Integer departmentId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idService")
    @Expose
    private Integer idService;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("orderDepartment")
    @Expose
    private Integer orderDepartment;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("jobs")
    @Expose
    private List<Object> jobs = null;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderDepartment() {
        return orderDepartment;
    }

    public void setOrderDepartment(Integer orderDepartment) {
        this.orderDepartment = orderDepartment;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<Object> getJobs() {
        return jobs;
    }

    public void setJobs(List<Object> jobs) {
        this.jobs = jobs;
    }

}