package com.example.weatherappmy.domain.entities

import java.util.Calendar

//почасовой прогноз
data class HourlyForecast(
    val time: Calendar,
    val condition: String,
    val conditionUrl: String,
    val tempC:Float
)
