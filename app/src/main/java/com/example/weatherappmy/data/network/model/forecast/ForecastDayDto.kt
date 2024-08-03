package com.example.weatherappmy.data.network.model.forecast

import com.google.gson.annotations.SerializedName

data class ForecastDayDto(
    @SerializedName("date_epoch")
    val time: Long,
    @SerializedName("day")
    val day: DayDto,
    @SerializedName("hour")
    val hour: List<HoursDto>
)
