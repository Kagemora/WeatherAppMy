package com.example.weatherappmy.presentation.favorites

import com.example.weatherappmy.domain.entities.City

sealed class UiStateCity {
    object Loading : UiStateCity()
    data class Success(val city: List<City>) : UiStateCity()
    data class Error(val error: String) : UiStateCity()
}