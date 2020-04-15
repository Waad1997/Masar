package com.masar.masarapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.masar.masarapp.networking.DataServiceGenerator;
import com.masar.masarapp.networking.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private String lat;
    private String lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button mBtnSupport = findViewById(R.id.support_btn);
        mBtnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SupportActivity.class));
            }
        });

        Button mBtnTrack = findViewById(R.id.homeTrackMyCoverButton);
        mBtnTrack.setOnClickListener(this);

        getLon();
        getLat();

    }

    @Override
    public void onClick(View view) {

        String url = "http://maps.google.com/?q=" + lon + "," + lat;
        Log.d(TAG, "onClick: " + url);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    private void getLat() {
        Service service = DataServiceGenerator.getRetrofit().create(Service.class);
        Call<String> call = service.getLat();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.body() != null) {
                    lat = response.body().substring(2,12);
                } else {
                    Toast.makeText(getApplicationContext(), "No available coordinates", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void getLon() {

        Service service = DataServiceGenerator.getRetrofit().create(Service.class);
        Call<String> call = service.getLon();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.body() != null) {
                    lon = response.body().substring(2,12);
                } else {
                    Toast.makeText(getApplicationContext(), "No available coordinates", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

}