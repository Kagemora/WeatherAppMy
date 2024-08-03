package com.example.weatherappmy.data.network.model.forecast

import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("forecastday")
    val forecastDayDto: List<ForecastDayDto>
)
