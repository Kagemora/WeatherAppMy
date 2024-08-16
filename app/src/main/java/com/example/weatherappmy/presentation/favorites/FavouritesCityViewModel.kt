package com.example.weatherappmy.presentation.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherappmy.domain.usecase.ChangeFavouriteStateUseCase
import com.example.weatherappmy.domain.usecase.GetCurrentWeatherUseCase
import com.example.weatherappmy.domain.usecase.GetFavouriteCitiesUseCase
import com.example.weatherappmy.presentation.favorites.ui.UiStateCity
import com.example.weatherappmy.presentation.favorites.ui.UiStateWeather
import javax.inject.Inject

class FavouritesCityViewModel @Inject constructor(
    private val getFavouriteCitiesUseCase: GetFavouriteCitiesUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val changeFavouriteStateUseCase: ChangeFavouriteStateUseCase
) : ViewModel() {

    val cityList = getFavouriteCitiesUseCase.invoke()

    private val _stateCity = MutableLiveData<UiStateCity>()
    val stateCity: LiveData<UiStateCity>
        get() = _stateCity

    private val _stateWeather = MutableLiveData<UiStateWeather>()
    val stateWeather: LiveData<UiStateWeather>
        get() = _stateWeather


}