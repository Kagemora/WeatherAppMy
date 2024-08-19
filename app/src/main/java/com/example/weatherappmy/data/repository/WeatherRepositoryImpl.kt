package com.example.weatherappmy.data.repository

import com.example.weatherappmy.data.mapper.getHourlyForecastForDay
import com.example.weatherappmy.data.mapper.toDailyForecastList
import com.example.weatherappmy.data.mapper.toEntity
import com.example.weatherappmy.data.network.WeatherApi
import com.example.weatherappmy.data.util.safeCall
import com.example.weatherappmy.domain.entities.DailyForecast
import com.example.weatherappmy.domain.entities.Forecast
import com.example.weatherappmy.domain.entities.HourlyForecast
import com.example.weatherappmy.domain.entities.Weather
import com.example.weatherappmy.domain.repository.WeatherRepository
import com.example.weatherappmy.domain.util.Result
import java.util.Calendar
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeather(cityId: Int): Result<Weather> {
        return safeCall {
            api.loadCurrentWeather("$PREFIX_CITY_ID$cityId").toEntity()
        }
    }

    override suspend fun getForecast(cityId: Int): Result<Forecast> {
        return safeCall {
            api.loadForecastWeather("$PREFIX_CITY_ID$cityId").toEntity()
        }
    }

    override suspend fun getHourlyForecast(
        cityId: Int, selectedDay: Calendar
    ): Result<List<HourlyForecast>> {
        return safeCall {
            api.loadForecastWeather("$PREFIX_CITY_ID$cityId").getHourlyForecastForDay(selectedDay)
        }
    }

    override suspend fun getDailyForecast(cityId: Int): Result<List<DailyForecast>> {
        return safeCall {
            api.loadForecastWeather("$PREFIX_CITY_ID$cityId").toDailyForecastList()
        }
    }

}

private const val PREFIX_CITY_ID = "id:"