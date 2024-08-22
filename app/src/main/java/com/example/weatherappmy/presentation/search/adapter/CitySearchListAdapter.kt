package com.example.weatherappmy.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.weatherappmy.databinding.ListCitySearchBinding
import com.example.weatherappmy.domain.entities.City
import javax.inject.Inject


class CitySearchListAdapter @Inject constructor() :
    ListAdapter<City, CitySearchViewHolder>(CitySearchDiffCallback()) {

    var onClickCity: ((City) -> Unit)? = null

    override fun onBindViewHolder(holder: CitySearchViewHolder, position: Int) {
        getItem(position).also { city ->
            with(holder.binding) {
                textViewCity.text = city.name
                textViewCountry.text = city.country
                root.setOnClickListener {
                    onClickCity?.invoke(city)
                }
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