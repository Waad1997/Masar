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

        // calling all the components in the xml code to give them a function
        mCurrentPass = (EditText) findViewById(R.id.resetPasswordCurrentPasswordEditText);
        mNewPass = (EditText)  findViewById(R.id.resetPasswordNewPasswordEditText);
        mConfirmPass = (EditText)  findViewById(R.id.resetPasswordConfirmPasswordEditText);
        mReset = (Button) findViewById(R.id.resetPasswordSaveButton);


        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String currentPass, newPass, confirmPass;

                // converting all text into strings and trimming it
                currentPass = mCurrentPass.getText().toString().trim();
                newPass = mNewPass.getText().toString().trim();
                confirmPass = mConfirmPass.getText().toString().trim();

                // getting the user who is logged in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                // the user's credential which are email and the current password
                AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(),currentPass);

                if(!newPass.equals(confirmPass)) {
                    Toast.makeText(ResetPassword.this, "Password does not match", Toast.LENGTH_LONG).show();

                }


                else {
                    // changing the password (reauthenticating)
                    user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                user.updatePassword(newPass).addOnCompleteListener(new OnCompleteListener<Void>() {


                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()) {


                                            Toast.makeText(ResetPassword.this, "Password has been changed", Toast.LENGTH_LONG).show();


                                        }


                                    }
                                });
                            } else {
                                Toast.makeText(ResetPassword.this, "Current password is incorrect", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }



            }
        });


    }

}