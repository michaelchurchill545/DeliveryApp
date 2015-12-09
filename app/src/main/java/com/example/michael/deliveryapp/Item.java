package com.example.michael.deliveryapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by michael on 11/18/2015.
 * This is a well encapsulated class that represents an item that a user can buy.
 */
public class Item implements Parcelable {
    private String name;
    private int iconId;
    private double itemPrice;
    private String description;

    public Item(String name, String description, double price, int iconId) {
        this.name = name;
        this.iconId = iconId;
        this.itemPrice = price;
        this.description = description;
    }

    /**
     * Created By Roben
     */
    private Item(Parcel in) {
        name = in.readString();
        description = in.readString();
        itemPrice = in.readDouble();
        iconId = in.readInt();

    }

    /**
     * Getter
     *
     * @return the item's description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter
     *
     * @return the item's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter
     * @return the item's integer id for the appropriate icon that should be displayed
     */
    public int getIconId() {
        return this.iconId;
    }

    /**
     * Getter
     * @return the item's price
     */
    public double getItemPrice() {
        return this.itemPrice;
    }

    /**
     *
     * Created by Roben
     *
     * @param o - the item that is being compared to
     * @return true if price is the same, false if item is out of stock or price is different
     */
    @Override
    public boolean equals(Object o){

        Item thiItem = (Item) o;
        if(getItemPrice() == (int) thiItem.getItemPrice()){ //if item is same price than true [switch]
            return true;
        }
        if(o == null){ //if item is out of stock than false [do not switch]
            return false;
        }
        if(getItemPrice() != thiItem.getItemPrice()){ //if item is different price than false [do not switch]
            return false;
        }
        return true;
    }


    /**
     * Created By Roben
     */
    @Override
    public int describeContents() {
        return 0;
    }




    /**
     * Created By Roben
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeDouble(itemPrice);
        dest.writeInt(iconId);
    }

    /**
     * Created By Roben
     */
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}



