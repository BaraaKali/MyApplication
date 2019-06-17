package com.example.myapplication.models;

public class UpLoadFiles {

    String path;
    int idService;
    int idCitizen;
    String form;

    public UpLoadFiles(String path, int idService, int idCitizen, String form) {
        this.path = path;
        this.idService = idService;
        this.idCitizen = idCitizen;
        this.form = form;
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

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
