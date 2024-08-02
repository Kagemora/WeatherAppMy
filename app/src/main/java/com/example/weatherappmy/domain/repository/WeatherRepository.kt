package com.example.weatherappmy.domain.repository

import com.example.weatherappmy.domain.entities.DailyForecast
import com.example.weatherappmy.domain.entities.Forecast
import com.example.weatherappmy.domain.entities.HourlyForecast
import com.example.weatherappmy.domain.entities.Weather

interface WeatherRepository {
    suspend fun getWeather(cityId:Int): Weather
    suspend fun getForecast(cityId: Int): Forecast
    suspend fun getHourlyForecast(cityId: Int):List<HourlyForecast>
    suspend fun getDailyForecast(cityId: Int):List<DailyForecast>
}