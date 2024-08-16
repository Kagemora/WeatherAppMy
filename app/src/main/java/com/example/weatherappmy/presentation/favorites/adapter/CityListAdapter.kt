package com.example.weatherappmy.presentation.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.weatherappmy.databinding.ListItemBinding
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.presentation.favorites.ui.CityWithWeather


class CityListAdapter : ListAdapter<CityWithWeather, CityItemViewHolder>(CityItemDiffCallback()) {
    override fun onBindViewHolder(holder: CityItemViewHolder, position: Int) {
        getItem(position).also { city ->
            with(holder.binding) {
                cityName.text = city.city.name
                temperatureText.text = city.weather.time.toString()
                Glide.with(weatherIcon.context)
                    .load(city.weather.conditionUrl)
                    .into(weatherIcon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityItemViewHolder {
        val view = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CityItemViewHolder(view)
    }

}