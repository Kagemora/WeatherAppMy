package com.example.weatherappmy.domain.usecase

import androidx.lifecycle.LiveData
import com.example.weatherappmy.domain.repository.FavouriteRepository
import com.example.weatherappmy.domain.util.Result
import javax.inject.Inject


class ObserveFavouriteStateUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {
    operator fun invoke(cityId: Int): LiveData<Result<Boolean>> = repository.isCityFavourite(cityId)
}