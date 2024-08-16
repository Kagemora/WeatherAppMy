package com.example.weatherappmy.presentation.weather.ui

import com.example.weatherappmy.domain.entities.Forecast

sealed class UiStateCurrentWeather {
    object Loading : UiStateCurrentWeather()
    data class Success(val forecast: Forecast) : UiStateCurrentWeather()
    data class Error(val error: String) : UiStateCurrentWeather()
}