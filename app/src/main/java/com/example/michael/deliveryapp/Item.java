package com.example.michael.deliveryapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by michael on 11/18/2015.
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

    private Item(Parcel in) {
        name = in.readString();
        description = in.readString();
        itemPrice = in.readDouble();
        iconId = in.readInt();

    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public int getIconId() {
        return this.iconId;
    }

    public double getItemPrice() {
        return this.itemPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeDouble(itemPrice);
        dest.writeInt(iconId);
    }

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



