package com.example.weatherappmy.presentation.weather.ui

import com.example.weatherappmy.domain.entities.Weather

sealed class UiStateCurrentWeather {
    data object Loading : UiStateCurrentWeather()
    data class Success(val weather: Weather) : UiStateCurrentWeather()
    data class Error(val error: String) : UiStateCurrentWeather()
}