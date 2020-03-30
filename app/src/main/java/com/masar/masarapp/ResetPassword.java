package com.masar.masarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResetPassword extends AppCompatActivity {

    EditText mCurrentPass, mNewPass, mConfirmPass;
    Button mReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);

        mCurrentPass = findViewById(R.id.resetPasswordCurrentPasswordEditText);
        mNewPass = findViewById(R.id.resetPasswordNewPasswordEditText);
        mConfirmPass = findViewById(R.id.resetPasswordConfirmPasswordEditText);


        mReset = findViewById(R.id.resetPasswordSaveButton);


        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String currentPass, newPass, confirmPass;

                currentPass = mCurrentPass.getText().toString().trim();
                newPass = mNewPass.getText().toString().trim();
                confirmPass = mConfirmPass.getText().toString().trim();

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(),currentPass);

                if(!newPass.equals(confirmPass)) {
                    Toast.makeText(ResetPassword.this, "Password does not match", Toast.LENGTH_LONG).show();

                } else {
                    user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                user.updatePassword(newPass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()) {
                                            Toast.makeText(ResetPassword.this, "Password has been changed", Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(ResetPassword.this, "Error", Toast.LENGTH_LONG).show();

                                        }
                                    }
                                });
                            }
                        }
                    });
                }



            }
        });


//        mReset.setOnClickListener(this);

    }

//    @Override
//    public void onClick(View v) {
//
//
//    }
}