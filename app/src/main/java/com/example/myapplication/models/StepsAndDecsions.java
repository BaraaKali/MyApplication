package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StepsAndDecsions {
    @SerializedName("departmentPaths")
    @Expose
    private DepartmentPaths departmentPaths;
    @SerializedName("decisionsDepartment")
    @Expose
    private DecisionsDepartment decisionsDepartment;
    @SerializedName("sections")
    @Expose
    private List<DecisionSection> sections = null;

    public DepartmentPaths getDepartmentPaths() {
        return departmentPaths;
    }

    public void setDepartmentPaths(DepartmentPaths departmentPaths) {
        this.departmentPaths = departmentPaths;
    }

    public DecisionsDepartment getDecisionsDepartment() {
        return decisionsDepartment;
    }

    public void setDecisionsDepartment(DecisionsDepartment decisionsDepartment) {
        this.decisionsDepartment = decisionsDepartment;
    }

    public List<DecisionSection> getSections() {
        return sections;
    }

    public void setSections(List<DecisionSection> sections) {
        this.sections = sections;
    }

}
