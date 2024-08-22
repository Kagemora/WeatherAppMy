package com.example.weatherappmy.presentation.search.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherappmy.domain.entities.City

class CitySearchDiffCallback : DiffUtil.ItemCallback<City>() {
    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.id == newItem.id
    }
}