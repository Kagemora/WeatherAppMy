package com.example.weatherappmy.data.repository

import com.example.weatherappmy.data.mapper.WeatherMapper
import com.example.weatherappmy.data.network.WeatherApi
import com.example.weatherappmy.data.util.safeCall
import com.example.weatherappmy.domain.entities.Weather
import com.example.weatherappmy.domain.entities.CurrentWeather
import com.example.weatherappmy.domain.repository.WeatherRepository
import com.example.weatherappmy.domain.util.Result
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherMapper: WeatherMapper, private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getCurrentWeather(cityId: Int): Result<CurrentWeather> {
        return safeCall {
            val data = api.loadCurrentWeather("$PREFIX_CITY_ID$cityId")
            weatherMapper.mapToCurrentWeather(data)
        }
    }

    override suspend fun getWeather(cityId: Int): Result<Weather> {
        return safeCall {
            val data = api.loadCurrentWeatherWithForecast("$PREFIX_CITY_ID$cityId")
            weatherMapper.mapToWeather(data)
        }
    }


}

private const val PREFIX_CITY_ID = "id:"