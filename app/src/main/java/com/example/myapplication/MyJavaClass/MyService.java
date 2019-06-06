package com.example.myapplication.MyJavaClass;

import java.util.ArrayList;

public class MyService {
    int id;
    String name;
    Double cost;
    int days;
    String caseserv;
    int departmentId;
    int sectionId;
    String note;
    ArrayList<Attachment> attachments;


    public MyService() {
    }

    public MyService(int id, String name, Double cost, int days, String caseserv, String note) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.days = days;
        this.caseserv = caseserv;
        this.note = note;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getCaseserv() {
        return caseserv;
    }

    public void setCaseserv(String caseserv) {
        this.caseserv = caseserv;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<Attachment> attachments) {
        this.attachments = attachments;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
