package com.masar.masarapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;

import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUp extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtPassword, txtPassword2;
    private Button btnBack;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        txtEmail = (EditText) findViewById(R.id.singUpEmailEditText);
        txtPassword = (EditText) findViewById(R.id.singUpPasswordEditText);
        txtPassword2 = (EditText) findViewById(R.id.singUpConfirmPasswordEditText);
        //btnBack = (Button) findViewById(R.id.signUpBackFloatingActionButton);
        firebaseAuth = FirebaseAuth.getInstance();

 ////       btnBack.setOnClickListener(new View.OnClickListener() {
     //       @Override
       //     public void onClick(View v) {
         //       startActivity(new Intent(SignUp.this, LogIn.class));
           // }
        //});


    }

    public void navigation(View v) {

        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        String confirmPass = txtPassword2.getText().toString().trim();

        final ProgressDialog progressDialog = ProgressDialog.show(SignUp.this, "Please wait...", "Processing...", true);

        (firebaseAuth.createUserWithEmailAndPassword(email, password))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Registration successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(SignUp.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}