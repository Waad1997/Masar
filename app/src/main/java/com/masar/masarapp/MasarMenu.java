package com.masar.masarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class MasarMenu extends AppCompatActivity {

    private ImageButton home;
    private ImageButton profile;
    private ImageButton support;
    private ImageButton settings;
    private ImageButton faq;
    private ImageButton notificatio;
    private ImageButton signout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masar_menu);

        // uses the firebase instense for the user signs out
        firebaseAuth = FirebaseAuth.getInstance();



        // calling all the buttons in the xml code to give them a function
       home = (ImageButton) findViewById(R.id.masarMenuHomeButton);
        profile = (ImageButton) findViewById(R.id.masarMenuProfileButton);
        support = (ImageButton) findViewById(R.id.masarMenuSupportsButton);
        settings = (ImageButton) findViewById(R.id.masarMenuSettingsButton);
        faq = (ImageButton) findViewById(R.id.masarMenuFqaButton);
        notificatio = (ImageButton) findViewById(R.id.masarMenuNotificationButton);
        signout = (ImageButton) findViewById(R.id.masarMenuSignoutButton);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MasarMenu.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        // opens the profile page
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasarMenu.this, Profile.class);

                startActivity(intent);
            }
        });


        // opens the support page
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasarMenu.this, Support.class);

                startActivity(intent);
            }
        });


        // opens the settings page
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasarMenu.this, Settings.class);

                startActivity(intent);
            }
        });


        // opens the faq page
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasarMenu.this, Fqa.class);

                startActivity(intent);
            }
        });


        // opens the notificatio page
        notificatio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasarMenu.this, Notification.class);

                startActivity(intent);
            }
        });


        // signs out the user and opens the log in page
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  firebaseAuth.signOut();
                  finish();
                Intent intent = new Intent(MasarMenu.this, LogIn.class);
                startActivity(intent);
            }
        });


 }}
