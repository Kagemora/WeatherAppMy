package com.example.weatherappmy.data.network.model.current

import com.example.weatherappmy.data.network.model.CurrentDto
import com.google.gson.annotations.SerializedName

data class WeatherCurrentDto(
    @SerializedName("current")
    val currentDto: CurrentDto
)
