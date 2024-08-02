package com.example.weatherappmy.domain.repository

import com.example.weatherappmy.domain.entities.City

interface SearchRepository {
    suspend fun search(query:String): List<City>
}