package com.masar.masarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Settings extends AppCompatActivity {

    private FloatingActionButton addCover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        addCover = (FloatingActionButton) findViewById(R.id.settingsAddCoverButton);

        // to take us to the add cover page
        addCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, AddCover.class);

                startActivity(intent);
            }
        });
    }
}
