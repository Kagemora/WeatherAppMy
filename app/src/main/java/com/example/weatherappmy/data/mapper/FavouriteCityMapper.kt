package com.example.weatherappmy.data.mapper

import com.example.weatherappmy.data.cache.model.CityDbModel
import com.example.weatherappmy.domain.entities.City

fun City.toDbModel(): CityDbModel = CityDbModel(id, name, country)

fun CityDbModel.toEntity(): City = City(id, name, country)

fun List<CityDbModel>.toEntities(): List<City> = map { it.toEntity() }