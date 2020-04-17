package com.masar.masarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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


        inputEmail = findViewById(R.id.logInEmailEditText);
        inputPassword = findViewById(R.id.logInPasswordeEditText);
        btnSign = findViewById(R.id.logInSignUpButton);
        btnLog = findViewById(R.id.logInButton);
        btnRes = findViewById(R.id.logInForgotPasswordButton);


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
                                        Intent intent = new Intent(LogIn.this, MasarMenu.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(LogIn.this, "Please verify your email address", Toast.LENGTH_LONG).show();

                                    }
                                } else {
                                    Log.e("ERROR AUTHENTICATION", "Password and confirmation do not match" + task.getException().getMessage());

                                    Toast.makeText(LogIn.this, task.getException().getMessage().toString(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });


            }

        });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    ResetFragment resetFragment = new ResetFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.reset_fragment, resetFragment);
                    fragmentTransaction.commit();
//                    getSupportFragmentManager().beginTransaction().
//                            replace(R.id.reset_fragment, new ResetFragment()).commit();

            }

        });
    }
}