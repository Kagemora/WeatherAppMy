package com.example.weatherappmy.data.network

import com.example.weatherappmy.data.network.model.CityInfoDto
import com.example.weatherappmy.data.network.model.CurrentWeatherDto
import com.example.weatherappmy.data.network.model.CurrentWeatherWithForecastDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

// дока тут
// https://www.weatherapi.com/api-explorer.aspx
interface WeatherApi {

    @Headers("key: $API_KEY")
    @GET(CURRENT_JSON)
    suspend fun loadCurrentWeather(
        @Query("q") query: String
    ): CurrentWeatherDto

    @Headers("key: $API_KEY")
    @GET(FORECAST_JSON)
    suspend fun loadCurrentWeatherWithForecast(
        @Query("q") query: String,
        @Query("days") int: Int = 5
    ): CurrentWeatherWithForecastDto

    @Headers("key: $API_KEY")
    @GET(SEARCH_JSON)
    suspend fun loadSearchCity(
        @Query("q") query: String
    ): List<CityInfoDto>

}

private const val FORECAST_JSON = "forecast.json"
private const val CURRENT_JSON = "current.json"
private const val SEARCH_JSON = "search.json"

private const val API_KEY = "2acefc9d1e244226822111750242503"

