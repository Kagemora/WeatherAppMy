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
import com.example.weatherappmy.domain.util.NetworkError
import com.example.weatherappmy.domain.util.Resource
import retrofit2.HttpException
import java.io.IOException
import java.util.Calendar
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeather(cityId: Int): Resource<Weather> {
        return handleNetworkErrors {
            api.loadCurrentWeather("$PREFIX_CITY_ID$cityId").toEntity()
        }
    }

    override suspend fun getForecast(cityId: Int): Resource<Forecast> {
        return handleNetworkErrors {
            api.loadForecastWeather("$PREFIX_CITY_ID$cityId").toEntity()
        }
    }

    override suspend fun getHourlyForecast(
        cityId: Int,
        selectedDay: Calendar
    ): Resource<List<HourlyForecast>> {
        return handleNetworkErrors {
            api.loadForecastWeather("$PREFIX_CITY_ID$cityId")
                .getHourlyForecastForDay(selectedDay)
        }
    }

    override suspend fun getDailyForecast(cityId: Int): Resource<List<DailyForecast>> {
        return handleNetworkErrors {
            api.loadForecastWeather("$PREFIX_CITY_ID$cityId").toDailyForecastList()
        }
    }

    private suspend fun <T> handleNetworkErrors(action: suspend () -> T): Resource<T> {
        return try {
            Resource.Success(action())
        } catch (e: IOException) {
            Resource.Error(NetworkError.NoInternet)
        } catch (e: HttpException) {
            Resource.Error(NetworkError.ServerError)
        } catch (e: Exception) {
            Resource.Error(NetworkError.UnknownError(e.message))
        }
    }
}

private const val PREFIX_CITY_ID = "id:"