package com.example.weatherappmy.presentation.favorites

import androidx.lifecycle.ViewModel
import com.example.weatherappmy.domain.usecase.ChangeFavouriteStateUseCase
import com.example.weatherappmy.domain.usecase.GetCurrentWeatherUseCase
import com.example.weatherappmy.domain.usecase.GetFavouriteCitiesUseCase
import javax.inject.Inject

class FavouritesCityViewModel @Inject constructor(
    private val getFavouriteCitiesUseCase: GetFavouriteCitiesUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val changeFavouriteStateUseCase: ChangeFavouriteStateUseCase
) : ViewModel() {


}