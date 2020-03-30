package com.masar.masarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MasarMenu extends AppCompatActivity {
  //  private ImageButton home;
    private ImageButton profile;
    private ImageButton support;
    private ImageButton settings;
    private ImageButton faq;
    private ImageButton notificatio;
    private ImageButton signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masar_menu);

       // home = (ImageButton) findViewById(R.id.masarMenuHomeButton);
        profile = (ImageButton) findViewById(R.id.masarMenuProfileButton);
        support = (ImageButton) findViewById(R.id.masarMenuSupportsButton);
        settings = (ImageButton) findViewById(R.id.masarMenuSettingsButton);
        faq = (ImageButton) findViewById(R.id.masarMenuFqaButton);
        notificatio = (ImageButton) findViewById(R.id.masarMenuNotificationButton);
        signout = (ImageButton) findViewById(R.id.masarMenuSignoutButton);
        // home.setOnClickListener(new View.OnClickListener()

//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MasarMenu.this, Profile.class);
//
//                startActivity(intent);
//            }
//        });
//
//        support.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MasarMenu.this, Support.class);
//
//                startActivity(intent);
//            }
//        });
//
//        settings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MasarMenu.this, Settings.class);
//
//                startActivity(intent);
//            }
//        });
//
//        faq.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MasarMenu.this, Fqa.class);
//
//                startActivity(intent);
//            }
//        });
//
//
//        notificatio.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MasarMenu.this, Notificatio.class);
//
//                startActivity(intent);
//            }
//        });
//
//        signout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MasarMenu.this, LogIn.class);
//
//                startActivity(intent);
//            }
//        });
//
//
 }}
