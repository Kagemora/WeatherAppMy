package com.example.weatherappmy.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.weatherappmy.databinding.ListCitySearchBinding
import com.example.weatherappmy.domain.entities.City


class CitySearchListAdapter(
    var onClickCity: ((City) -> Unit)? = null
) : ListAdapter<City, CitySearchViewHolder>(CitySearchDiffCallback()) {


    override fun onBindViewHolder(holder: CitySearchViewHolder, position: Int) {
        val city = getItem(position)
        with(holder.binding) {
            textViewCity.text = city.name
            textViewCountry.text = city.country
            root.setOnClickListener {
                onClickCity?.invoke(city)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitySearchViewHolder {
        val view = ListCitySearchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CitySearchViewHolder(view)
    }
}