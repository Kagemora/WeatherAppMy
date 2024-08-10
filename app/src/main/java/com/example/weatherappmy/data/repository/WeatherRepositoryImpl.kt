package com.example.weatherappmy.data.repository

import com.example.weatherappmy.data.mapper.getHourlyForecastForDay
import com.example.weatherappmy.data.mapper.toDailyForecastList
import com.example.weatherappmy.data.mapper.toEntity
import com.example.weatherappmy.data.network.WeatherApi
import com.example.weatherappmy.domain.entities.DailyForecast
import com.example.weatherappmy.domain.entities.Forecast
import com.example.weatherappmy.domain.entities.HourlyForecast
import com.example.weatherappmy.domain.entities.Weather
import com.example.weatherappmy.domain.repository.WeatherRepository
import java.util.Calendar
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeather(cityId: Int): Weather {
        return api.loadCurrentWeather("$PREFIX_CITY_ID$cityId").toEntity()
    }

    override suspend fun getForecast(cityId: Int): Forecast {
        return api.loadForecastWeather("$PREFIX_CITY_ID$cityId").toEntity()
    }

    override suspend fun getHourlyForecast(
        cityId: Int,
        selectedDay: Calendar
    ): List<HourlyForecast> {
        return api.loadForecastWeather("$PREFIX_CITY_ID$cityId")
            .getHourlyForecastForDay(selectedDay)
    }


    override suspend fun getDailyForecast(cityId: Int): List<DailyForecast> {
        return api.loadForecastWeather("$PREFIX_CITY_ID$cityId").toDailyForecastList()
    }
}

private const val PREFIX_CITY_ID = "id:"