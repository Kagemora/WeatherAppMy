package com.example.weatherappmy.presentation.weather

import androidx.lifecycle.ViewModel
import com.example.weatherappmy.domain.usecase.GetHourlyForecastUseCase
import javax.inject.Inject

class HourlyWeatherViewModel @Inject constructor(
    private val getHourlyForecastUseCase: GetHourlyForecastUseCase
) : ViewModel() {

}