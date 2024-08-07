package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.repository.WeatherRepository
import java.util.Calendar
import javax.inject.Inject

//получение почасового прогноза
class GetHourlyForecastUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(cityId: Int, selectedDay: Calendar) =
        repository.getHourlyForecast(cityId, selectedDay)
}