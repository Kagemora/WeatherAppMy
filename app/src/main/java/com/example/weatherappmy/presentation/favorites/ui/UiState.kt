package com.example.weatherappmy.presentation.favorites.ui

sealed class UiState {
    data object Loading : UiState()
    data class Success(val cityWithWeather: List<CityWithWeather>) : UiState()
    data class Error(val error: String) : UiState()
    data object Empty : UiState()
}