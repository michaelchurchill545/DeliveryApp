/**
 * Created by Patrick Balingit on 11/21/2015.
 */
package com.example.michael.deliveryapp.Login;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.michael.deliveryapp.Home;
import com.example.michael.deliveryapp.R;


public class Login extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText eID, ePassword, roomNumber;
    TextView registerLink;

    public static UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eID = (EditText) findViewById(R.id.Usernamefield);
        ePassword = (EditText) findViewById(R.id.Passfield);
        bLogin = (Button) findViewById(R.id.login);
        roomNumber = (EditText) findViewById(R.id.CVRoomNumber);
        registerLink = (TextView) findViewById(R.id.regsterHere);

        bLogin.setOnClickListener(this);
        registerLink.setOnClickListener(this);


        userLocalStore = new UserLocalStore(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                // int studentID = Integer.parseInt(eID.getText().toString());
                String studentID = eID.getText().toString();
                String password = ePassword.getText().toString();
                if (studentID.isEmpty()) {
                    eID.setError("Please enter a student ID");
                } else if (password.isEmpty()) {
                    ePassword.setError("Please enter your password");
                } else if (studentID.equals(userLocalStore.getUser().studentID) &&
                        password.equals(userLocalStore.getUser().password)) {
                    startActivity(new Intent(this, Home.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Username or Password.",
                            Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.regsterHere:
                startActivity(new Intent(this, Register.class));
                break;
        }
    }

    private void authenticate(User user) {
        ServerRequest serverRequest = new ServerRequest(this);
        serverRequest.fetchUserDataBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                if (returnedUser == null) {
                    showErrorMessage();
                } else {
                    logUserIn(returnedUser);
                }
            }
        });
    }

    private void showErrorMessage() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Login.this);
        dialogBuilder.setMessage("Incorrect User Details");
        dialogBuilder.setPositiveButton("OK", null);
        dialogBuilder.show();
    }

    private void logUserIn(User returnedUser) {
        userLocalStore.storeUserData(returnedUser);
        userLocalStore.setUserLoggedIn(true);

        startActivity(new Intent(this, Home.class));

    }
//    private Object loadSerializedObject(File f)
//    {
//        try
//        {
//            ObjectInputStream ois = new ObjectInputStream
//                    (new FileInputStream(f));
//            Object o = ois.readObject();
//            return o;
//        }
//        catch(Exception ex)
//        {
//            Log.v("Serlization Read Error:",ex.getMessage());
//            ex.printStackTrace();
//        }
//        return null;
//    }
}



