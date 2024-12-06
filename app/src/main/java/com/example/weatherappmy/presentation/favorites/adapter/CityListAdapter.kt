package com.example.weatherappmy.presentation.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.weatherappmy.databinding.ListItemBinding
import com.example.weatherappmy.presentation.favorites.ui.CityWithWeather


class CityListAdapter(
    private var onCityWithWeatherClickListener: ((CityWithWeather) -> Unit)? = null
) :
    ListAdapter<CityWithWeather, CityItemViewHolder>(CityItemDiffCallback()) {

    override fun onBindViewHolder(holder: CityItemViewHolder, position: Int) {
        val city = getItem(position)
        with(holder.binding) {
            cityName.text = city.city.name
            temperatureText.text = city.currentWeather.tempC.toString()
            Glide.with(weatherIcon.context)
                .load(city.currentWeather.conditionUrl)
                .into(weatherIcon)
            root.setOnClickListener {
                onCityWithWeatherClickListener?.invoke(city)
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