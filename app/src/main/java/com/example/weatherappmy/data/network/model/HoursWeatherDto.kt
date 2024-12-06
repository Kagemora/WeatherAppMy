package com.example.weatherappmy.data.network.model

import com.google.gson.annotations.SerializedName

data class HoursWeatherDto(
    @SerializedName("time_epoch")
    val time: Long,
    @SerializedName("temp_c")
    val tempC: Float,
    @SerializedName("condition")
    val condition: ConditionWeatherDto

)