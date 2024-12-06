package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.repository.WeatherRepository
import javax.inject.Inject

//обновление текущего прогноза
class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(cityId: Int) = repository.getWeather(cityId)
}