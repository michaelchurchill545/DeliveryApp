package com.example.michael.deliveryapp;

/**
 * Created by michael on 11/18/2015.
 */
public class Item {
    private String name;
    private int iconId;
    private String itemPrice;

    public Item(String name, String description, String price, int iconId) {
        this.name = name;
        this.iconId = iconId;
        itemPrice = price;
    }

    public String getName() {
        return name;
    }

    public int getIconId() {
        return iconId;
    }

    public String getItemPrice() {
        return itemPrice;
    }
}
