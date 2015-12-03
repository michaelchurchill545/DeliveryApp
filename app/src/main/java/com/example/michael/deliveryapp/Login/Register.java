/**
 * Created by Patrick Balingit on 11/21/2015.
 */
package com.example.michael.deliveryapp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.michael.deliveryapp.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText eID, ePassword, roomNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eID = (EditText) findViewById(R.id.Usernamefield);
        ePassword = (EditText) findViewById(R.id.Passfield);
        roomNumber = (EditText) findViewById(R.id.CVRoomNumber);
        bRegister = (Button) findViewById(R.id.register);

        bRegister.setOnClickListener(this);

        Spinner staticSpinner = (Spinner) findViewById(R.id.building);
        Spinner staticSpinner2 = (Spinner) findViewById(R.id.school);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> housingAdapter = ArrayAdapter
                .createFromResource(this, R.array.housing_array,
                        android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> schoolAdapter = ArrayAdapter
                .createFromResource(this, R.array.school_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        housingAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(housingAdapter);
        staticSpinner2.setAdapter(schoolAdapter);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                String studentID = null;
                String password = null;
                int room = 0;
                if (eID.getText().toString() != null) {
                    studentID = eID.getText().toString();
                } else {
                    eID.setError("Enter an ID number");
                }
                if (ePassword.getText().toString() != null) {
                    password = ePassword.getText().toString();
                } else {
                    eID.setError("Enter a password");
                }
                if (roomNumber.getText().toString() != null) {
                    room = Integer.parseInt(roomNumber.getText().toString());
                } else {
                    eID.setError("Enter a room number");
                }

                User registeredData = new User(studentID, password, room);
//                UserLocalStore storeStuff = new UserLocalStore(getApplicationContext());
//                        storeStuff.storeUserData(registeredData);
                Login.userLocalStore.storeUserData(registeredData);
                // saveObject(Login.userLocalStore);
                registerUser(registeredData);
                break;
        }
    }

    private void registerUser(User user) {
        ServerRequest serverRequest = new ServerRequest(this);
        serverRequest.storeUserDataBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {

                startActivity(new Intent(Register.this, Login.class));
            }
        });

    }

    private void saveObject(UserLocalStore userLocalStore) {
        try {
            String filename = Environment.getExternalStorageDirectory()
                    .getPath() + "/UserLocalStore.bin";
            ObjectOutputStream oos = new ObjectOutputStream
                    (new FileOutputStream(new File(filename)));
            //Select where you wish to save the file...
            oos.writeObject(userLocalStore);// write the class as an 'object'
            oos.flush(); // flush the stream to insure all of the
            // information was written to 'save_object.bin'
            oos.close();// close the stream
        } catch (Exception ex) {
            Log.v("Seriazation Save Error:", ex.getMessage());
            ex.printStackTrace();
        }
    }
}
