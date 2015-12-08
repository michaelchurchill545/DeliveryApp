package com.example.michael.deliveryapp.Login;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;

/**
 * Created by Patrick Balingit on 11/21/2015.
 *
 * Since the Server Request was not working, we implemented a local store of the variables via Serializable to store the data in a file
 * Using this class also lets the User login and Register classes
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

    /**
     * StoreUserData grabs the data from studentID, password and roomNumber to be collected from the Register.class and Login.class
     * @param user
     */
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


        return new User(studentID, password, roomNumber);

    }

    // Method to set the User Login and make sure it was a registered user. Error is showned when error is found
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
