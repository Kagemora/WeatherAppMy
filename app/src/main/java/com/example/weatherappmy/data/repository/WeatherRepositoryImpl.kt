package com.example.weatherappmy.data.repository

import com.example.weatherappmy.domain.entities.DailyForecast
import com.example.weatherappmy.domain.entities.Forecast
import com.example.weatherappmy.domain.entities.HourlyForecast
import com.example.weatherappmy.domain.entities.Weather
import com.example.weatherappmy.domain.repository.WeatherRepository
import java.util.Calendar
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(

) : WeatherRepository {
    override suspend fun getWeather(cityId: Int): Weather {
        TODO("Not yet implemented")
    }

    override suspend fun getForecast(cityId: Int): Forecast {
        TODO("Not yet implemented")
    }

    override suspend fun getHourlyForecast(
        cityId: Int,
        selectedDay: Calendar
    ): List<HourlyForecast> {
        TODO("Not yet implemented")
    }


    override suspend fun getDailyForecast(cityId: Int): List<DailyForecast> {
        TODO("Not yet implemented")
    }
}