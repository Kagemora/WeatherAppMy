package com.example.weatherappmy.presentation.favorites.ui

sealed class UiState {
    object Loading : UiState()
    data class Success(val city: List<CityWithWeather>) : UiState()
    data class Error(val error: String) : UiState()
}