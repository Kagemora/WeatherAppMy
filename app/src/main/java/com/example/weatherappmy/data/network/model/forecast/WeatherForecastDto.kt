package com.example.weatherappmy.data.network.model.forecast

import com.example.weatherappmy.data.network.model.CurrentDto
import com.google.gson.annotations.SerializedName

data class WeatherForecastDto(
    @SerializedName("current")
    val currentDto: CurrentDto,
    @SerializedName("forecast")
    val forecast: ForecastDto
)
