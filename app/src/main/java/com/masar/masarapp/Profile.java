package com.masar.masarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Profile extends AppCompatActivity {

    Context mContext;
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
//        Pemail = (EditText) findViewById(R.id.profileEmailTextInputEditText);
//        Pfemale = (RadioButton) findViewById(R.id.profileFemaleRadioButton);
//        Pmale = (RadioButton) findViewById(R.id.profileMaleRadioButton);
        Psave = (Button) findViewById(R.id.profileSaveButton);
 //       SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Pname.setText(getIntent().getStringExtra("Name"));
        Pdate.setText(getIntent().getStringExtra("Date"));
//        Pemail.setText(getIntent().getStringExtra("Email"));
//        Pfemale.setText(getIntent().getStringExtra("Gender"));
//        Pmale.setText(getIntent().getStringExtra("Gender"));

        user = new User();
        reff = FirebaseDatabase.getInstance().getReference().child("User");
        Psave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(Pname.getText().toString().trim());
                user.setBday(Pdate.getText().toString().trim());
//                user.setEmail(Pemail.getText().toString().trim());
//                user.setFemale(Pfemale);
//                user.setMale(Pmale);

                FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
                reff.push().setValue(user);
//
//                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Profile.this);
//                SharedPreferences.Editor editor = prefs.edit();
//                editor.apply();
//                Toast.makeText(Profile.this, "Data inserted successfully", Toast.LENGTH_LONG).show();

            }
        });
//
//
        resetpassword = (FloatingActionButton) findViewById(R.id.profileResetPassFloatingActionButton);

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, ResetPassword.class);

                startActivity(intent);
            }
        });

//
//        /**
//         * Bassam Code
//         *
//         * Fetch data
//         */
//        // ########################## Fetch request #######################################
//
////        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("users").child("profile");
////
////        dbRef.addValueEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                String name = dataSnapshot.child("name").getValue().toString();
////
////                Pname.setText(name);
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError databaseError) {
////
////            }
////        });
////
//
//
//        // ########################### End Fetch request ###########################################
//
//
//        /**
//         * POST request to the firebase
//         */
//
//
//        // ############################ POST request ################################
//
//        // edit text == pname
//        // button psave
//
//        FirebaseDatabase database;
//        DatabaseReference ref;
//        DatabaseReference mDatabaseUsers;
//        FirebaseUser mCurrentUser;
//        User user;
//        FirebaseAuth mAuth;
//
//
//        database = FirebaseDatabase.getInstance();
//        ref = FirebaseDatabase.getInstance().getReference().child("users");
//        mAuth = FirebaseAuth.getInstance();
//        mCurrentUser = mAuth.getCurrentUser();
//        mDatabaseUsers = FirebaseDatabase.getInstance().getReference().child("users").child(mCurrentUser.getUid());
//
//        user = new User();
//
//        Psave.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                @SuppressWarnings("VisibleForTests") final DatabaseReference newPost = ref.push();
////                mDatabaseUsers.addValueEventListener(new ValueEventListener() {
////                    @Override
////                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                       // getValues();
////
////                        newPost.child("Name").setValue(user.getName()).addOnCompleteListener(new OnCompleteListener<Void>() {
////                            @Override
////                            public void onComplete(@NonNull Task<Void> task) {
////                                if(task.isSuccessful()) {
////                                    String messaeg = "Your name has been updated";
////                                    Toast.makeText(getApplicationContext(), messaeg, Toast.LENGTH_LONG).show();
////                                }
////                            }
////                        });
////
////                        Pname.setText("");
////
////                    }
////
////                    @Override
////                    public void onCancelled(@NonNull DatabaseError databaseError) {
////
////                    }
////                });
////            }
//        });


        // ############################ End of post request ##########################
    }

//    private void getValues() {
//        user.setName(Pname.getText().toString().trim());
//    }


}
