package com.example.weatherappmy.presentation.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.entities.CityWithWeather
import com.example.weatherappmy.domain.entities.CurrentWeather
import com.example.weatherappmy.domain.usecase.AddRemoveFavouriteCityUseCase
import com.example.weatherappmy.domain.usecase.GetCurrentWeatherUseCase
import com.example.weatherappmy.domain.usecase.GetFavouriteCitiesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.weatherappmy.domain.util.Result
import com.example.weatherappmy.presentation.favorites.ui.UIState

class FavouritesCityViewModel @Inject constructor(
    private val getFavouriteCitiesUseCase: GetFavouriteCitiesUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val addRemoveFavouriteCityUseCase: AddRemoveFavouriteCityUseCase
) : ViewModel() {


    private val _favouriteCitiesState = MutableLiveData<UIState>()
    val favouriteCitiesState: LiveData<UIState> get() = _favouriteCitiesState

    private val _errorState = MutableLiveData<String>()
    val errorState: LiveData<String> get() = _errorState

    init {
        loadFavouriteCities()
    }

    private fun loadFavouriteCities() {
        _favouriteCitiesState.value = UIState.Loading
        getFavouriteCitiesUseCase().observeForever { result ->
            when (result) {
                is Result.Success -> {
                    viewModelScope.launch {
                        val citiesWithWeather = result.value.map { city ->
                            val weather =
                                getWeatherForCity(city.id)
                            CityWithWeather(city, weather)
                        }
                        _favouriteCitiesState.value = UIState.Success(citiesWithWeather)
                    }
                }

                is Result.Failure -> {
                    _errorState.value = result.error.message ?: ERROR_DOWNLOAD_CITY
                }
            }
        }
    }

    private suspend fun getWeatherForCity(cityId: Int): CurrentWeather {
        return when (val result = getCurrentWeatherUseCase(cityId)) {
            is Result.Success -> result.value
            is Result.Failure -> CurrentWeather.default
        }
    }

    fun removeCityFromFavourites(cityId: Int) {
        viewModelScope.launch {
            when (val add = addRemoveFavouriteCityUseCase.removeFromFavourite(cityId)){
                is Result.Success -> loadFavouriteCities()
                is Result.Failure -> _errorState.value = ERROR_REMOVE_CITY
            }

        }
    }

    fun addCityToFavourites(city: City) {
        viewModelScope.launch {
           when(val remove = addRemoveFavouriteCityUseCase.addToFavourite(city)){
               is Result.Success -> loadFavouriteCities()
               is Result.Failure -> _errorState.value = ERROR_ADD_CITY
           }
        }
    }
    companion object{
        private const val ERROR_ADD_CITY = "Ошибка при добавлении города"
        private const val ERROR_REMOVE_CITY = "Ошибка при удалении города"
        private const val ERROR_DOWNLOAD_CITY = "Ошибка при загрузке городов"
    }
}

