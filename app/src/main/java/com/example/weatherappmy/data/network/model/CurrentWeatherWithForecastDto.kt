package com.example.weatherappmy.data.network.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherWithForecastDto(
    @SerializedName("current")
    val currentWeatherDto: CurrentWeatherDto,
    @SerializedName("forecast")
    val forecast: ForecastWeatherDto
)
