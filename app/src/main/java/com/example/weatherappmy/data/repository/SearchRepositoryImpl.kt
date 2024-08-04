package com.example.weatherappmy.data.repository

import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(

) : SearchRepository{
    override suspend fun search(query: String): List<City> {
        TODO("Not yet implemented")
    }
}