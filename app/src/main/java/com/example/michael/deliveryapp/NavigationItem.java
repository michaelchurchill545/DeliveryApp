package com.example.michael.deliveryapp;

/**
 * Created by Patrick Vu on 11/12/2015.
 */
public class NavigationItem {
    private String mName;
    private String mDescription;
    private int mIcon;

    public NavigationItem(String name, String description, int icon) {
        mName = name;
        mDescription = description;
        mIcon = icon;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getIcon() {
        return mIcon;
    }
}
