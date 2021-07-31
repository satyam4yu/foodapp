package com.example.myapplication.Models;

public class MainModel {
    int image;
    String name,orderPrice,description;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MainModel(int image, String name, String Price, String description) {
        this.image = image;
        this.name = name;
        this.orderPrice = Price;
        this.description = description;

    }}

