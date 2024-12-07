package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.entities.CurrentWeather
import com.example.weatherappmy.domain.repository.WeatherRepository
import com.example.weatherappmy.domain.util.Result
import javax.inject.Inject


class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(cityId: Int): Result<CurrentWeather> =
        repository.getCurrentWeather(cityId)
}