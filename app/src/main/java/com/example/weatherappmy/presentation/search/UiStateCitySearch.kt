package com.example.weatherappmy.presentation.search

import com.example.weatherappmy.domain.entities.City

sealed class UiStateCitySearch {
    object Loading : UiStateCitySearch()
    data class Success(val city: List<City>) : UiStateCitySearch()
    data class Error(val error: String) : UiStateCitySearch()
}