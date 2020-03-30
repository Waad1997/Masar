package com.masar.masarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Profile extends AppCompatActivity {
EditText Pname, Pdate, Pemail;
RadioButton Pfemale, Pmale;
Button Psave;
User user;
DatabaseReference reff;

    private FloatingActionButton resetpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        Pname = (EditText) findViewById(R.id.profileNameTextInputEditText);
        Pdate = (EditText) findViewById(R.id.profileBirthdaytextInputEditText);
        Pemail = (EditText) findViewById(R.id.profileEmailTextInputEditText);
        Pfemale = (RadioButton) findViewById(R.id.profileFemaleRadioButton);
        Pmale = (RadioButton) findViewById(R.id.profileMaleRadioButton);
        user = new User();
        reff = FirebaseDatabase.getInstance().getReference().child("User");
        Psave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(Pname.getText().toString().trim());
                user.setBday(Pdate.getText().toString().trim());
                user.setEmail(Pemail.getText().toString().trim());
                user.setFemale(Pfemale);
                user.setMale(Pmale);
                reff.push().setValue(user);
                Toast.makeText(Profile.this,"Data inserted successfully",Toast.LENGTH_LONG).show();
            }
        });



        resetpassword = (FloatingActionButton) findViewById(R.id.profileResetPassFloatingActionButton);

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, ResetPassword.class);

                startActivity(intent);
            }
        });
    }
}
