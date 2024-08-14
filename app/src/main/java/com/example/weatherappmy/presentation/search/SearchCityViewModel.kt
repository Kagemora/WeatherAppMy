package com.example.weatherappmy.presentation.search

import androidx.lifecycle.ViewModel
import com.example.weatherappmy.domain.usecase.SearchCityUseCase
import javax.inject.Inject

class SearchCityViewModel @Inject constructor(
    private val searchCityUseCase: SearchCityUseCase
) : ViewModel() {

}