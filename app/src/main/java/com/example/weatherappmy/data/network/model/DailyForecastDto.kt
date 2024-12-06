package com.example.weatherappmy.data.network.model

import com.google.gson.annotations.SerializedName

data class DailyForecastDto(
    @SerializedName("date_epoch")
    val time: Long,
    @SerializedName("day")
    val day: DayWeatherDto,
    @SerializedName("hour")
    val hour: List<HoursWeatherDto>
)
