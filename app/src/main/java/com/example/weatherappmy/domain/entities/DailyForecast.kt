package com.example.weatherappmy.domain.entities

import java.util.Calendar

//прогноз по дням
data class DailyForecast (
    val time: Calendar,
    val condition: String,
    val conditionUrl: String,
    val tempC:Float
)