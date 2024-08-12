package com.example.weatherappmy.domain.repository

import com.example.weatherappmy.domain.entities.DailyForecast
import com.example.weatherappmy.domain.entities.Forecast
import com.example.weatherappmy.domain.entities.HourlyForecast
import com.example.weatherappmy.domain.entities.Weather
import com.example.weatherappmy.domain.util.Resource
import java.util.Calendar

interface WeatherRepository {
    suspend fun getWeather(cityId: Int): Resource<Weather>
    suspend fun getForecast(cityId: Int): Resource<Forecast>
    suspend fun getHourlyForecast(
        cityId: Int,
        selectedDay: Calendar
    ): Resource<List<HourlyForecast>>

    suspend fun getDailyForecast(cityId: Int): Resource<List<DailyForecast>>
}