package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Section {
    @SerializedName("departmentId")
    @Expose
    private String departmentId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("departmentNmae")
    @Expose
    private String departmentNmae;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentNmae() {
        return departmentNmae;
    }

    public void setDepartmentNmae(String departmentNmae) {
        this.departmentNmae = departmentNmae;
    }

}