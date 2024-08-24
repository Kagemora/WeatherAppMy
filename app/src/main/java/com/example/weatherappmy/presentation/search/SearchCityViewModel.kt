package com.example.weatherappmy.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.usecase.ChangeFavouriteStateUseCase
import com.example.weatherappmy.domain.usecase.SearchCityUseCase
import com.example.weatherappmy.domain.util.Result
import com.example.weatherappmy.presentation.search.ui.UiStateCitySearch
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchCityViewModel @Inject constructor(
    private val searchCityUseCase: SearchCityUseCase,
    private val changeFavouriteStateUseCase: ChangeFavouriteStateUseCase
) : ViewModel() {

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    private val _uiState = MutableLiveData<UiStateCitySearch>()
    val uiState: LiveData<UiStateCitySearch> get() = _uiState

    fun searchCity(query: String) {
        _uiState.value = UiStateCitySearch.Loading
        viewModelScope.launch {
            when (val result = searchCityUseCase(query)) {
                is Result.Success -> {
                    _uiState.value = UiStateCitySearch.Success(result.value)
                }

                is Result.Failure -> {
                    _uiState.value = UiStateCitySearch.Error("Error searching city")
                }
            }
        }
    }

    fun addFavourite(city: City) {
        viewModelScope.launch {
            when (val addCity = changeFavouriteStateUseCase.addToFavourite(city)) {
                is Result.Failure -> {
                    _message.value = "Error adding city"
                }

                is Result.Success -> {
                    _message.value = "City added successfully"
                }
            }

        }

    }

}