package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.repository.SearchRepository
import javax.inject.Inject

//поиск города
class SearchCityUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(query: String) = repository.search(query)
}