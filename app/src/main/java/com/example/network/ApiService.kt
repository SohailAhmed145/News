package com.example.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("top-headlines")
    suspend fun getNewsFromServer(
        @Query("country") country: String="us",
        @Query("category") category: String="business",
        @Query("apiKey") apiKey: String ="cebd276e81394e4e9bc42dd783209292"
    ): Response<NewsModel>
}