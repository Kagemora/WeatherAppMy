package com.example.weatherappmy.domain.repository

import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.util.Result

interface SearchRepository {

    suspend fun search(query: String): Result<List<City>>

}