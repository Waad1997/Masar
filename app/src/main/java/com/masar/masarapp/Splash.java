package com.masar.masarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

import com.masar.masarapp.R;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    // On activity creation // perform basic application startup logic that should happen only once for the entire life of the activity
        // call the super class onCreate to complete the creation of activity like the view hierarchy
        super.onCreate(savedInstanceState);                 // savedInstanceState >> a Bundle object containing the activity's previously saved state
        setContentView(R.layout.splash);                    // set the user interface layout for this activity

        new Handler().postDelayed(() -> {
            Intent i = new Intent(Splash.this, LogIn.class);    // To navigate within the app
            startActivity(i);
            finish();
        }, SPLASH_TIME_OUT);
    }
}
