package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.repository.WeatherRepository
import javax.inject.Inject

//получение почасового прогноза
class GetHourlyForecastUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(cityId: Int) = repository.getHourlyForecast(cityId)
}