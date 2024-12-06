package com.example.weatherappmy.domain.entities

//прогноз для отдельного фрагмента с отображением текущего,по часам и дням
data class Weather(
    val currentWeather: CurrentWeather,
    val hourlyWeather: List<HourlyWeather>,
    val dailyWeather: List<DailyWeather>
)
