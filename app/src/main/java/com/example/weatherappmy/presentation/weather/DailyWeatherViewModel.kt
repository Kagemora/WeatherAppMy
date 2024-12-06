package com.example.weatherappmy.presentation.weather

import androidx.lifecycle.ViewModel
import com.example.weatherappmy.domain.usecase.ObserveFavouriteStateUseCase
import javax.inject.Inject

class DailyWeatherViewModel @Inject constructor(
    private val getDailyForecastUseCase: GetDailyForecastUseCase,
    private val observeFavouriteStateUseCase: ObserveFavouriteStateUseCase
) : ViewModel() {

}