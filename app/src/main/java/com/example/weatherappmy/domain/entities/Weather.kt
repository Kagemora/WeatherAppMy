package com.example.weatherappmy.domain.entities

import java.util.Calendar

data class Weather(
    val time: Calendar,
    val condition: String,
    val conditionUrl: String,
    val tempC: Float
)
