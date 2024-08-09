package com.example.weatherappmy.di.module

import dagger.Module

@Module(includes = [ApiModule::class, DbModule::class])
object DataModule