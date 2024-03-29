package com.example.myapplication.MyJavaClass;

import android.util.Log;

import java.util.Date;

public class MyCitizen {
    String firstName;
    String fatherName;
    String grandFatherName;
    String familyName;
    int numberOfFamilyNumber;
    String gender;
    int identificationNumber;
    Date dateOfBirth;
    String placeOfBirth;
    int passportNumber;
    int TelephoneNumber;
    int mobileNumber;
    String email;
    int fax;
    String work;
    String address;
    String street;
    String region;
    String zone;
    String username;
    String password;

    public MyCitizen() {
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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getNumberOfFamilyNumber() {
        return numberOfFamilyNumber;
    }

    public void setNumberOfFamilyNumber(int numberOfFamilyNumber) {
        this.numberOfFamilyNumber = numberOfFamilyNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyCitizen{" +
                "firstName='" + firstName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", grandFatherName='" + grandFatherName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", numberOfFamilyNumber=" + numberOfFamilyNumber +
                ", gender='" + gender + '\'' +
                ", identificationNumber=" + identificationNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", passportNumber=" + passportNumber +
                ", TelephoneNumber=" + TelephoneNumber +
                ", mobileNumber=" + mobileNumber +
                ", email='" + email + '\'' +
                ", fax=" + fax +
                ", work='" + work + '\'' +
                ", address='" + address + '\'' +
                ", street='" + street + '\'' +
                ", region='" + region + '\'' +
                ", zone='" + zone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void addToDB() {

        Log.d("newCitizen ",this.toString());
    }
}
