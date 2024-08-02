package com.example.weatherappmy.domain.repository

import androidx.lifecycle.LiveData
import com.example.weatherappmy.domain.entities.City

interface FavouriteRepository {
    fun favouriteCities(): LiveData<List<City>>
    fun observeIsFavourite(cityId: Int): LiveData<Boolean>
    suspend fun addToFavourite(cityId: City)
    suspend fun removeToFavourite(cityId: Int)
}