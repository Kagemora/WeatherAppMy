package com.example.weatherappmy.presentation.favorites

import com.example.weatherappmy.domain.entities.Weather

sealed class UiStateWeather {
    object Loading : UiStateWeather()
    data class Succes(val weather: Weather) : UiStateWeather()
    data class Error(val error: String) : UiStateWeather()
}