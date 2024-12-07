package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.entities.Weather
import com.example.weatherappmy.domain.repository.WeatherRepository
import com.example.weatherappmy.domain.util.Result
import javax.inject.Inject


class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(cityId: Int): Result<Weather> = repository.getWeather(cityId)
}