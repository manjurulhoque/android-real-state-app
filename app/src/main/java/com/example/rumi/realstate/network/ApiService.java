package com.example.rumi.realstate.network;

import com.example.rumi.realstate.model.Listing;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("listings")
    Call<List<Listing>> getListings();

//    @GET("search")
//    Call<List<Feed>> getSearchList(@Query("property") String property, @Query("offer") String offer, @Query("city") String city);
}
