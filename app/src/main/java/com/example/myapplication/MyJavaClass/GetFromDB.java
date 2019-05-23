package com.example.myapplication.MyJavaClass;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class GetFromDB {

    static  ArrayList<Service> arraylistAllServices = new ArrayList<>();
    static  ArrayList<Departmant> arrayListDepartmant = new ArrayList<>();
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

    public static ArrayList<Departmant> getDepartmants(){
        arrayListDepartmant.clear();
       Departmant d =  new Departmant(1,"department 1 ","fa-fire");

        ArrayList<Service> arraylistAllServices2 = new ArrayList<>();
        arraylistAllServices2.add(new Service(1,"aaaaa",1.1,11,"notvalid"));
        arraylistAllServices2.add(new Service(2,"bbbbb",2.2,22,"valid"));

        d.setServices(arraylistAllServices2);

        arrayListDepartmant.add(d);

        Departmant d2 =  new Departmant(2,"department 2 ","fa-dollar-sign");

        ArrayList<Service> arraylistAllServices3 = new ArrayList<>();
        arraylistAllServices3.add(new Service(3,"ccc dcc",3.3,33,"valid"));
        arraylistAllServices3.add(new Service(4,"ddddd",4.4,44,"notvalid"));
        d2.setServices(arraylistAllServices3);

        arrayListDepartmant.add(d2);

        Departmant d3 =  new Departmant(2,"department 2 ","fa-users");

        ArrayList<Service> arraylistAllServices4 = new ArrayList<>();
        arraylistAllServices4.add(new Service(3,"ccc dcc",3.3,33,"valid"));
        arraylistAllServices4.add(new Service(4,"ddddd",4.4,44,"notvalid"));
        d2.setServices(arraylistAllServices4);

        arrayListDepartmant.add(d3);

        Departmant d4 =  new Departmant(2,"department 2 ","fa-drafting-compass");

        ArrayList<Service> arraylistAllServices5 = new ArrayList<>();
        arraylistAllServices5.add(new Service(3,"ccc dcc",3.3,33,"valid"));
        arraylistAllServices5.add(new Service(4,"ddddd",4.4,44,"notvalid"));
        d2.setServices(arraylistAllServices5);

        arrayListDepartmant.add(d4);

        return arrayListDepartmant;
    }

    public static ArrayList<ServiceCitizen> getServicesCitizen(){
        //Date
        ArrayList<ServiceCitizen> myService = new ArrayList<>();
        Service s = new Service(1,"aaaaa",1.1,11,"notvalid");
        ServiceCitizen cs = new ServiceCitizen(1,s,1,"2012-2-5","done");
        ServiceCitizen cs1 = new ServiceCitizen(2,s,1,"1019-4-1","notdone");
        myService.add(cs);
        myService.add(cs1);
        return myService;
    }
    public static ArrayList<ServiceCitizen> getDoneServicesCitizen(){
        //Date
        ArrayList<ServiceCitizen> myServices = new ArrayList<>();
        Service s = new Service(1,"aaaaa",1.1,11,"valid");
        ServiceCitizen cs = new ServiceCitizen(1,s,1,"2012-2-5","done");
        myServices.add(cs);
        return myServices;
    }
    public static ArrayList<ServiceCitizen> getNotDoneServicesCitizen(){
        //Date
        ArrayList<ServiceCitizen> myService = new ArrayList<>();
        Service s = new Service(1,"aaaaa",1.1,11,"valid");
        ServiceCitizen cs1 = new ServiceCitizen(2,s,1,"1019-4-1","notdone");
        myService.add(cs1);
        return myService;
    }
    public static ArrayList<Attachment> getServiceAttachment(int idService){
        ArrayList<Attachment> Attachments = new ArrayList<>();
        //File file = new File("filepath.txt");
        Attachment a = new Attachment(1,"identifacation");
        a.setNote("kkkk hggf trxcngf");
        a.setSrc(new File("aa"));
        Attachment b = new Attachment(2,"namefilebb");
        b.setNote("lkhg rwsagrs fdshrg");
        Attachments.add(a);
        Attachments.add(b);
        Attachments.add(b);
        Attachments.add(b);
        Attachments.add(b);
        Attachments.add(b);
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
