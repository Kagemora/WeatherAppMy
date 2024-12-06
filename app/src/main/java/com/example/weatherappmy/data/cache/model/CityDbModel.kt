package com.example.weatherappmy.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_city")
data class CityDbModel(
    @PrimaryKey
    val id: Int,
    val name: String,
    val country: String
)

