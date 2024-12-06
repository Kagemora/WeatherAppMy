package com.example.weatherappmy.presentation.favorites.ui

import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.entities.CurrentWeather

data class CityWithWeather(
    val city: City,
    val currentWeather: CurrentWeather
)
