package com.example.weatherappmy.di.component

import android.content.Context
import com.example.weatherappmy.di.annotation.ApplicationScope
import com.example.weatherappmy.di.module.BindsRepositoryModule
import com.example.weatherappmy.di.module.DataModule
import com.example.weatherappmy.di.module.ViewModelModule
import com.example.weatherappmy.presentation.favorites.FavouritesCityFragment
import com.example.weatherappmy.presentation.search.SearchCityFragment
import com.example.weatherappmy.presentation.weather.CurrentWeatherFragment
import com.example.weatherappmy.presentation.weather.DailyWeatherFragment
import com.example.weatherappmy.presentation.weather.HourlyWeatherFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@ApplicationScope
@Component(modules = [DataModule::class, BindsRepositoryModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(fragment: FavouritesCityFragment)
    fun inject(fragment: SearchCityFragment)
    fun inject(fragment: CurrentWeatherFragment)
    fun inject(fragment: HourlyWeatherFragment)
    fun inject(fragment: DailyWeatherFragment)


    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }

}