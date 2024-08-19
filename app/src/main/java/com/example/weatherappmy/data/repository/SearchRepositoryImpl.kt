package com.example.weatherappmy.data.repository


import com.example.weatherappmy.data.mapper.toEntities
import com.example.weatherappmy.data.network.WeatherApi
import com.example.weatherappmy.data.util.safeCall
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.SearchRepository
import com.example.weatherappmy.domain.util.Result
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : SearchRepository {

    override suspend fun search(query: String): Result<List<City>> {
        return safeCall {
            api.loadSearchCity(query).toEntities()
        }
    }

}