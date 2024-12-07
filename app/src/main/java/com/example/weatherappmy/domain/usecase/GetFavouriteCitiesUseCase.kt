package com.example.weatherappmy.domain.usecase

import androidx.lifecycle.LiveData
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.FavouriteRepository
import com.example.weatherappmy.domain.repository.WeatherRepository
import com.example.weatherappmy.domain.util.Result
import javax.inject.Inject


class GetFavouriteCitiesUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {
    operator fun invoke(): LiveData<Result<List<City>>> = repository.favouriteCities()
}