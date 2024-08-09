package com.example.weatherappmy.di.module

import com.example.weatherappmy.data.network.WeatherApi
import com.example.weatherappmy.di.annotation.ApplicationScope
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@Module
object ApiModule {

    @ApplicationScope
    @Provides
    fun provideWeatherApi(): WeatherApi {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create()
    }

    private const val API_URL = "https://api.weatherapi.com/v1/"

}

