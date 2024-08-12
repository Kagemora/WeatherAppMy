package com.example.weatherappmy.di.module

import androidx.lifecycle.ViewModel
import com.example.weatherappmy.di.annotation.ViewModelKey
import com.example.weatherappmy.presentation.favorites.FavouritesCityViewModel
import com.example.weatherappmy.presentation.search.SearchCityViewModel
import com.example.weatherappmy.presentation.weather.CurrentWeatherViewModel
import com.example.weatherappmy.presentation.weather.DailyWeatherViewModel
import com.example.weatherappmy.presentation.weather.HourlyWeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CurrentWeatherViewModel::class)
    fun bindCurrentWeatherViewModel(currentWeatherViewModel: CurrentWeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DailyWeatherViewModel::class)
    fun bindDailyWeatherViewModel(dailyWeatherViewModel: DailyWeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HourlyWeatherViewModel::class)
    fun bindDailyWeatherViewModel(hourlyWeatherViewModel: HourlyWeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchCityViewModel::class)
    fun bindDailyWeatherViewModel(searchCityViewModel: SearchCityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavouritesCityViewModel::class)
    fun bindDailyWeatherViewModel(favouritesCityViewModel: FavouritesCityViewModel): ViewModel


}