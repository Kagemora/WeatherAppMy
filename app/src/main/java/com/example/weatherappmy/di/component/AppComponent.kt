package com.example.weatherappmy.di.component

import android.content.Context
import com.example.weatherappmy.di.annotation.ApplicationScope
import com.example.weatherappmy.di.module.BindsRepositoryModule
import com.example.weatherappmy.di.module.DataModule
import com.example.weatherappmy.di.module.ViewModelModule
import com.example.weatherappmy.presentation.favorites.FavouritesCityFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@ApplicationScope
@Component(modules = [DataModule::class, BindsRepositoryModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(fragment: FavouritesCityFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }

}