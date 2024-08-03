package com.example.weatherappmy.data.network.model.forecast

import com.example.weatherappmy.data.network.model.ConditionDto
import com.google.gson.annotations.SerializedName

data class HoursDto(
    @SerializedName("time_epoch")
    val time: Long,
    @SerializedName("temp_c")
    val tempC: Float,
    @SerializedName("condition")
    val condition: ConditionDto

)
