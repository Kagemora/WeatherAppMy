package com.example.weatherappmy.data.repository

import com.example.weatherappmy.data.mapper.toEntities
import com.example.weatherappmy.data.network.WeatherApi
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : SearchRepository{
    override suspend fun search(query: String): List<City> {
        return api.loadSearchCity(query).toEntities()
    }
}