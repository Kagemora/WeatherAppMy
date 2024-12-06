package com.example.weatherappmy.presentation.weather.ui

import com.example.weatherappmy.domain.entities.HourlyWeather

sealed class UiStateHourlyWeather {
    data object Loading : UiStateHourlyWeather()
    data class Success(val hourly: List<HourlyWeather>) : UiStateHourlyWeather()
    data class Error(val error: String) : UiStateHourlyWeather()
}