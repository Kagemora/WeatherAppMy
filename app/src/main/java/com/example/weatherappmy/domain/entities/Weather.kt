package com.example.weatherappmy.domain.entities


data class Weather(
    val currentWeather: CurrentWeather,
    val hourlyWeather: List<HourlyWeather>,
    val dailyWeather: List<DailyWeather>
)
