package com.example.weatherappmy.data.network.model

import com.google.gson.annotations.SerializedName

data class DayWeatherDto(
    @SerializedName("avgtemp_c")
    val avgTempC: Float,
    @SerializedName("condition")
    val conditionWeatherDto: ConditionWeatherDto
)
