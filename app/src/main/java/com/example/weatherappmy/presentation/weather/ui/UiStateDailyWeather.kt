package com.example.weatherappmy.presentation.weather.ui

import com.example.weatherappmy.domain.entities.DailyForecast

sealed class UiStateDailyWeather {
    object Loading : UiStateDailyWeather()
    data class Success(val dailyForecast: List<DailyForecast>) : UiStateDailyWeather()
    data class Error(val error: String) : UiStateDailyWeather()
}