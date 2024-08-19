package com.example.weatherappmy.domain.repository

import androidx.lifecycle.LiveData
import com.example.weatherappmy.domain.util.Result
import com.example.weatherappmy.domain.entities.City

interface FavouriteRepository {
    fun favouriteCities(): LiveData<Result<List<City>>>
    fun observeIsFavourite(cityId: Int): LiveData<Result<Boolean>>
    suspend fun addToFavourite(cityId: City): Result<Unit>
    suspend fun removeToFavourite(cityId: Int): Result<Unit>
}