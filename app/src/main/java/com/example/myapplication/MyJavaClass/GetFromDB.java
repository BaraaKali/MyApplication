package com.example.myapplication.MyJavaClass;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class GetFromDB {

    static  ArrayList<Service> arraylistAllServices = new ArrayList<>();

    public GetFromDB() {

    }

    public static ArrayList<Service> getAllServices(){
        arraylistAllServices.clear();
        arraylistAllServices.add(new Service(1,"aaaaa",1.1,11,"notvalid"));
        arraylistAllServices.add(new Service(2,"bbbbb",2.2,22,"valid"));
        arraylistAllServices.add(new Service(3,"ccc dcc",3.3,33,"valid"));
        arraylistAllServices.add(new Service(4,"ddddd",4.4,44,"notvalid"));
        return arraylistAllServices;
    }

    public static ArrayList<Attachment> getServiceAttachment(int idService){
        ArrayList<Attachment> Attachments = new ArrayList<>();
        //File file = new File("filepath.txt");
        Attachment a = new Attachment(1,"identifacation");
        Attachment b = new Attachment(2,"namefilebb");
        Attachments.add(a);
        Attachments.add(b);
        return Attachments;
    }

    public static boolean checkUsers(String username,String password){
        Log.d("MyApppppp", password);
        if((password.equals("1")) && username.equals("1")) {
            return true;
        }
        return false;
    }


    public static ArrayList<Service> getArraylistAllServices() {
        return arraylistAllServices;
    }

    public static void setArraylistAllServices(ArrayList<Service> arraylistAllServices) {
        GetFromDB.arraylistAllServices = arraylistAllServices;
    }
}
