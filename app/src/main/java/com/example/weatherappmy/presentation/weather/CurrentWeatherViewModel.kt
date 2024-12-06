package com.example.weatherappmy.presentation.weather

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CurrentWeatherViewModel @Inject constructor (
    private val getDailyForecastUseCase: GetDailyForecastUseCase
) : ViewModel() {


    

}