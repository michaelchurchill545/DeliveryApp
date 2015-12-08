package com.example.michael.deliveryapp;

/**
 * Created by Patrick Vu on 11/12/2015.
 * A well encapsulated class that caters specifically to the fragment navigation drawer class.
 * This class is different than the item class because the Nav items do not have a price.
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
