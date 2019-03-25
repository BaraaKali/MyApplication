package com.example.myapplication.MyJavaClass;

import android.util.Log;

import java.util.ArrayList;

public class GetFromDB {

    public GetFromDB() {
    }

    public static ArrayList<Service> getAllServices(){
        ArrayList<Service> listAllServices = new ArrayList<>();

        listAllServices.add(new Service(1,"dddddd"));
        listAllServices.add(new Service(2,"aaaaaa"));
        listAllServices.add(new Service(3,"bbbbb"));
        listAllServices.add(new Service(4,"cccccc"));
        return listAllServices;
    }

    public static boolean checkUsers(String username,String password){
        Log.d("MyApppppp", password);
        if((password.equals("1")) && username.equals("1")) {
            return true;
        }
        return false;
    }
}
