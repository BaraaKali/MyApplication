package com.example.myapplication.MyJavaClass;

import java.util.ArrayList;

public class Departmant {
    int id;
    String name;
    String image;

    ArrayList<Service> services;

    public Departmant() {
        services = new ArrayList<>();
    }

    public Departmant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Departmant(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
