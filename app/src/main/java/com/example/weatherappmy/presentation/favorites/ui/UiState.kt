package com.example.weatherappmy.presentation.favorites.ui

sealed class UiState {
    object Loading : UiState()
    data class Success(val cityWithWeather: List<CityWithWeather>) : UiState()
    data class Error(val error: String) : UiState()
    object Empty : UiState()
}