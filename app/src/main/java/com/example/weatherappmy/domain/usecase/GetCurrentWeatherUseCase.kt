package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.repository.WeatherRepository
import javax.inject.Inject

//получение текущей погоды
class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(cityId: Int) = repository.getCurrentWeather(cityId)
}