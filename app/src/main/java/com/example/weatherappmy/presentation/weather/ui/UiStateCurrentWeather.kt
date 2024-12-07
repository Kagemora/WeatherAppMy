package com.example.weatherappmy.presentation.weather.ui

sealed class UiStateCurrentWeather {
    data object Loading : UiStateCurrentWeather()
    data class Success<out T>(val weather: T) : UiStateCurrentWeather()
    data class Error(val error: String) : UiStateCurrentWeather()
}