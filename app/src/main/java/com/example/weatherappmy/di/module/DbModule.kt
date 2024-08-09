package com.example.weatherappmy.di.module

import android.content.Context
import com.example.weatherappmy.data.cache.AppDatabase
import com.example.weatherappmy.data.cache.FavouriteCityDao
import com.example.weatherappmy.di.annotation.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
object  DbModule {

    @ApplicationScope
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context.applicationContext)
    }

    @ApplicationScope
    @Provides
    fun provideFavouriteCityDao(appDatabase: AppDatabase): FavouriteCityDao {
        return appDatabase.favouriteCityDao()
    }
}