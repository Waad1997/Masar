package com.masar.masarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddCover extends AppCompatActivity {

    private Button Anext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_cover);

        Anext =  (Button) findViewById(R.id.addCoverNextButton3);

        Anext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(AddCover.this, AddCoverMsg.class);

                    startActivity(intent);



            }
        });
    }
}
