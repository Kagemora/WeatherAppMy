package com.example.weatherappmy.presentation.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.usecase.AddRemoveFavouriteCityUseCase
import com.example.weatherappmy.domain.usecase.GetCurrentWeatherUseCase
import com.example.weatherappmy.domain.usecase.GetFavouriteCitiesUseCase
import com.example.weatherappmy.domain.util.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouriteCitiesViewModel @Inject constructor(
    private val getFavouriteCitiesUseCase: GetFavouriteCitiesUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val addRemoveFavouriteCityUseCase: AddRemoveFavouriteCityUseCase
) : ViewModel() {



    fun addCityToFavourites(city: City){
        viewModelScope.launch {
            when(val add = addRemoveFavouriteCityUseCase.addToFavourite(city)){
                is Result.Failure -> TODO()
                is Result.Success -> TODO()
            }
        }
    }

    companion object{
        private const val ERROR_ADD_CITY = "Ошибка при добавлении города"
        private const val ERROR_REMOVE_CITY = "Ошибка при удалении города"
        private const val ERROR_DOWNLOAD_CITY = "Ошибка при загрузке городов"
    }

}