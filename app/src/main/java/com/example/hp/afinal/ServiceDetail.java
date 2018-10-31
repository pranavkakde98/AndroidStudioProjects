package com.example.hp.afinal;

import java.io.Serializable;

public class ServiceDetail implements Serializable {

    public String serviceName,address,hours;
    public String price,date;

    public ServiceDetail() {
    }

    public ServiceDetail(String serviceName, String address, String hours, String price, String date) {
        this.serviceName = serviceName;
        this.address = address;
        this.hours = hours;
        this.price = price;
        this.date = date;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


