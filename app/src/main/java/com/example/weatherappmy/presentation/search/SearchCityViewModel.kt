package com.example.weatherappmy.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.usecase.AddRemoveFavouriteCityUseCase
import com.example.weatherappmy.domain.usecase.SearchCityUseCase
import com.example.weatherappmy.domain.util.Result
import com.example.weatherappmy.presentation.search.ui.UiStateCitySearch
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchCityViewModel @Inject constructor(
    private val searchCityUseCase: SearchCityUseCase,
    private val addRemoveFavouriteCityUseCase: AddRemoveFavouriteCityUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiStateCitySearch>()
    val cities: LiveData<UiStateCitySearch> get() = _uiState

    private val _errorState = MutableLiveData<String>()
    val errorState: LiveData<String> get() = _errorState

    fun searchCity(query: String) {
        _uiState.value = UiStateCitySearch.Loading
        viewModelScope.launch {
            when(val result = searchCityUseCase(query)){
                is Result.Failure -> TODO()
                is Result.Success -> TODO()
            }
        }
    }

    fun addCityToFavourites(city: City) {
        viewModelScope.launch {
            when (val remove = addRemoveFavouriteCityUseCase.addToFavourite(city)) {
                is Result.Success -> _errorState.value = SUCCESS_ADD
                is Result.Failure -> _errorState.value = ERROR_ADD_CITY
            }
        }
    }

    companion object {
        private const val SUCCESS_ADD = "Город добавлен в избранное"
        private const val ERROR_ADD_CITY = "Ошибка при добавлении города"
        private const val ERROR_DOWNLOAD_CITY = "Ошибка при загрузке городов"
        private const val ERROR_WHILE_SEARCHING = "Ошибка поиска"

    }


}