package com.example.myapplication.MyJavaClass;

import android.util.Log;

import com.example.myapplication.models.Department;
import com.example.myapplication.models.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetFromDB {

    static List<Service> listAllServices = new ArrayList<>();
    static ArrayList<MyService> MyarraylistAllServices = new ArrayList<>();
    static ArrayList<MyService> arraylistServicesInDepartment = new ArrayList<>();

    //static  ArrayList<MyDepartmant> arrayListDepartmant = new ArrayList<>();
    public GetFromDB() {

    }

    public static List<Service> getListAllServices() {
        return listAllServices;
    }

    public static void setListAllServices(List<Service> listAllServices) {
        GetFromDB.listAllServices = listAllServices;
    }

    //////////
    public static ArrayList<MyService> getAllServices() {
        MyarraylistAllServices.clear();
        MyarraylistAllServices.add(new MyService(1, "aaaaa", 1.1, 11, "notvalid", "يجب ان ملاحظات الخدمة "));
        MyarraylistAllServices.add(new MyService(2, "bbbbb", 2.2, 22, "valid", "يجب ان ملاحظات الخدمة "));
        MyarraylistAllServices.add(new MyService(3, "ccc dcc", 3.3, 33, "valid", "يجب ان ملاحظات الخدمة "));
        MyarraylistAllServices.add(new MyService(4, "ddddd", 4.4, 44, "notvalid", "يجب ان ملاحظات الخدمة "));
        return MyarraylistAllServices;
    }

    public static ArrayList<Department> getDepartmants() {
        boolean flag;
        ArrayList<Department> departmants = new ArrayList<>();
        for (int i = 0; i < listAllServices.size(); i++) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if (listAllServices.get(i).getDepartment().getId().equals(departmants.get(j).getId())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                departmants.add(listAllServices.get(i).getDepartment());
            }

        }
//        MyDepartmant d =  new MyDepartmant(1,"department 1 ","fa-fire");
//
//        ArrayList<MyService> arraylistAllServices2 = new ArrayList<>();
//        arraylistAllServices2.add(new MyService(1,"aaaaa",1.1,11,"notvalid","يجب ان ملاحظات الخدمة "));
//        arraylistAllServices2.add(new MyService(2,"bbbbb",2.2,22,"valid","يجب ان ملاحظات الخدمة "));
//
//        d.setServices(arraylistAllServices2);
//
//        arrayListDepartmant.add(d);
//
//        MyDepartmant d2 =  new MyDepartmant(2,"department 2 ","fa-dollar-sign");
//
//        ArrayList<MyService> arraylistAllServices3 = new ArrayList<>();
//        arraylistAllServices3.add(new MyService(3,"ccc dcc",3.3,33,"valid","يجب ان ملاحظات الخدمة "));
//        arraylistAllServices3.add(new MyService(4,"ddddd",4.4,44,"notvalid","يجب ان ملاحظات الخدمة "));
//        d2.setServices(arraylistAllServices3);
//
//        arrayListDepartmant.add(d2);
//
//        MyDepartmant d3 =  new MyDepartmant(2,"department 2 ","fa-users");
//
//        ArrayList<MyService> arraylistAllServices4 = new ArrayList<>();
//        arraylistAllServices4.add(new MyService(3,"ccc dcc",3.3,33,"valid","يجب ان ملاحظات الخدمة "));
//        arraylistAllServices4.add(new MyService(4,"ddddd",4.4,44,"notvalid","يجب ان ملاحظات الخدمة "));
//        d2.setServices(arraylistAllServices4);
//
//        arrayListDepartmant.add(d3);
//
//        MyDepartmant d4 =  new MyDepartmant(2,"department 2 ","fa-drafting-compass");
//
//        ArrayList<MyService> arraylistAllServices5 = new ArrayList<>();
//        arraylistAllServices5.add(new MyService(3,"ccc dcc",3.3,33,"valid","يجب ان ملاحظات الخدمة "));
//        arraylistAllServices5.add(new MyService(4,"ddddd",4.4,44,"notvalid","يجب ان ملاحظات الخدمة "));
//        d2.setServices(arraylistAllServices5);
//
//        arrayListDepartmant.add(d4);

        return departmants;
    }

    public static ArrayList<Service> getServicesInDep(int idDep) {
        ArrayList<Service> services = new ArrayList<>();
        for (Service service : listAllServices) {
            if (service.getDepartment().getId() == idDep){
                services.add(service);
            }
        }
//        arraylistServicesInDepartment.clear();
//        arraylistServicesInDepartment.add(new MyService(1,"طلب عداد",1.1,11,"valid","يجب ان ملاحظات الخدمة "));
//        arraylistServicesInDepartment.add(new MyService(2,"bbbbb",2.2,22,"valid","يجب ان ملاحظات الخدمة "));
//        arraylistServicesInDepartment.add(new MyService(3,"ccc dcc",3.3,33,"valid","يجب ان ملاحظات الخدمة "));
//        arraylistServicesInDepartment.add(new MyService(4,"ddddd",4.4,44,"valid","يجب ان ملاحظات الخدمة "));
//        arraylistServicesInDepartment.add(new MyService(5,"eeeeed",1.1,11,"valid","يجب ان ملاحظات الخدمة "));
//        arraylistServicesInDepartment.add(new MyService(6,"ffffr",2.2,22,"notvalid","يجب ان ملاحظات الخدمة "));

        return services;
    }

    public static ArrayList<ServiceCitizen> getServicesCitizen() {
        //Date
        ArrayList<ServiceCitizen> myService = new ArrayList<>();
        MyService s = new MyService(1, "aaaaa", 1.1, 11, "notvalid", "يجب ان ملاحظات الخدمة ");
        ServiceCitizen cs = new ServiceCitizen(1, s, 1, "2012-2-5", "done");
        ServiceCitizen cs1 = new ServiceCitizen(2, s, 1, "1019-4-1", "notdone");
        myService.add(cs);
        myService.add(cs1);
        return myService;
    }

    public static ArrayList<ServiceCitizen> getDoneServicesCitizen() {
        //Date
        ArrayList<ServiceCitizen> myServices = new ArrayList<>();
        MyService s = new MyService(1, "طلب عداد", 1.1, 11, "valid", "يجب ان ملاحظات الخدمة ");
        ServiceCitizen cs = new ServiceCitizen(1, s, 1, "2012-2-5", "done");
        myServices.add(cs);
        return myServices;
    }

    public static ArrayList<ServiceCitizen> getNotDoneServicesCitizen() {
        //Date
        ArrayList<ServiceCitizen> myService = new ArrayList<>();
        MyService s = new MyService(1, "طلب عداد", 1.1, 11, "valid", "يجب ان ملاحظات الخدمة ");
        ServiceCitizen cs1 = new ServiceCitizen(2, s, 1, "1019-4-1", "notdone");
        myService.add(cs1);
        return myService;
    }

    public static ArrayList<Attachment> getServiceAttachment(int idService) {
        ArrayList<Attachment> Attachments = new ArrayList<>();
        //File file = new File("filepath.txt");
        Attachment a = new Attachment(1, "طلب عداد");
        a.setNote("يجب ان ");
        a.setSrc(new File("aa"));
        Attachment b = new Attachment(2, "هوية");
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

    public static boolean checkUsers(String username, String password) {
        Log.d("MyApppppp", password);
        if ((password.equals("1")) && username.equals("1")) {
            return true;
        }
        return false;
    }


    public static ArrayList<MyService> getMyarraylistAllServices() {
        return MyarraylistAllServices;
    }

    public static void setMyarraylistAllServices(ArrayList<MyService> myarraylistAllServices) {
        GetFromDB.MyarraylistAllServices = myarraylistAllServices;
    }

    public static ArrayList<MyService> getArraylistServicesInDepartment() {
        return arraylistServicesInDepartment;
    }

    public static void setArraylistServicesInDepartment(ArrayList<MyService> arraylistServicesInDepartment) {
        GetFromDB.arraylistServicesInDepartment = arraylistServicesInDepartment;
    }

    public static Service getSelectedService(int idService) {
        for (Service service:listAllServices) {
            if(service.getId() == idService)
                return service;
        }
        return null;

    }

}
