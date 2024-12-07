package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.FavouriteRepository
import com.example.weatherappmy.domain.util.Result
import javax.inject.Inject


class AddRemoveFavouriteCityUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {
    suspend fun addToFavourite(city: City): Result<Unit> = repository.addToFavourite(city)
    suspend fun removeFromFavourite(cityId: Int): Result<Unit> =
        repository.removeToFavourite(cityId)
}