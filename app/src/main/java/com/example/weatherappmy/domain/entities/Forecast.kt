package com.example.weatherappmy.domain.entities

//прогноз для отдельного фрагмента с отображением текущего,по часам и дням
data class Forecast(
    val currentWeather: Weather,
    val hourlyForecast: List<HourlyForecast>,
    val dailyForecast: List<DailyForecast>
)
