package com.masar.masarapp.networking;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DataServiceGenerator {

    private static final String TAG = "DataServiceGenerator";

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Routes.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            Log.d(TAG, "getRetrofit() method " + retrofit);
        }

        return retrofit;

    }
}
