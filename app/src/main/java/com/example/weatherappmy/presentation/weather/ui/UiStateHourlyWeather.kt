package com.example.weatherappmy.presentation.weather.ui

import com.example.weatherappmy.domain.entities.HourlyForecast

sealed class UiStateHourlyWeather {
    object Loading : UiStateHourlyWeather()
    data class Success(val hourly: List<HourlyForecast>) : UiStateHourlyWeather()
    data class Error(val error: String) : UiStateHourlyWeather()
}