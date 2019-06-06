package com.example.myapplication.MyJavaClass;

import java.util.ArrayList;

public class MyLists {

    ArrayList<MyService> arraylistAllServices;

    public MyLists() {
        arraylistAllServices = new ArrayList<>();
        arraylistAllServices = GetFromDB.getAllServices();
    }

    public ArrayList<MyService> getArraylistAllServices() {
        return arraylistAllServices;
    }

    public void setArraylistAllServices(ArrayList<MyService> arraylistAllServices) {
        this.arraylistAllServices = arraylistAllServices;
    }
}
