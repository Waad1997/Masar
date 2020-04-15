package com.masar.masarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {

    private static final String TAG = "LogIn";
    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private Button btnSign, btnLog, btnRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);


        inputEmail = (EditText) findViewById(R.id.logInEmailEditText);
        inputPassword = (EditText) findViewById(R.id.logInPasswordeEditText);
        btnSign = (Button) findViewById(R.id.logInSignUpButton);
        btnLog = (Button) findViewById(R.id.logInButton);
        btnRes = (Button) findViewById(R.id.logInForgotPasswordButton);


        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, SignUp.class);

                startActivity(intent);
            }
        });

        auth = FirebaseAuth.getInstance();


        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogIn.this, SignUp.class));
            }
        });

        // Login button and validation
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                //if condition to validate the input

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Please Enter a a valid Email!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Please Enter a Password!", Toast.LENGTH_LONG).show();
                    return;
                }


                // check the auth in the firebase
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    if (auth.getCurrentUser().isEmailVerified()) {
                                        Intent intent = new Intent(LogIn.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(LogIn.this, "Please verify your email address", Toast.LENGTH_LONG).show();

                                    }
                            } else {
                                    Log.e("ERROR AUTHENTICATION", "Password and confirmation do not match" + task.getException().getMessage());
<<<<<<< HEAD
=======

                                    Toast.makeText(LogIn.this, task.getException().getMessage().toString(), Toast.LENGTH_LONG).show();
                                } else {
                                    Intent intent = new Intent(LogIn.this, MasarMenu.class);
                                    startActivity(intent);
                                    finish();
>>>>>>> origin/Maha
                                }
                            }
                        });


            }

        });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Enter your registered email", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(email)

                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LogIn.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(LogIn.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });
    }

}