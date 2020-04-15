package com.masar.masarapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        // Declare the btnTrack and assign it the Views from the layout file
        btnTrack = (Button) findViewById(R.id.homeTrackMyCoverButton);
    }
}
