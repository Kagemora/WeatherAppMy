package com.example.weatherappmy.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.weatherappmy.data.cache.FavouriteCityDao
import com.example.weatherappmy.data.mapper.toDbModel
import com.example.weatherappmy.data.mapper.toEntities
import com.example.weatherappmy.data.util.safeCall
import com.example.weatherappmy.domain.util.Result
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.FavouriteRepository
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteCityDao: FavouriteCityDao
) : FavouriteRepository {

    override fun favouriteCities(): LiveData<Result<List<City>>> {
        return favouriteCityDao.getFavouriteCity().map {
            try {
                Result.Success(it.toEntities())
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }
    }

    override fun observeIsFavourite(cityId: Int): LiveData<Result<Boolean>> {
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
            favouriteCityDao.addCity(cityId.toDbModel())
        }

    }

    override suspend fun removeToFavourite(cityId: Int): Result<Unit> {
        return safeCall {
            favouriteCityDao.deleteCity(cityId)
        }
    }
}

