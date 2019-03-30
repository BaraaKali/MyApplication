package com.example.myapplication.MyJavaClass;

import java.io.File;

public class Attachment {
    int id;
    String name;
    File src;


    public Attachment(int id, String name, File src) {
        this.id = id;
        this.name = name;
        this.src = src;
    }

    public Attachment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Attachment(int id) {
        this.id = id;
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

    public File getSrc() {
        return src;
    }

    public void setSrc(File src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return name ;
    }
}
