package com.example.weatherappmy.presentation.favorites.ui

import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.entities.Weather

data class CityWithWeather(
    val city: City,
    val weather: Weather
)
