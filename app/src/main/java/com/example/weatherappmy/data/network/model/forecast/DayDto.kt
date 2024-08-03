package com.example.weatherappmy.data.network.model.forecast

import com.example.weatherappmy.data.network.model.ConditionDto
import com.google.gson.annotations.SerializedName

data class DayDto(
    @SerializedName("avgtemp_c")
    val avgTempC: Float,
    @SerializedName("condition")
    val conditionDto: ConditionDto
)
