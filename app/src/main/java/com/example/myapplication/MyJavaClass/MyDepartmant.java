package com.example.myapplication.MyJavaClass;

import java.util.ArrayList;

public class MyDepartmant {
    int id;
    String name;
    String image;

    ArrayList<MyService> services;

    public MyDepartmant() {
        services = new ArrayList<>();
    }

    public MyDepartmant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MyDepartmant(int id, String name, String image) {
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

    public ArrayList<MyService> getServices() {
        return services;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setServices(ArrayList<MyService> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
