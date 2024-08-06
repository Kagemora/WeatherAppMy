package com.example.weatherappmy.data.mapper

import com.example.weatherappmy.data.network.model.citysearch.CityDto
import com.example.weatherappmy.domain.entities.City

fun CityDto.toEntity(): City = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }