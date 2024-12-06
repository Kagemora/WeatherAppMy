package com.example.weatherappmy.domain.usecase

import com.example.weatherappmy.domain.repository.FavouriteRepository
import javax.inject.Inject

//добавлен ли город в избранное
class ObserveFavouriteStateUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {
    operator fun invoke(cityId: Int) = repository.isCityFavourite(cityId)
}