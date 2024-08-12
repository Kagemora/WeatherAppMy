package com.example.weatherappmy.domain.repository

import androidx.lifecycle.LiveData
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.util.Resource

interface FavouriteRepository {
    fun favouriteCities(): LiveData<List<City>>
    fun observeIsFavourite(cityId: Int): LiveData<Boolean>
    suspend fun addToFavourite(cityId: City): Resource<Unit>
    suspend fun removeToFavourite(cityId: Int): Resource<Unit>
}