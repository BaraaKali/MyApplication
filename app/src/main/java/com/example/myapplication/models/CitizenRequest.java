package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CitizenRequest {

//    @SerializedName("account")
//    @Expose
//    private Account account;

    @SerializedName("cit_FirstName")
    @Expose
    private String citFirstName;
    @SerializedName("cit_FatherName")
    @Expose
    private String citFatherName;
    @SerializedName("cit_GrandfatherName")
    @Expose
    private String citGrandfatherName;
    @SerializedName("cit_LastName")
    @Expose
    private String citLastName;
    @SerializedName("cit_Gender")
    @Expose
    private String citGender;
    @SerializedName("cit_FamilyMembers")
    @Expose
    private Integer citFamilyMembers;
    @SerializedName("cit_ID_Card")
    @Expose
    private String citIDCard;
    @SerializedName("cit_Telephone")
    @Expose
    private String citTelephone;
    @SerializedName("cit_Mobile")
    @Expose
    private String citMobile;
    @SerializedName("cit_Email")
    @Expose
    private String citEmail;
    @SerializedName("cit_Fax")
    @Expose
    private String citFax;
    @SerializedName("cit_Birthday")
    @Expose
    private String citBirthday;
    @SerializedName("cit_PlaceOfBirth")
    @Expose
    private String citPlaceOfBirth;
    @SerializedName("cit_Region")
    @Expose
    private String citRegion;
    @SerializedName("cit_Quarter")
    @Expose
    private String citQuarter;
    @SerializedName("cit_Street")
    @Expose
    private String citStreet;
    @SerializedName("cit_Address")
    @Expose
    private String citAddress;
    @SerializedName("cit_Job")
    @Expose
    private String citJob;
    @SerializedName("cit_PassportNumber")
    @Expose
    private String citPassportNumber;
    @SerializedName("cit_PassportType")
    @Expose
    private String citPassportType;
    @SerializedName("cit_Username")
    @Expose
    private String citUsername;
    @SerializedName("cit_Password")
    @Expose
    private String citPassword;
    @SerializedName("cit_Status")
    @Expose
    private String citStatus;
    @SerializedName("cit_ID")
    @Expose
    private Integer citID;

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    public String getCitFirstName() {
        return citFirstName;
    }

    public void setCitFirstName(String citFirstName) {
        this.citFirstName = citFirstName;
    }

    public String getCitFatherName() {
        return citFatherName;
    }

    public void setCitFatherName(String citFatherName) {
        this.citFatherName = citFatherName;
    }

    public String getCitGrandfatherName() {
        return citGrandfatherName;
    }

    public void setCitGrandfatherName(String citGrandfatherName) {
        this.citGrandfatherName = citGrandfatherName;
    }

    public String getCitLastName() {
        return citLastName;
    }

    public void setCitLastName(String citLastName) {
        this.citLastName = citLastName;
    }

    public String getCitGender() {
        return citGender;
    }

    public void setCitGender(String citGender) {
        this.citGender = citGender;
    }

    public Integer getCitFamilyMembers() {
        return citFamilyMembers;
    }

    public void setCitFamilyMembers(Integer citFamilyMembers) {
        this.citFamilyMembers = citFamilyMembers;
    }

    public String getCitIDCard() {
        return citIDCard;
    }

    public void setCitIDCard(String citIDCard) {
        this.citIDCard = citIDCard;
    }

    public String getCitTelephone() {
        return citTelephone;
    }

    public void setCitTelephone(String citTelephone) {
        this.citTelephone = citTelephone;
    }

    public String getCitMobile() {
        return citMobile;
    }

    public void setCitMobile(String citMobile) {
        this.citMobile = citMobile;
    }

    public String getCitEmail() {
        return citEmail;
    }

    public void setCitEmail(String citEmail) {
        this.citEmail = citEmail;
    }

    public String getCitFax() {
        return citFax;
    }

    public void setCitFax(String citFax) {
        this.citFax = citFax;
    }

    public String getCitBirthday() {
        return citBirthday;
    }

    public void setCitBirthday(String citBirthday) {
        this.citBirthday = citBirthday;
    }

    public String getCitPlaceOfBirth() {
        return citPlaceOfBirth;
    }

    public void setCitPlaceOfBirth(String citPlaceOfBirth) {
        this.citPlaceOfBirth = citPlaceOfBirth;
    }

    public String getCitRegion() {
        return citRegion;
    }

    public void setCitRegion(String citRegion) {
        this.citRegion = citRegion;
    }

    public String getCitQuarter() {
        return citQuarter;
    }

    public void setCitQuarter(String citQuarter) {
        this.citQuarter = citQuarter;
    }

    public String getCitStreet() {
        return citStreet;
    }

    public void setCitStreet(String citStreet) {
        this.citStreet = citStreet;
    }

    public String getCitAddress() {
        return citAddress;
    }

    public void setCitAddress(String citAddress) {
        this.citAddress = citAddress;
    }

    public String getCitJob() {
        return citJob;
    }

    public void setCitJob(String citJob) {
        this.citJob = citJob;
    }

    public String getCitPassportNumber() {
        return citPassportNumber;
    }

    public void setCitPassportNumber(String citPassportNumber) {
        this.citPassportNumber = citPassportNumber;
    }

    public String getCitPassportType() {
        return citPassportType;
    }

    public void setCitPassportType(String citPassportType) {
        this.citPassportType = citPassportType;
    }

    public String getCitUsername() {
        return citUsername;
    }

    public void setCitUsername(String citUsername) {
        this.citUsername = citUsername;
    }

    public String getCitPassword() {
        return citPassword;
    }

    public void setCitPassword(String citPassword) {
        this.citPassword = citPassword;
    }

    public String getCitStatus() {
        return citStatus;
    }

    public void setCitStatus(String citStatus) {
        this.citStatus = citStatus;
    }

    public Integer getCitID() {
        return citID;
    }

    public void setCitID(Integer citID) {
        this.citID = citID;
    }

}