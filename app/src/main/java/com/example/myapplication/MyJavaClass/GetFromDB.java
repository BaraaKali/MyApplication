package com.example.myapplication.MyJavaClass;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class GetFromDB {

    static  ArrayList<Service> arraylistAllServices = new ArrayList<>();
    static  ArrayList<Service> arraylistServicesInDepartment = new ArrayList<>();
    static  ArrayList<Departmant> arrayListDepartmant = new ArrayList<>();
    public GetFromDB() {

    }

    public static ArrayList<Service> getAllServices(){
        arraylistAllServices.clear();
        arraylistAllServices.add(new Service(1,"aaaaa",1.1,11,"notvalid","يجب ان ملاحظات الخدمة "));
        arraylistAllServices.add(new Service(2,"bbbbb",2.2,22,"valid","يجب ان ملاحظات الخدمة "));
        arraylistAllServices.add(new Service(3,"ccc dcc",3.3,33,"valid","يجب ان ملاحظات الخدمة "));
        arraylistAllServices.add(new Service(4,"ddddd",4.4,44,"notvalid","يجب ان ملاحظات الخدمة "));
        return arraylistAllServices;
    }

    public static ArrayList<Departmant> getDepartmants(){
        arrayListDepartmant.clear();
       Departmant d =  new Departmant(1,"department 1 ","fa-fire");

        ArrayList<Service> arraylistAllServices2 = new ArrayList<>();
        arraylistAllServices2.add(new Service(1,"aaaaa",1.1,11,"notvalid","يجب ان ملاحظات الخدمة "));
        arraylistAllServices2.add(new Service(2,"bbbbb",2.2,22,"valid","يجب ان ملاحظات الخدمة "));

        d.setServices(arraylistAllServices2);

        arrayListDepartmant.add(d);

        Departmant d2 =  new Departmant(2,"department 2 ","fa-dollar-sign");

        ArrayList<Service> arraylistAllServices3 = new ArrayList<>();
        arraylistAllServices3.add(new Service(3,"ccc dcc",3.3,33,"valid","يجب ان ملاحظات الخدمة "));
        arraylistAllServices3.add(new Service(4,"ddddd",4.4,44,"notvalid","يجب ان ملاحظات الخدمة "));
        d2.setServices(arraylistAllServices3);

        arrayListDepartmant.add(d2);

        Departmant d3 =  new Departmant(2,"department 2 ","fa-users");

        ArrayList<Service> arraylistAllServices4 = new ArrayList<>();
        arraylistAllServices4.add(new Service(3,"ccc dcc",3.3,33,"valid","يجب ان ملاحظات الخدمة "));
        arraylistAllServices4.add(new Service(4,"ddddd",4.4,44,"notvalid","يجب ان ملاحظات الخدمة "));
        d2.setServices(arraylistAllServices4);

        arrayListDepartmant.add(d3);

        Departmant d4 =  new Departmant(2,"department 2 ","fa-drafting-compass");

        ArrayList<Service> arraylistAllServices5 = new ArrayList<>();
        arraylistAllServices5.add(new Service(3,"ccc dcc",3.3,33,"valid","يجب ان ملاحظات الخدمة "));
        arraylistAllServices5.add(new Service(4,"ddddd",4.4,44,"notvalid","يجب ان ملاحظات الخدمة "));
        d2.setServices(arraylistAllServices5);

        arrayListDepartmant.add(d4);

        return arrayListDepartmant;
    }

    public static ArrayList<Service> getServicesInDep(int idDep){
        arraylistServicesInDepartment.clear();
        arraylistServicesInDepartment.add(new Service(1,"طلب عداد",1.1,11,"valid","يجب ان ملاحظات الخدمة "));
        arraylistServicesInDepartment.add(new Service(2,"bbbbb",2.2,22,"valid","يجب ان ملاحظات الخدمة "));
        arraylistServicesInDepartment.add(new Service(3,"ccc dcc",3.3,33,"valid","يجب ان ملاحظات الخدمة "));
        arraylistServicesInDepartment.add(new Service(4,"ddddd",4.4,44,"valid","يجب ان ملاحظات الخدمة "));
        arraylistServicesInDepartment.add(new Service(5,"eeeeed",1.1,11,"valid","يجب ان ملاحظات الخدمة "));
        arraylistServicesInDepartment.add(new Service(6,"ffffr",2.2,22,"notvalid","يجب ان ملاحظات الخدمة "));
        return arraylistServicesInDepartment;
    }

    public static ArrayList<ServiceCitizen> getServicesCitizen(){
        //Date
        ArrayList<ServiceCitizen> myService = new ArrayList<>();
        Service s = new Service(1,"aaaaa",1.1,11,"notvalid","يجب ان ملاحظات الخدمة ");
        ServiceCitizen cs = new ServiceCitizen(1,s,1,"2012-2-5","done");
        ServiceCitizen cs1 = new ServiceCitizen(2,s,1,"1019-4-1","notdone");
        myService.add(cs);
        myService.add(cs1);
        return myService;
    }
    public static ArrayList<ServiceCitizen> getDoneServicesCitizen(){
        //Date
        ArrayList<ServiceCitizen> myServices = new ArrayList<>();
        Service s = new Service(1,"aaaaa",1.1,11,"valid","يجب ان ملاحظات الخدمة ");
        ServiceCitizen cs = new ServiceCitizen(1,s,1,"2012-2-5","done");
        myServices.add(cs);
        return myServices;
    }
    public static ArrayList<ServiceCitizen> getNotDoneServicesCitizen(){
        //Date
        ArrayList<ServiceCitizen> myService = new ArrayList<>();
        Service s = new Service(1,"aaaaa",1.1,11,"valid","يجب ان ملاحظات الخدمة ");
        ServiceCitizen cs1 = new ServiceCitizen(2,s,1,"1019-4-1","notdone");
        myService.add(cs1);
        return myService;
    }
    public static ArrayList<Attachment> getServiceAttachment(int idService){
        ArrayList<Attachment> Attachments = new ArrayList<>();
        //File file = new File("filepath.txt");
        Attachment a = new Attachment(1,"طلب عداد");
        a.setNote("يجب ان ");
        a.setSrc(new File("aa"));
        Attachment b = new Attachment(2,"هوية");
        b.setNote("يجب ام تكاون واضحه ");
        Attachments.add(a);
        Attachments.add(b);
        Attachments.add(b);
        Attachments.add(b);
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

    public static ArrayList<Service> getArraylistServicesInDepartment() {
        return arraylistServicesInDepartment;
    }

    public static void setArraylistServicesInDepartment(ArrayList<Service> arraylistServicesInDepartment) {
        GetFromDB.arraylistServicesInDepartment = arraylistServicesInDepartment;
    }
}
