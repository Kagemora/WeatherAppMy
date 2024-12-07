package com.example.weatherappmy.presentation.search.ui

sealed class UiStateCitySearch {
    data object Loading : UiStateCitySearch()
    data class Success<out T>(val city: T) : UiStateCitySearch()
    data class Error(val error: String) : UiStateCitySearch()
}