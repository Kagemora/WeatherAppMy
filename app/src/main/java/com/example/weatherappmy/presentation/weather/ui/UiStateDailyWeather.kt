package com.example.weatherappmy.presentation.weather.ui

import com.example.weatherappmy.domain.entities.DailyWeather

sealed class UiStateDailyWeather {
    data object Loading : UiStateDailyWeather()
    data class Success(val dailyWeather: List<DailyWeather>) : UiStateDailyWeather()
    data class Error(val error: String) : UiStateDailyWeather()
}