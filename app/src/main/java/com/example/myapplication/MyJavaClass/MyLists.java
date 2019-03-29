package com.example.myapplication.MyJavaClass;

import java.util.ArrayList;

public class MyLists {

    ArrayList<Service> arraylistAllServices;

    public MyLists() {
        arraylistAllServices = new ArrayList<>();
        arraylistAllServices = GetFromDB.getAllServices();
    }

    public ArrayList<Service> getArraylistAllServices() {
        return arraylistAllServices;
    }

    public void setArraylistAllServices(ArrayList<Service> arraylistAllServices) {
        this.arraylistAllServices = arraylistAllServices;
    }
}
