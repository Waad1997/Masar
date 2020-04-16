package com.masar.masarapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SignUp";

    private EditText txtEmail, txtPassword, txtPassword2;
    private FloatingActionButton btnBack;
    private Button btnSignup;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        txtEmail = findViewById(R.id.singUpEmailEditText);
        txtPassword = findViewById(R.id.singUpPasswordEditText);
        txtPassword2 = findViewById(R.id.singUpConfirmPasswordEditText);

        btnBack = findViewById(R.id.signUpBackFloatingActionButton);
        btnBack.setOnClickListener(this);

        btnSignup = findViewById(R.id.singup_Button);
        btnSignup.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();


    }


    //The given sign-in provider is disabled for this Firebase project. Enable it in the Firebase

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUpBackFloatingActionButton:
                startActivity(new Intent(SignUp.this, LogIn.class));

                break;

            case R.id.singup_Button:
                navigation();

                break;
        }
    }

    public void navigation() {


        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        String confirmPass = txtPassword2.getText().toString().trim();

        if(email.equals("") || password.equals("") || confirmPass.equals("")) {
            String message = "Please fill all required fields";
            Toast.makeText(SignUp.this, message, Toast.LENGTH_LONG).show();

        } else if(!password.equals(confirmPass)) {
            String message = "Password doesn't match";
            Toast.makeText(SignUp.this, message, Toast.LENGTH_LONG).show();
        } else {

            final ProgressDialog progressDialog = ProgressDialog.show(SignUp.this, "Please wait...", "Processing...", true);

            (firebaseAuth.createUserWithEmailAndPassword(email, password))
                    .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();

                            if (task.isSuccessful()) {
                                firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(SignUp.this, "Registered successfully, please verify your email.", Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(SignUp.this, LogIn.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                        }

                                    }
                                });

                            }
                        }
                    });
        }

    }
}