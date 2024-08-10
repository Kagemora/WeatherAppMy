package com.example.weatherappmy.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.weatherappmy.data.cache.FavouriteCityDao
import com.example.weatherappmy.data.mapper.toDbModel
import com.example.weatherappmy.data.mapper.toEntities
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.FavouriteRepository
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteCityDao: FavouriteCityDao
) : FavouriteRepository {
    override fun favouriteCities(): LiveData<List<City>> {
        return favouriteCityDao.getFavouriteCity().map { it.toEntities() }
    }

    override fun observeIsFavourite(cityId: Int): LiveData<Boolean> {
        return favouriteCityDao.getObserveIsCity(cityId)
    }

    override suspend fun addToFavourite(cityId: City) {
        return favouriteCityDao.addCity(cityId.toDbModel())
    }

    override suspend fun removeToFavourite(cityId: Int) {
        return favouriteCityDao.deleteCity(cityId)
    }
}