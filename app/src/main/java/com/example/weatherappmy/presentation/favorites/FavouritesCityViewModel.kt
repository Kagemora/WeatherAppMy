package com.example.weatherappmy.presentation.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.entities.Weather
import com.example.weatherappmy.domain.usecase.ChangeFavouriteStateUseCase
import com.example.weatherappmy.domain.usecase.GetCurrentWeatherUseCase
import com.example.weatherappmy.domain.usecase.GetFavouriteCitiesUseCase
import com.example.weatherappmy.domain.util.Result
import com.example.weatherappmy.presentation.favorites.ui.CityWithWeather
import com.example.weatherappmy.presentation.favorites.ui.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouritesCityViewModel @Inject constructor(
    private val getFavouriteCitiesUseCase: GetFavouriteCitiesUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val changeFavouriteStateUseCase: ChangeFavouriteStateUseCase
) : ViewModel() {

    private val _uiState = MediatorLiveData<UiState>(UiState.Loading)
    val uiState: LiveData<UiState> = _uiState

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> = _toastMessage


    init {
        loadFavoriteCities()
    }

    private fun loadFavoriteCities() {
        _uiState.addSource(getFavouriteCitiesUseCase()) { cities ->
            when (cities) {
                is Result.Success -> {
                    if (cities.value.isNullOrEmpty()) {
                        _uiState.value = UiState.Empty
                    } else {
                        loadWeatherForCities(cities.value)
                    }
                }

                is Result.Failure -> {
                    _uiState.value = UiState.Error("Failed to load favorite cities")
                }
            }
        }
    }


    private fun loadWeatherForCities(cities: List<City>) {
        viewModelScope.launch {
            try {
                val citiesWithWeather = cities.map { city ->
                    async {
                        when (val weatherResult = getCurrentWeatherUseCase(city.id)) {
                            is Result.Success -> CityWithWeather(city, weatherResult.value)
                            is Result.Failure -> CityWithWeather(city, Weather.default)
                        }
                    }
                }.awaitAll()
                _uiState.value = UiState.Success(citiesWithWeather)
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed to load weather data")
            }
        }
    }

    fun removeCity(cityId: Int) {
        viewModelScope.launch {
            when (val result = changeFavouriteStateUseCase.removeFromFavourite(cityId)) {
                is Result.Success -> {
                    _toastMessage.value = "City removed from favorites"
                }

                is Result.Failure -> {
                    _toastMessage.value = "Failed to remove city"
                }
            }
        }
    }
}

