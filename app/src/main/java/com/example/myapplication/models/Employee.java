package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("dep_id")
    @Expose
    private Integer depId;
    @SerializedName("sec_id")
    @Expose
    private Integer secId;
    @SerializedName("job_id")
    @Expose
    private Integer jobId;
    @SerializedName("emp_id")
    @Expose
    private Integer empId;
    @SerializedName("dep_name")
    @Expose
    private String depName;
    @SerializedName("sec_name")
    @Expose
    private String secName;
    @SerializedName("job_name")
    @Expose
    private String jobName;
    @SerializedName("emp_name")
    @Expose
    private String empName;
    @SerializedName("emp_idCard")
    @Expose
    private String empIdCard;
    @SerializedName("emp_email")
    @Expose
    private String empEmail;
    @SerializedName("emp_tel")
    @Expose
    private String empTel;
    @SerializedName("emp_mobile")
    @Expose
    private String empMobile;
    @SerializedName("emp_gender")
    @Expose
    private String empGender;
    @SerializedName("emp_birth")
    @Expose
    private String empBirth;
    @SerializedName("String")
    @Expose
    private String String;
    @SerializedName("emp_StartDate")
    @Expose
    private String empStartDate;
    @SerializedName("emp_EndDate")
    @Expose
    private String empEndDate;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("screens")
    @Expose
    private String screens;
    @SerializedName("account")
    @Expose
    private Account account;
    @SerializedName("jobTitel")
    @Expose
    private JobTitel jobTitel;

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpIdCard() {
        return empIdCard;
    }

    public void setEmpIdCard(String empIdCard) {
        this.empIdCard = empIdCard;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpTel() {
        return empTel;
    }

    public void setEmpTel(String empTel) {
        this.empTel = empTel;
    }

    public String getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpBirth() {
        return empBirth;
    }

    public void setEmpBirth(String empBirth) {
        this.empBirth = empBirth;
    }

    public String getString() {
        return String;
    }

    public void setString(String String) {
        this.String = String;
    }

    public String getEmpStartDate() {
        return empStartDate;
    }

    public void setEmpStartDate(String empStartDate) {
        this.empStartDate = empStartDate;
    }

    public String getEmpEndDate() {
        return empEndDate;
    }

    public void setEmpEndDate(String empEndDate) {
        this.empEndDate = empEndDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScreens() {
        return screens;
    }

    public void setScreens(String screens) {
        this.screens = screens;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public JobTitel getJobTitel() {
        return jobTitel;
    }

    public void setJobTitel(JobTitel jobTitel) {
        this.jobTitel = jobTitel;
    }

}
