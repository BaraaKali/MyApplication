package com.example.myapplication.MyJavaClass;

import java.util.ArrayList;

public class Departmant {
    int id;
    String name;
    ArrayList<Service> services;

    public Departmant() {
        services = new ArrayList<>();
    }

    public Departmant(int id, String name) {
        this.id = id;
        this.name = name;
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

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
