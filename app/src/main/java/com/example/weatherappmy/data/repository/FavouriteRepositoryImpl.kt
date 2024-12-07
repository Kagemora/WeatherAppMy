package com.example.weatherappmy.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.weatherappmy.data.cache.FavouriteCityDao
import com.example.weatherappmy.data.mapper.CityMapper
import com.example.weatherappmy.data.util.safeCall
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.FavouriteRepository
import com.example.weatherappmy.domain.util.Result
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val cityMapper: CityMapper,
    private val favouriteCityDao: FavouriteCityDao
) : FavouriteRepository {
    val list = listOf(City(1, "Moscow", "Russia"), City(2, "Dubai", "United Arab Emirates"), City(3, "New York", "United States of America"))
    override fun favouriteCities(): LiveData<Result<List<City>>> {
        return favouriteCityDao.getFavouriteCity().map {
            try {
                val data = cityMapper.toEntitiesFromDb(it)
                Result.Success(list)
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }
    }

    override fun isCityFavourite(cityId: Int): LiveData<Result<Boolean>> {
        return favouriteCityDao.getObserveIsCity(cityId).map {
            try {
                Result.Success(it)
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }
    }

    override suspend fun addToFavourite(cityId: City): Result<Unit> {
        return safeCall {
            val data = cityMapper.toDbModel(cityId)
            favouriteCityDao.addCity(data)
        }

    }

    override suspend fun removeToFavourite(cityId: Int): Result<Unit> {
        return safeCall {
            favouriteCityDao.deleteCity(cityId)
        }
    }
}

