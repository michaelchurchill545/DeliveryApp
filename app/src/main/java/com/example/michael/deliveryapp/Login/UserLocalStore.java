package com.example.michael.deliveryapp.Login;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;

/**
 * Created by Patrick Balingit on 11/21/2015.
 */
public class UserLocalStore implements Serializable {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;
    private static final long serialVersionUID = 465434455;

    public UserLocalStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public SharedPreferences getUserLocalDatabase() {
        return userLocalDatabase;
    }

    public void setUserLocalDatabase(SharedPreferences userLocalDatabase) {
        this.userLocalDatabase = userLocalDatabase;
    }

    public void storeUserData(User user) {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("studentID", user.studentID);
        spEditor.putString("password", user.password);
        spEditor.putInt("roomNumber", user.roomNumber);
        spEditor.commit();
    }

    public User getUser() {
        String studentID = userLocalDatabase.getString("studentID", 0 + "");
        String password = userLocalDatabase.getString("password", 0 + "");
        int roomNumber = userLocalDatabase.getInt("roomNumber", 0);

        User storedUser = new User(studentID, password, roomNumber);
        return storedUser;

    }

    public void setUserLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggin() {
        return userLocalDatabase.getBoolean("loggedIn", false) == true;

    }

    public void clearUserData() {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
