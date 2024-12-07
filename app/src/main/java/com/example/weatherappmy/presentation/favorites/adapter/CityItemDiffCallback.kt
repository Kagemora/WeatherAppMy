package com.example.weatherappmy.presentation.favorites.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherappmy.domain.entities.CityWithWeather

class CityItemDiffCallback : DiffUtil.ItemCallback<CityWithWeather>() {
    override fun areContentsTheSame(oldItem: CityWithWeather, newItem: CityWithWeather): Boolean {
        return oldItem.city.id == newItem.city.id
    }

    override fun areItemsTheSame(oldItem: CityWithWeather, newItem: CityWithWeather): Boolean {
        return oldItem == newItem
    }
}