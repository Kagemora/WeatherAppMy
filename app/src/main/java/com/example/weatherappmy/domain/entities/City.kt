package com.example.weatherappmy.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class City(
    val id: Int,
    val name: String,
    val country: String
)
