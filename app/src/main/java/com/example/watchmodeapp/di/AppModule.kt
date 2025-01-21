package com.example.watchmodeapp.di

import com.example.watchmodeapp.AppViewModel
import com.example.watchmodeapp.network.WatchmodeApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit

private val json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
}
private val baseUrl = "https://api.watchmode.com/v1/"

val appModule = module {

    single<WatchmodeApiService> {
        Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()
            .create(WatchmodeApiService::class.java)
    }


    // ViewModels
    viewModelOf(::AppViewModel)
}