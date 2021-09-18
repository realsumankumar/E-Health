package com.example.pharmacyservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medicine {
    @Id
    private String name;
    private int price;
    private String availableQuantity;

    public Medicine(){}

    public Medicine(String name, int price, String availableQuantity) {
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(String availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
