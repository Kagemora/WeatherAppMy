package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.FavouriteRepository
import javax.inject.Inject

//добавление / удаление городов
class ChangeFavouriteStateUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {
    suspend fun addToFavourite(city: City) = repository.addToFavourite(city)
    suspend fun removeFromFavourite(cityId: Int) = repository.removeToFavourite(cityId)
}