package com.example.myapplication.MyJavaClass;

public class ServiceCitizen {
    int id;
    Service service;
    int citizenId;
    String date;
    String status;

    public ServiceCitizen(int id, Service service, int citizenId, String date, String status) {
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
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
