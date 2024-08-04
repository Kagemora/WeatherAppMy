package com.example.weatherappmy.data.repository

import androidx.lifecycle.LiveData
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.FavouriteRepository
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(

) : FavouriteRepository {
    override fun favouriteCities(): LiveData<List<City>> {
        TODO("Not yet implemented")
    }

    override fun observeIsFavourite(cityId: Int): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFavourite(cityId: City) {
        TODO("Not yet implemented")
    }

    override suspend fun removeToFavourite(cityId: Int) {
        TODO("Not yet implemented")
    }
}