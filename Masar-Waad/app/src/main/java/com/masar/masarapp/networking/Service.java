package com.masar.masarapp.networking;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET(Routes.END_POINT_LAT)
    Call<String> getLat();

    @GET(Routes.END_POINT_LON)
    Call<String> getLon();

}
