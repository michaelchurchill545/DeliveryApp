package com.example.michael.deliveryapp.Login;

/**
 * Created by Patrick Balingit on 11/30/2015.
 *
 * A class that allows access to the student id, password and room number to be accessible by one method called User.
 * @ param studentID, password, and roomNumber
 */
public class User {
    String studentID, password;
    int roomNumber;

    public User(String studentID, String password, int roomNumber) {
        this.studentID = studentID;
        this.password = password;
        this.roomNumber = roomNumber;
    }


}

