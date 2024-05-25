package com.example.repo

import com.example.network.ApiProvider
import com.example.network.NewsModel
import retrofit2.Response
import java.util.concurrent.Flow

class Repo (){
    suspend fun newProvider(): Response<NewsModel> {
        return ApiProvider.provideApi().getNewsFromServer()
    }
}