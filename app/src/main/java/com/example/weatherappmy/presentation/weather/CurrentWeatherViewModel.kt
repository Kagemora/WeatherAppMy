package com.example.weatherappmy.presentation.weather

import androidx.lifecycle.ViewModel
import com.example.weatherappmy.domain.usecase.GetDailyForecastUseCase
import javax.inject.Inject

class CurrentWeatherViewModel @Inject constructor (
    private val getDailyForecastUseCase: GetDailyForecastUseCase
) : ViewModel() {

}