package com.masar.masarapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "Profile";

    private EditText Pname, Pdate;
    private TextView Pemail,txmale,txfemale;
    private Button Psave;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private FloatingActionButton resetpassword;
    String Name, Date;
    String Gender = "Not selected yet";
    User userProfile;
    FirebaseUser userEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        //calling all the components in the xml code to give them a function


        Pname = (EditText) findViewById(R.id.profileNameTextInputEditText);
        Pdate = (EditText) findViewById(R.id.profileBirthdaytextInputEditText);
        Pemail = (TextView) findViewById(R.id.profileEmailTextInputEditText);

        resetpassword = (FloatingActionButton) findViewById(R.id.profileResetPassFloatingActionButton);
        Psave = (Button) findViewById(R.id.profileSaveButton);
        txmale = (TextView) findViewById(R.id.tx_male);
        txmale.setOnClickListener(this);
        txfemale = (TextView) findViewById(R.id.tx_female);
        txfemale.setOnClickListener(this);

        // getting the user who is logged in
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        // the user's email
        userEmail = FirebaseAuth.getInstance().getCurrentUser();

        // getting the user's id
        final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        // retrieving the user's information
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                userProfile = new User();
                userProfile = dataSnapshot.getValue(User.class);
                Pname.setText(userProfile.getName());
                Pdate.setText(userProfile.getBirthday());
                Pemail.setText(userEmail.getEmail());
                String GenderFirebase = dataSnapshot.child("gender").getValue().toString();
                if (GenderFirebase.equals("Male"))
                {
                    getMale();

                }
               else
                {
                getFemale();
                }


            }

            // show an error msg when an error occurs
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Profile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });


        // to push the user's information to the database
        Psave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendUserData();


            }
        });



        // to go to the reset password page
        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, ResetPassword.class);

                startActivity(intent);
            }
        });


    }



    // pushing data method
    private void sendUserData() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        Name = Pname.getText().toString();
        Date = Pdate.getText().toString();
        userProfile = new User(Name, Date, Gender);

        myRef.setValue(userProfile);

    }



    public void getMale() {

        txmale.setTextColor(getResources().getColor(R.color.white));
        txmale.setBackgroundResource(R.drawable.rounded_button_orange);
        txfemale.setTextColor(getResources().getColor(R.color.grey));
        txfemale.setBackground(null);

    }



        public void getFemale() {

            txfemale.setTextColor(getResources().getColor(R.color.white));
            txfemale.setBackgroundResource(R.drawable.rounded_button_orange);
            txmale.setTextColor(getResources().getColor(R.color.grey));
            txmale.setBackground(null);
    }



    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.tx_male:
           getMale();
                Gender = "Male";
                break;
            case R.id.tx_female:
               getFemale();
                Gender = "Female";
                break;
        }
    }

}



