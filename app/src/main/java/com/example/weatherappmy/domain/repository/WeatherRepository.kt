package com.example.weatherappmy.domain.repository

import com.example.weatherappmy.domain.entities.DailyWeather
import com.example.weatherappmy.domain.entities.Weather
import com.example.weatherappmy.domain.entities.HourlyWeather
import com.example.weatherappmy.domain.entities.CurrentWeather
import com.example.weatherappmy.domain.util.Result
import java.util.Calendar

interface WeatherRepository {

    suspend fun getCurrentWeather(cityId: Int): Result<CurrentWeather>
    suspend fun getWeather(cityId: Int): Result<Weather>


}