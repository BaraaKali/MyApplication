package com.example.myapplication.MyJavaClass;

public class MyServiceCitizen {
    int id;
    MyService service;
    int citizenId;
    String date;
    String status;

    public MyServiceCitizen() {
    }

    public MyServiceCitizen(int id, MyService service, int citizenId, String date, String status) {
        this.id = id;
        this.service = service;
        this.citizenId = citizenId;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyService getService() {
        return service;
    }

    public void setService(MyService service) {
        this.service = service;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
