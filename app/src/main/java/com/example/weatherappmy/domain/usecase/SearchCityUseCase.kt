package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.SearchRepository
import com.example.weatherappmy.domain.util.Result
import javax.inject.Inject


class SearchCityUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(query: String): Result<List<City>> = repository.search(query)
}