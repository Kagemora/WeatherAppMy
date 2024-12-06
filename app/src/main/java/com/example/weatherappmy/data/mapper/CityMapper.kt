package com.example.weatherappmy.data.mapper

import com.example.weatherappmy.data.cache.model.CityDbModel
import com.example.weatherappmy.data.network.model.CityInfoDto
import com.example.weatherappmy.domain.entities.City
import javax.inject.Inject

class CityMapper @Inject constructor() {

    //favouriteCity
    fun toDbModel(city: City): CityDbModel = CityDbModel(
        id = city.id,
        name = city.name,
        country = city.country
    )

    private fun toEntity(cityDbModel: CityDbModel): City = City(
        id = cityDbModel.id,
        name = cityDbModel.name,
        country = cityDbModel.country
    )

    fun toEntitiesFromDb(list: List<CityDbModel>): List<City> = list.map { toEntity(it) }

    //searchCity
    private fun toEntity(cityInfoDto: CityInfoDto): City = City(
        id = cityInfoDto.id,
        name = cityInfoDto.name,
        country = cityInfoDto.country
    )

    fun toEntitiesFromDto(list: List<CityInfoDto>): List<City> = list.map { toEntity(it) }
}