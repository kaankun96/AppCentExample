package com.example.kaan.appcent.Services;

import com.example.kaan.appcent.Model.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kaan on 12.04.2017.
 */

public interface RetroInterface
{
    @GET("venues/search")
    Call<SearchResponse> getVenueJson(
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("v") String version,
            @Query("ll") String ll);
}
