package com.example.weatherappmy.domain.repository

import com.example.weatherappmy.domain.entities.DailyForecast
import com.example.weatherappmy.domain.entities.Forecast
import com.example.weatherappmy.domain.entities.HourlyForecast
import com.example.weatherappmy.domain.entities.Weather
import com.example.weatherappmy.domain.util.Result
import java.util.Calendar

interface WeatherRepository {
    suspend fun getWeather(cityId: Int): Result<Weather>
    suspend fun getForecast(cityId: Int): Result<Forecast>
    suspend fun getHourlyForecast(
        cityId: Int,
        selectedDay: Calendar
    ): Result<List<HourlyForecast>>

    suspend fun getDailyForecast(cityId: Int): Result<List<DailyForecast>>
}