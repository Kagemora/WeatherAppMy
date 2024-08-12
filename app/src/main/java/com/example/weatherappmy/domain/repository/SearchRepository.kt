package com.example.weatherappmy.domain.repository

import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.util.Resource

interface SearchRepository {
    suspend fun search(query: String): Resource<List<City>>
}