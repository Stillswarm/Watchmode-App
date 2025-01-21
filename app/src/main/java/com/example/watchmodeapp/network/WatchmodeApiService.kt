package com.example.watchmodeapp.network

import com.example.watchmodeapp.BuildConfig.MY_API_KEY
import com.example.watchmodeapp.model.Title
import com.example.watchmodeapp.model.TitleList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WatchmodeApiService {
    @GET("list-titles/")
    suspend fun getTitleList(
        @Query("sort_by") sortBy: String,
        @Query("types") types: String,
        @Query("apiKey") apiKey: String = MY_API_KEY,
        @Query("page") page: Int,
        @Query("limit") limit: Int = 6
    ): Response<TitleList>

    @GET("title/{title-id}/details/")
    suspend fun getTitleById(
        @Path("title-id") titleId: Int,
        @Query("apiKey") apiKey: String = MY_API_KEY
    ) : Response<Title>

}