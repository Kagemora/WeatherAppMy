package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.repository.FavouriteRepository
import com.example.weatherappmy.domain.repository.WeatherRepository
import javax.inject.Inject

//получение избранного списка городов
class GetFavouriteCitiesUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {
    operator fun invoke() = repository.favouriteCities()
}