package com.example.springauthenticateendpoint.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

public class ImageModel {
    public ImageModel() {
        super();
    }
    public ImageModel(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }
    private String id;
    private String name;
    private String type;
    private byte[] picByte;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public byte[] getPicByte() {
        return picByte;
    }
    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}
