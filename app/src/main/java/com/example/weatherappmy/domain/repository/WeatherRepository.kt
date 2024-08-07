package com.example.weatherappmy.domain.repository

import com.example.weatherappmy.domain.entities.DailyForecast
import com.example.weatherappmy.domain.entities.Forecast
import com.example.weatherappmy.domain.entities.HourlyForecast
import com.example.weatherappmy.domain.entities.Weather
import java.util.Calendar

interface WeatherRepository {
    suspend fun getWeather(cityId:Int): Weather
    suspend fun getForecast(cityId: Int): Forecast
    suspend fun getHourlyForecast(cityId: Int, selectedDay: Calendar):List<HourlyForecast>
    suspend fun getDailyForecast(cityId: Int):List<DailyForecast>
}