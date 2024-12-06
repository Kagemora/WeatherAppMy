package com.example.weatherappmy.data.network.model

import com.google.gson.annotations.SerializedName

data class CityInfoDto(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("country")
    var country: String
)
