package com.example.weatherappmy.data.network.model

import com.google.gson.annotations.SerializedName

data class ForecastWeatherDto(
    @SerializedName("forecastday")
    val dailyForecastDto: List<DailyForecastDto>
)
