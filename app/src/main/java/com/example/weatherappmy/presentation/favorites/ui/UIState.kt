package com.example.weatherappmy.presentation.favorites.ui

sealed class UIState{
    data class Success<out T>(val data: T) : UIState()
    data class Error(val message: String) : UIState()
    data object Loading : UIState()
}