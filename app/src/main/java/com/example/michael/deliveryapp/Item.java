package com.example.michael.deliveryapp;

import java.io.Serializable;

/**
 * Created by michael on 11/18/2015.
 */
public class Item implements Serializable {
    private String name;
    private int iconId;
    private double itemPrice;
    private String description;

    public Item(String name, String description, double price, int iconId) {
        this.name = name;
        this.iconId = iconId;
        itemPrice = price;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public int getIconId() {
        return iconId;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}



