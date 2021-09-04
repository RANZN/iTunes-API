package com.ranzan.itunesapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/search")
    Call<Response> getResult(@Query("term") String term);
}
