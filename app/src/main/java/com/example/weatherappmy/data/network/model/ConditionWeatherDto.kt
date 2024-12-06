package com.example.weatherappmy.data.network.model

import com.google.gson.annotations.SerializedName

data class ConditionWeatherDto(
    @SerializedName("text")
    val text: String,
    @SerializedName("icon")
    val icon: String
)
