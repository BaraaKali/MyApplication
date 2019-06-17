package com.example.myapplication.models;

public class UpLoadFiles {

    String path;
    int idService;
    int idCitizen;
    public UpLoadFiles(String path, int idService, int idCitizen) {
        this.path = path;
        this.idCitizen = idCitizen;
        this.idService = idService;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(int idCitizen) {
        this.idCitizen = idCitizen;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }
}
