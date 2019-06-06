package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Citizen {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("last")
    @Expose
    private Integer last;
    @SerializedName("familyMember")
    @Expose
    private Integer familyMember;
    @SerializedName("idCard")
    @Expose
    private String idCard;
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("placeOfBirth")
    @Expose
    private String placeOfBirth;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("quarter")
    @Expose
    private String quarter;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("citizenJob")
    @Expose
    private String citizenJob;
    @SerializedName("passportNumber")
    @Expose
    private String passportNumber;
    @SerializedName("passportType")
    @Expose
    private String passportType;
    @SerializedName("account")
    @Expose
    private Account account;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("fatherName")
    @Expose
    private String fatherName;
    @SerializedName("grandFatherName")
    @Expose
    private String grandFatherName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("gender")
    @Expose
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public Integer getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(Integer familyMember) {
        this.familyMember = familyMember;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCitizenJob() {
        return citizenJob;
    }

    public void setCitizenJob(String citizenJob) {
        this.citizenJob = citizenJob;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportType() {
        return passportType;
    }

    public void setPassportType(String passportType) {
        this.passportType = passportType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGrandFatherName() {
        return grandFatherName;
    }

    public void setGrandFatherName(String grandFatherName) {
        this.grandFatherName = grandFatherName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
