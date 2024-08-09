package com.example.weatherappmy.di.module

import com.example.weatherappmy.data.repository.FavouriteRepositoryImpl
import com.example.weatherappmy.data.repository.SearchRepositoryImpl
import com.example.weatherappmy.data.repository.WeatherRepositoryImpl
import com.example.weatherappmy.di.annotation.ApplicationScope
import com.example.weatherappmy.domain.repository.FavouriteRepository
import com.example.weatherappmy.domain.repository.SearchRepository
import com.example.weatherappmy.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface BindsRepositoryModule {

    @ApplicationScope
    @Binds
    fun bindSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository

    @ApplicationScope
    @Binds
    fun bindFavouriteRepository(favouriteRepositoryImpl: FavouriteRepositoryImpl): FavouriteRepository

    @ApplicationScope
    @Binds
    fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository
}