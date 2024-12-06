package com.example.weatherappmy.domain.entities

import java.util.Calendar

data class CurrentWeather(
    val time: Calendar,
    val condition: String,
    val conditionUrl: String,
    val tempC: Float
){
    companion object {
        val default = CurrentWeather(
            time = Calendar.getInstance(),
            condition = "Unknown",
            conditionUrl = "",
            tempC = 0.0f
        )
    }
}
