package com.example.michael.deliveryapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.michael.deliveryapp.Login.Login;

/**
 * Created by Patrick Vu on 11/30/2015.
 * Class that controls the application's splashscreen.
 */
public class SplashScreen extends Activity {
    private static int SPLASH_SCREEN_DURATION = 3000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Launches the main activity after displaying the splashscreen.
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(SplashScreen.this, Login.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_SCREEN_DURATION);
    }
}